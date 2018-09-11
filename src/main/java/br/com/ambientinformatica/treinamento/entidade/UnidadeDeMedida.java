package br.com.ambientinformatica.treinamento.entidade;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import br.com.ambientinformatica.util.Entidade;

@Entity
public class UnidadeDeMedida extends Entidade implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "unidadedemedida_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "unidadedemedida_seq", sequenceName = "unidadedemedida_seq", allocationSize = 1, initialValue = 1)
	private Integer id;

	private String descricao;

	private String sigla;

	@Override
	public Object getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

}
