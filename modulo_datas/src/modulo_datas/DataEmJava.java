package modulo_datas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DataEmJava {

	public static void main(String[] args) throws ParseException {
		
		Date date = new Date();
		System.out.println("Utilizando date");
		System.out.println("Data em milisegundos:" + date.getTime());
		System.out.println("Dia do Mês:" + date.getDate());
		System.out.println("Semana:" + date.getDay());
		System.out.println("Hora do dia:" + date.getHours());
		System.out.println("Minuto:" + date.getMinutes());
		System.out.println("Segundos:" + date.getSeconds());
		System.out.println("Ano:" + (date.getYear() + 1900));
		
		//---------------------simple date format--------------------------------
		System.out.println(" ");
		System.out.println("simple date format");
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("Data atual em String:" + simpleDateFormat.format(date));
		
        simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		System.out.println("Data atual em String com segundos:" + simpleDateFormat.format(date));
		
		simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:SS");
		System.out.println("Data atual em String com segundos com três casas decimais:" + simpleDateFormat.format(date));
		
		simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(" ");
		System.out.println("Data formato de banco de dados:" + simpleDateFormat.format(date));
		
		System.out.println("Utilizando o simpleDateFormat.parse para trabalhar com o Objeto data");	
		System.out.println(simpleDateFormat.parse("1987-10-18"));//objeto de datas
		simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");//objeto de datas com formato brasil
		System.out.println(simpleDateFormat.parse("18/10/1987"));//objeto de datas com formato brasil
		
	//data utilizando Calendar
		
		Calendar calendar = Calendar.getInstance();
		
		System.out.println("Utilizando o Calendar");
		System.out.println(" ");
		System.out.println("Calendar em milisegundos:" +  calendar.getTimeInMillis());
		System.out.println("Calendar Dia do Mês:" + calendar.get(Calendar.DAY_OF_MONTH));
		System.out.println("Calendar Semana:" + (calendar.get(Calendar.DAY_OF_WEEK) -1));//calendar diferente da date.util tem que subtrair 1 
		System.out.println("Hora do dia:" + calendar.get(Calendar.HOUR_OF_DAY));
		System.out.println("Minuto:" + calendar.get(Calendar.MINUTE));
		System.out.println("Segundos:" +calendar.get(Calendar.SECOND));
		System.out.println("Ano:" +calendar.get(Calendar.YEAR));
		
		//---------------------simple date format com calendar--------------------------------
				System.out.println(" ");
				System.out.println("simple date format com Calendar");
				
				simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
				System.out.println("Data atual em String:" + simpleDateFormat.format(calendar.getTime()));
				simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:SS");
				System.out.println("Data atual em String com segundos:" + simpleDateFormat.format(calendar.getTime()));
				
				simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:SS");
				System.out.println("Data atual em String com segundos com três casas decimais:" + simpleDateFormat.format(calendar.getTime()));
				
				simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
				System.out.println("Data formato de banco de dados:" + simpleDateFormat.format(calendar.getTime()));
				System.out.println(" ");
				
				
	
	
	}

}
