package br.com.ambientinformatica.treinamento.entidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.hibernate.validator.constraints.NotEmpty;

import br.com.ambientinformatica.util.AmbientValidator;
import br.com.ambientinformatica.util.Entidade;

@Entity
public class Produto extends Entidade implements Serializable{

   private static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue(generator="produto_seq", strategy=GenerationType.SEQUENCE)
   @SequenceGenerator(name="produto_seq", sequenceName="produto_seq", allocationSize=1, initialValue=1)
   private Integer id;

   @Column(nullable=false)
   @NotEmpty(message="Código do produto obrigatório", groups=AmbientValidator.class)
   private String codigo;

   @Column(nullable=false)
   @NotEmpty(message="Descrição do produto obrigatória", groups=AmbientValidator.class)
   private String descricao;

   public String getCodigo() {
      return codigo;
   }

   public void setCodigo(String codigo) {
      this.codigo = codigo;
   }

   public String getDescricao() {
      return descricao;
   }

   public void setDescricao(String descricao) {
      this.descricao = descricao;
   }

   public Integer getId() {
      return id;
   }

}
