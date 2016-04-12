package br.com.diegomauricio.predojo.ejb;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import br.com.diegomauricio.predojo.dao.PartidaDAO;
import br.com.diegomauricio.predojo.model.Jogador;
import br.com.diegomauricio.predojo.model.Partida;

/**
 * Classe responsável por chamar o DAO da partida
 * 
 * @author Diego
 *
 */
public class PartidaEJB {

	private PartidaDAO partidaDAO = new PartidaDAO();

	/**
	 * Método responsável por salvar as partidas realizadas
	 * 
	 * @param partidas
	 *            salva as partidas realizadas
	 */
	public String salvarPartidas(Set<Partida> partidas) {
		Iterator<Partida> carrosAsIterator = partidas.iterator();
		while (carrosAsIterator.hasNext()) {
			Partida partida = carrosAsIterator.next();
			partidaDAO.salvarPartida(partida);
			return "salvo com sucesso";
		}
		return "não existe registro para salvar";
	}

	/**
	 * Buscar e exibir as partidas armazendas
	 */
	public Map<Long, Partida> buscarPartidas() {
		Map<Long, Partida> partidas = partidaDAO.buscarPartidas();
		for (Long key : partidas.keySet()) {
			long cdPartida = key.longValue();
			Partida partida = partidas.get(cdPartida);
			System.out.println("Partida: " + partida.getCdPartida());
			for (Jogador jogador : partida.getJogadores()) {
				System.out.print(jogador.getNome() + " - Assasinato(s): "
						+ jogador.getQtdAssassinatosPartida());
				System.out.println(" Morte(s): " + jogador.getQtdMortesPartida());

			}
		}
		return partidas;
	}

}
