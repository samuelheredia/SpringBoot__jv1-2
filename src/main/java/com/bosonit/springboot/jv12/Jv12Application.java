package com.bosonit.springboot.jv12;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Jv12Application {

	public static void main(String[] args){
		File archive;
		FileReader fr = null;
		BufferedReader br;
		List<Persona> personas = new ArrayList<>();

		try {
			// Lectura corriente de fichero
			archive = new File ("fich.txt");
			fr = new FileReader (archive);
			br = new BufferedReader(fr);
			String linea;
			while( (linea = br.readLine() ) != null)
				personas.add( new Persona(linea));

			// Localiza mediante stream menores 25 (edad null = 26)
			personas.parallelStream()
					.filter(p -> p.getEdad().orElse(99) < 25)
					.forEach( p -> System.out.println( p ));
		}
		catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if( null != fr ){
					fr.close();
				}
			}catch (Exception e2){
				e2.printStackTrace();
			}
		}

	}

}
