package projPessoas;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Pessoa {
	UUID id;
	String nome;
	String endereco;
	List<String> telefones;

	public Pessoa() {
		this.id = UUID.randomUUID();
		this.nome = "";
		this.endereco = "";
		this.telefones = new ArrayList<String>();
	}

	public Pessoa(String nome, String endereco, ArrayList<String> telefones) {
		this.id = UUID.randomUUID();
		this.nome = nome;
		this.endereco = endereco;
		this.telefones = new ArrayList<String>();
		this.telefones.addAll(telefones);
	}

	public String getDados() {
		String fones = "";
		for (String fone : this.telefones) {
			fones = fones + fone + " | ";
		}
		String resp = "Identificador: " + this.id + System.lineSeparator() + "Nome: " + this.nome
				+ System.lineSeparator() + "Endereço: " + this.endereco + System.lineSeparator() + "Telefones: "
				+ fones;
		return resp;
	}

}
