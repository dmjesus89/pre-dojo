package br.com.diegomauricio.predojo.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;

import br.com.diegomauricio.predojo.exception.PreDojoException;
import br.com.diegomauricio.predojo.model.Partida;
import br.com.diegomauricio.predojo.model.TipoLinhaEnum;
import br.com.diegomauricio.predojo.parser.LogParser;

/**
 * Classe responsável por popular o objeto da partida
 * 
 * @author Diego
 *
 */
public class PartidaImpl {

	/**
	 * Método responsável por processar as informações dentro do arquivo
	 * 
	 * @param arquivo
	 *            arquivo de log
	 * @return
	 * @throws IOException
	 *             erro na leitura do arquivo
	 */
	public final Set<Partida> processarLog(File arquivo) throws IOException {

		final Set<Partida> partidas = new HashSet<Partida>();
		try {
			Partida partida = null;
			FileInputStream stream = new FileInputStream(arquivo);
			InputStreamReader reader = new InputStreamReader(stream);
			BufferedReader br = new BufferedReader(reader);
			String linha = br.readLine();
			while (linha != null && !linha.isEmpty()) {
				partida = processarLinhaAtual(linha, partida);
				partidas.add(partida);
				linha = br.readLine();
			}
			br.close();
			reader.close();
			stream.close();
		} catch (Exception e) {
			throw new PreDojoException("Erro ao processar linhas do Log");
		} finally {
		}

		return partidas;
	}

	/**
	 * Processar a linha atual
	 * 
	 * @param linha
	 *            linha atual do arquivo log
	 * @param partidaAtual
	 *            partida corrente
	 * @return a partida populada
	 * @throws ParseException
	 *             erro de parse
	 */
	private Partida processarLinhaAtual(String linha, Partida partida) throws ParseException {
		TipoLinhaEnum tipoLinha = getTipoDaLinha(linha);
		Partida parser = LogParser.getParser(tipoLinha, linha, partida);
		return parser;
	}

	/**
	 * Método responsável por retornar o tipo de enum para linha correspondente
	 * 
	 * @param linha
	 *            linha atual
	 * @return retona o enum corresponde da linha atual
	 */
	private TipoLinhaEnum getTipoDaLinha(String linha) {
		for (TipoLinhaEnum tipoLinha : TipoLinhaEnum.values()) {
			Matcher matcher = tipoLinha.getPattern().matcher(linha);
			if (matcher.matches()) {
				return tipoLinha;
			}
		}
		return null;
	}
}