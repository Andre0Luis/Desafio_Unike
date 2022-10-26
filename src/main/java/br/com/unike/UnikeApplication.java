package br.com.unike;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SpringBootApplication
public class UnikeApplication {

	public static void main(String[] args) {
		SpringApplication.run(UnikeApplication.class, args);

		List<Integer> lista = new ArrayList<>();
		lista.add(5);
		lista.add(2);
		lista.add(2);
		lista.add(2);
		lista.add(1);
		lista.add(7);
		lista.add(1);

		listaOrdenada(lista);
		listaDesordenada(lista);
	}

	//Primeiro Objetivo do teste prático
	public static void listaOrdenada(List<Integer> lista) {
		List<Integer> lista_unicos = new ArrayList<>();
		List<Integer> lista_repetidos = new ArrayList<>();

		for (int item : lista) {
			if (!lista_unicos.contains(item)) {
				lista_unicos.add(item);
			} else {
				lista_repetidos.add(item);

			}
		}
		System.out.println("Primeiro Objetivo \n Lista Ordenada: " + lista_repetidos);
	}

	//Segundo Objetivo do teste prático
	public static void listaDesordenada(List<Integer> lista) {
		Collections.sort(lista);
		List<Integer> lista_unicos = new ArrayList<>();
		List<Integer> lista_repetidos = new ArrayList<>();

		for (int item : lista) {
			if (!lista_unicos.contains(item)) {
				lista_unicos.add(item);
			} else {
				lista_repetidos.add(item);
			}
		}
		System.out.println("Segundo Objetivo \n Lista Desordenada: " + lista_repetidos);
	}



}
