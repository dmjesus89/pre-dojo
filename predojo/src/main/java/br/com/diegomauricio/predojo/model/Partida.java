package br.com.diegomauricio.predojo.model;

import java.util.Date;
import java.util.List;

/**
 * Classe responsável por representar as partidas
 * 
 * @author Diego Mauricio
 *
 */
public class Partida {

	/** código da partida */
	private long cdPartida;
	/** data e hora inicio da partida */
	private Date dataInicio;
	/** data e hora fim da partida */
	private Date dataFim;
	/** lista dos jogadores que participaram da partida */
	private List<Jogador> jogadores;

	/**
	 * Construtor padrão
	 * 
	 */
	public Partida() {
		super();
	}

	/**
	 * Construtor populando o código e a data da partida
	 * 
	 * @param cdPartida
	 *            código da partida
	 * @param dataInicio
	 *            data que iniciou a partida
	 */
	public Partida(long cdPartida, Date dataInicio) {
		this.cdPartida = cdPartida;
		this.dataInicio = dataInicio;
	}

	/**
	 * @return the cdPartida
	 */
	public final long getCdPartida() {
		return this.cdPartida;
	}

	/**
	 * @param cdPartida
	 *            the cdPartida to set
	 */
	public final void setCdPartida(final long cdPartida) {
		this.cdPartida = cdPartida;
	}

	/**
	 * @return the dataInicio
	 */
	public final Date getDataInicio() {
		return this.dataInicio;
	}

	/**
	 * @param dataInicio
	 *            the dataInicio to set
	 */
	public final void setDataInicio(final Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	/**
	 * @return the dataFim
	 */
	public final Date getDataFim() {
		return this.dataFim;
	}

	/**
	 * @param dataFim
	 *            the dataFim to set
	 */
	public final void setDataFim(final Date dataFim) {
		this.dataFim = dataFim;
	}

	/**
	 * @return the jogadores
	 */
	public final List<Jogador> getJogadores() {
		return this.jogadores;
	}

	/**
	 * @param jogadores
	 *            the jogadores to set
	 */
	public final void setJogadores(final List<Jogador> jogadores) {
		this.jogadores = jogadores;
	}

}
