package projPessoas;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class Principal {

	public static void main(String[] args) throws IOException {

		System.out.println("Teste");

		Pessoa p1 = new Pessoa();
		System.out.println( p1.getDados() );
		JSONArray listaPessoas =  abreArquivo("/Users/erfelipe/eclipse-workspace/projPessoas/src/main/resources/Pessoas.json");
		ArrayList<Pessoa> pessoasDoArq =  trataPessoasFromJson(listaPessoas);
		for (Pessoa pessoa : pessoasDoArq) {
			System.out.println(pessoa.getDados());
		}
	}

	public static JSONArray abreArquivo(String arq) throws IOException {
		Path filePath = Path.of(arq); 
		String content = Files.readString(filePath);
		JSONArray arrayJson = new JSONArray( content );  
		System.out.println(content);
		return arrayJson;
	}
	
	public static ArrayList<Pessoa> trataPessoasFromJson(JSONArray objetosJson) {
		ArrayList<Pessoa> listaDePessoas = new ArrayList<Pessoa>();
		for (int i = 0; i < objetosJson.length() ; i++) {
			JSONObject jsonObj = objetosJson.getJSONObject(i);
			String nome = jsonObj.getString("nome");
			String endereco = jsonObj.getString("endereco");
			JSONObject fones = jsonObj.getJSONObject("telefones");
			ArrayList<String> telefones = new ArrayList<String>();
			telefones.add(fones.getString("fixo"));
			telefones.add(fones.getString("celular"));

			Pessoa p = new Pessoa(nome, endereco, telefones );
			listaDePessoas.add(p);
		}//for
		return listaDePessoas;
	}
	
}
