/**
 * 
 */
package br.com.diegomauricio.predojo.model;

/**
 * Classe responável por representar o jogador da partida
 * 
 * @author Diego Mauricio
 *
 */
public class Jogador {

	/**
	 * Construtor padrão
	 */
	public Jogador() {
		super();
	}

	/**
	 * construtor populando o nome
	 * 
	 * @param nome
	 */
	public Jogador(String nome) {
		this.nome = nome;
	}

	/** nome do jogador */
	private String nome;
	/** código do jogador */
	private long cdJogador;
	/** quantos assassinatos o jogador realizou por partida */
	private int qtdAssassinatosPartida;
	/** quantos vezes o jogador morreu na partida */
	private int qtdMortesPartida;

	/**
	 * @return the nome
	 */
	public final String getNome() {
		return this.nome;
	}

	/**
	 * @param nome
	 *            the nome to set
	 */
	public final void setNome(final String nome) {
		this.nome = nome;
	}

	/**
	 * @return the cdJogador
	 */
	public final long getCdJogador() {
		return this.cdJogador;
	}

	/**
	 * @param cdJogador
	 *            the cdJogador to set
	 */
	public final void setCdJogador(final long cdJogador) {
		this.cdJogador = cdJogador;
	}

	/**
	 * @return the qtdAssassinatosPartida
	 */
	public final int getQtdAssassinatosPartida() {
		return this.qtdAssassinatosPartida;
	}

	/**
	 * @param qtdAssassinatosPartida
	 *            the qtdAssassinatosPartida to set
	 */
	public final void setQtdAssassinatosPartida(final int qtdAssassinatosPartida) {
		this.qtdAssassinatosPartida = qtdAssassinatosPartida;
	}

	/**
	 * @return the qtdMortesPartida
	 */
	public final int getQtdMortesPartida() {
		return this.qtdMortesPartida;
	}

	/**
	 * @param qtdMortesPartida
	 *            the qtdMortesPartida to set
	 */
	public final void setQtdMortesPartida(final int qtdMortesPartida) {
		this.qtdMortesPartida = qtdMortesPartida;
	}

}
