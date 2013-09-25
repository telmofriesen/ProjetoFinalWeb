package inscricao.persistence.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Revendedor.class)
public abstract class Revendedor_ {

	public static volatile SingularAttribute<Revendedor, Regiao> regiaoDeAtuacao;
	public static volatile SingularAttribute<Revendedor, String> cidade;
	public static volatile SingularAttribute<Revendedor, Estado> estado;
	public static volatile SingularAttribute<Revendedor, Estado> estadoDeAtuacao;
	public static volatile SingularAttribute<Revendedor, String> nomeFantasia;
	public static volatile SingularAttribute<Revendedor, String> razaoSocial;
	public static volatile SingularAttribute<Revendedor, Long> cnpj;
	public static volatile SingularAttribute<Revendedor, String> endereco;

}

