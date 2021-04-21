package modulo_datas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataEmJava {

	public static void main(String[] args) throws ParseException {
		
		Date date = new Date();
		
		System.out.println("Data em milisegundos:" + date.getTime());
		System.out.println("Dia do Mês:" + date.getDate());
		System.out.println("Hora do dia:" + date.getHours());
		System.out.println("Minuto:" + date.getMinutes());
		System.out.println("Segundos:" + date.getSeconds());
		System.out.println("Ano:" + (date.getYear() + 1900));
		
		//---------------------simple date format--------------------------------
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("Data atual em String:" + simpleDateFormat.format(date));
		
        simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		System.out.println("Data atual em String com segundos:" + simpleDateFormat.format(date));
		
		simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:SS");
		System.out.println("Data atual em String com segundos com três casas decimais:" + simpleDateFormat.format(date));
		
		simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println("Data formato de banco de dados:" + simpleDateFormat.format(date));
		
		
		
		System.out.println(simpleDateFormat.parse("1987-10-18"));//objeto de datas
		
		simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");//objeto de datas com formato brasil
		System.out.println(simpleDateFormat.parse("18/10/1987"));//objeto de datas com formato brasil
		
	}

}
