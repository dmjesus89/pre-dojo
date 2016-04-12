package br.com.diegomauricio.predojo.dao;

import java.util.HashMap;
import java.util.Map;

import br.com.diegomauricio.predojo.model.Partida;

/**
 * Classe que representa a persistencia das informações na base
 * 
 * @author Diego Mauricio
 *
 */
public class PartidaDAO {

	private static Map<Long, Partida> banco = new HashMap<Long, Partida>();

	/**
	 * Adicionar Partida
	 * 
	 * @param partida
	 *            populada pelo log
	 */
	public Partida salvarPartida(Partida partida) {
		banco.put(partida.getCdPartida(), partida);
		return partida;
	}

	/**
	 * Retornar todas as partidas
	 * 
	 * @return as partidas realizadas
	 */
	public Map<Long, Partida> buscarPartidas() {
		return banco;
	}

}
