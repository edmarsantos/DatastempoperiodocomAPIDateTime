package modulo_datas;

import java.util.Date;

public class DataEmJava {

	public static void main(String[] args) {
		
		Date date = new Date();
		
		System.out.println("Data em milisegundos:" + date.getTime());
		System.out.println("Dia do Mês:" + date.getDate());
		System.out.println("Hora do dia:" + date.getHours());
		System.out.println("Minuto:" + date.getMinutes());
		System.out.println("Segundos:" + date.getSeconds());
		System.out.println("Ano:" + (date.getYear() + 1900));
		
		
		
		
	}

}
