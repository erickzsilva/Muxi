package arquivo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LerAqruivo {
	
	String linha1;
	String linha2;


	public LerAqruivo() {
		
	}
	

	public String getLinha1() {
		return linha1;
	}


	public void setLinha1(String linha1) {
		this.linha1 = linha1;
	}


	public String getLinha2() {
		return linha2;
	}


	public void setLinha2(String linha2) {
		this.linha2 = linha2;
	}


	public void ler() {
		try{
	         BufferedReader arquivo = new BufferedReader(new FileReader("c:/arquivo.txt"));
	        
	        	String linha1 = arquivo.readLine();
	            this.linha1 = linha1;
	            
	            String linha2 = arquivo.readLine();
	            this.linha2 = linha2;
	            
	         
	         arquivo.close();
	      }catch(IOException ex){
	         ex.printStackTrace();
	      }
		
	}

	public static void main(String[] args) {
		LerAqruivo l = new LerAqruivo();
		l.ler();
		System.out.println(l.getLinha2());
	}	

}
