package modulo_datas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

import javax.print.attribute.standard.Chromaticity;

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
				
				//comparando datas
				System.out.println(" ");
				System.out.println("Comparando Datas");
				
				//nova aula
				SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd/MM/yyyy");//declarar o formato desejado
				
				 Date datavencimento = simpleDateFormat2.parse("10/04/2021");
				 
				 Date dataatualhoje = simpleDateFormat2.parse("07/04/2021");
				 System.out.println("data Vencimento " + datavencimento);
				 System.out.println("data atual " + dataatualhoje);
				 if(datavencimento.after(dataatualhoje)) {//comparando se a data maior ou depois da data atual
					 System.out.println("comparação utilizando o after  Boleto em Dia");
				 }else {
					 System.out.println("comparação utilizando o after  Boleto Vencido");
				 }
				 
				 if(datavencimento.before(dataatualhoje)) {//comparando se a data menor ou antes da data atual
					 System.out.println("comparação utilizando o before Boleto Vencido");
				 }else {
					 System.out.println("comparação utilizando o before Boleto em Dia");
				 }
				 
				 
				 //aula 5 calcula de dia mes e ano com calendar
				 
				 Calendar calendar2 = Calendar.getInstance();//por padrao pega a data atual 
				 
				 //simulação de dada pegando do  banco
				 calendar2.setTime(new SimpleDateFormat("dd-MM-yyyy").parse("10-03-2021"));//definindo uma data
				 
				 calendar2.add(calendar2.DAY_OF_MONTH, 15);//vai somar 15 dias  para subtrair colocar o valor negativo
				 System.out.println( "o dia simulado é 10-03-2021 somando 15 dias vai para "+  new SimpleDateFormat("dd-MM-yyyy").format(calendar2.getTime()));
				
				 calendar2.add(calendar2.MONTH, 3);//vai somar 3 meses 
				 System.out.println( "o dia simulado é 10-03-2021 somando 3 meses vai para "+  new SimpleDateFormat("dd-MM-yyyy").format(calendar2.getTime()));
				 
				 calendar2.add(calendar2.YEAR, 2);//vai somar 3 meses  para subtrair colocar o valor negativo
				 System.out.println( "o dia simulado é 10-03-2021 somando 2 anos  vai para "+  new SimpleDateFormat("dd-MM-yyyy").format(calendar2.getTime()));

	
	//trabalhando com faixa de tempo aula 6
				 
				 //ChronoUnit serve para pegar a quantidade de dias  entre uma data e outra
				long dias = ChronoUnit.DAYS.between(LocalDate.parse("2020-02-01"), LocalDate.now());
				System.out.println("Possui "+ dias + " dias entre a faixa de Datas");
				
				long meses = ChronoUnit.MONTHS.between(LocalDate.parse("2021-01-01"), LocalDate.now());
				System.out.println("Possui "+ meses + " meses entre a faixa de Datas");
				
				long semana = ChronoUnit.WEEKS.between(LocalDate.parse("2021-01-01"), LocalDate.now());
				System.out.println("Possui "+ semana + " semanas entre a faixa de Datas");
				
				long ano = ChronoUnit.YEARS.between(LocalDate.parse("2018-01-01"), LocalDate.now());
				System.out.println("Possui "+ ano + " ano entre a faixa de Datas");
	
				// Gerando parcelas mensais e suas datas aula 7
				
	          Date dateinicial = new SimpleDateFormat("dd/MM/yyyy").parse("08/04/2021");
	           
	           Calendar calendar3 = Calendar.getInstance();
	           
	           calendar3.setTime(dateinicial);
	           
	           for(int parcela = 1;parcela <=12;parcela++) { //vai somar as parcelas a cada passada
	        	   calendar3.add(calendar3.MONDAY, 1); //cada vez que ele passar vai acrescentar um mes
	        	   System.out.println("Parcela de número " + parcela + " vencimento em " 
	        	   + new SimpleDateFormat("dd/MM/yyyy").format(calendar3.getTime()));
	        	   
	           }
	           
	           
	           //15.8 - Nova API de Data e Hora do Java  aula 8
	           //Nova Api de data partir do Java 8 utiliza o LocalDate
	           
	           LocalDate dataAtual = LocalDate.now(); //data atual
	           System.out.println(" " );
	           System.out.println("Data atual é " + dataAtual);
	           
	           LocalTime horaAtual = LocalTime.now(); //hora atual
	           System.out.println("Hora atual é " + horaAtual);
	           
	           
	           LocalDateTime dataAtualhoraatual = LocalDateTime.now();
	           System.out.println("Data e Hora atual é " + dataAtualhoraatual);
	           
	           
	           //15.9 - Formatando data e hora com nova API aula 9
	           
	           System.out.println("Data e Hora usando iso_date atual é " + dataAtualhoraatual.format(DateTimeFormatter.ISO_DATE)); //nesse modo não precisa do simpledatetime
	           System.out.println("Data e Hora usando ofPattern atual é  " + dataAtualhoraatual.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));//ofPattern usado para definir o novo padrao
	           System.out.println("Data e Hora usando ofPattern atual é  " + dataAtualhoraatual.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));//ofPattern usado para definir o novo padrao
	           System.out.println("Data e Hora atual é " + dataAtualhoraatual.format(DateTimeFormatter.ofPattern("HH:mm:ss")));
	          
	
	}

}
