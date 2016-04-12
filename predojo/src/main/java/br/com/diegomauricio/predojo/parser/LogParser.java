package br.com.diegomauricio.predojo.parser;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.diegomauricio.predojo.model.Jogador;
import br.com.diegomauricio.predojo.model.Partida;
import br.com.diegomauricio.predojo.model.TipoLinhaEnum;
import br.com.diegomauricio.predojo.util.DataUtil;

/**
 * Classe responsável por popular a partida
 * 
 * @author Diego Mauricio
 *
 */
public class LogParser {

	public static final DataUtil dataUtil = new DataUtil(DataUtil.DDMMYYYY_HHMMSS);
	private static Pattern pattern;
	private static Matcher matcher;

	/**
	 * 
	 * @param tipoLinha
	 *            tipo da linha classificada como enum {@link TipoLinhaEnum}
	 * @param linha
	 *            linha corrente do arquivo
	 * @param partida
	 *            a partida
	 * @return a partida populada com os parser
	 * @throws ParseException
	 *             caso ocorra algum erro no parser
	 */
	public static synchronized Partida getParser(TipoLinhaEnum tipoLinha, String linha,
			Partida partida) throws ParseException {
		if (tipoLinha == TipoLinhaEnum.INICIAR_PARTIDA) {
			pattern = Pattern.compile(TipoLinhaEnum.INICIAR_PARTIDA.getRegex());
			matcher = pattern.matcher(linha);
			if (matcher.find()) {
				Date dataInicio = dataUtil.getData(matcher.group(1));
				long cdPartida = Long.parseLong(matcher.group(4));
				partida = new Partida(cdPartida, dataInicio);
				partida.setJogadores(new ArrayList<Jogador>());
			}

		} else if (tipoLinha == TipoLinhaEnum.JOGADOR_ASSASSINO) {
			pattern = Pattern.compile(TipoLinhaEnum.JOGADOR_ASSASSINO.getRegex());
			matcher = pattern.matcher(linha);
			if (matcher.find()) {

				boolean jaExiste = false;

				if (partida.getJogadores().size() > 0) {
					for (int i = 0; i < partida.getJogadores().size(); i++) {
						Jogador jogador = partida.getJogadores().get(i);
						if (matcher.group(3).equals(jogador.getNome())) {
							partida.getJogadores().get(i)
									.setQtdMortesPartida(jogador.getQtdAssassinatosPartida() + 1);
							jaExiste = true;
							break;
						}
					}
				}

				if (!jaExiste) {
					Jogador jogadorNew = new Jogador(matcher.group(3));
					jogadorNew.setQtdAssassinatosPartida(1);
					partida.getJogadores().add(jogadorNew);
				}

				jaExiste = false;

				if (partida.getJogadores().size() > 0) {
					for (int i = 0; i < partida.getJogadores().size(); i++) {
						Jogador jogador = partida.getJogadores().get(i);
						if (matcher.group(5).equals(jogador.getNome())) {
							partida.getJogadores().get(i)
									.setQtdMortesPartida(jogador.getQtdMortesPartida() + 1);
							jaExiste = true;
							break;
						}
					}
				}

				if (!jaExiste) {
					Jogador jogadorNew = new Jogador(matcher.group(5));
					jogadorNew.setQtdMortesPartida(1);
					partida.getJogadores().add(jogadorNew);
				}
			}

		} else if (tipoLinha == TipoLinhaEnum.WORLD_ASSASINO) {
			pattern = Pattern.compile(TipoLinhaEnum.WORLD_ASSASINO.getRegex());
			matcher = pattern.matcher(linha);
			if (matcher.find()) {

				boolean jaExiste = false;

				if (partida.getJogadores().size() > 0) {
					for (int i = 0; i < partida.getJogadores().size(); i++) {
						Jogador jogador = partida.getJogadores().get(i);
						if (matcher.group(5).equals(jogador.getNome())) {
							partida.getJogadores().get(i)
									.setQtdMortesPartida(jogador.getQtdMortesPartida() + 1);
							jaExiste = true;
							break;
						}
					}
				}

				if (!jaExiste) {
					Jogador jogadorNew = new Jogador(matcher.group(5));
					jogadorNew.setQtdMortesPartida(1);
					partida.getJogadores().add(jogadorNew);
				}

			}

		}

		else if (tipoLinha == TipoLinhaEnum.FINALIZAR_PARTIDA) {
			pattern = Pattern.compile(TipoLinhaEnum.FINALIZAR_PARTIDA.getRegex());
			matcher = pattern.matcher(linha);
			if (matcher.find()) {
				Date dataFim = dataUtil.getData(matcher.group(1));
				partida.setDataFim(dataFim);
			}
		}
		return partida;
	}
}
