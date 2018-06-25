package arquivo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LerAqruivo {
	
	String login;
	String senha;


	public LerAqruivo() {
		
	}
	

	public String getlogin() {
		return login;
	}


	public void setlogin(String login) {
		this.login = login;
	}


	public String getsenha() {
		return senha;
	}


	public void setsenha(String senha) {
		this.senha = senha;
	}


	public void ler() {
		try{
	         BufferedReader arquivo = new BufferedReader(new FileReader("c:/arquivo.txt"));
	        
	        	String login = arquivo.readLine();
	            this.login = login;
	            
	            String senha = arquivo.readLine();
	            this.senha = senha;
	            
	         
	         arquivo.close();
	      }catch(IOException ex){
	         ex.printStackTrace();
	      }
		
	}

	public static void main(String[] args) {
		LerAqruivo l = new LerAqruivo();
		l.ler();
		System.out.println(l.getsenha());
	}	

}
