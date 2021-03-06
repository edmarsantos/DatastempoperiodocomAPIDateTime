package modulo_datas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

import javax.print.attribute.standard.Chromaticity;

public class DataEmJava {

	public static void main(String[] args) throws ParseException, InterruptedException {
		
		Date date = new Date();
		System.out.println("Utilizando date");
		System.out.println("Data em milisegundos:" + date.getTime());
		System.out.println("Dia do M?s:" + date.getDate());
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
		System.out.println("Data atual em String com segundos com tr?s casas decimais:" + simpleDateFormat.format(date));
		
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
		System.out.println("Calendar Dia do M?s:" + calendar.get(Calendar.DAY_OF_MONTH));
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
				System.out.println("Data atual em String com segundos com tr?s casas decimais:" + simpleDateFormat.format(calendar.getTime()));
				
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
					 System.out.println("compara??o utilizando o after  Boleto em Dia");
				 }else {
					 System.out.println("compara??o utilizando o after  Boleto Vencido");
				 }
				 
				 if(datavencimento.before(dataatualhoje)) {//comparando se a data menor ou antes da data atual
					 System.out.println("compara??o utilizando o before Boleto Vencido");
				 }else {
					 System.out.println("compara??o utilizando o before Boleto em Dia");
				 }
				 
				 
				 //aula 5 calcula de dia mes e ano com calendar
				 
				 Calendar calendar2 = Calendar.getInstance();//por padrao pega a data atual 
				 
				 //simula??o de dada pegando do  banco
				 calendar2.setTime(new SimpleDateFormat("dd-MM-yyyy").parse("10-03-2021"));//definindo uma data
				 
				 calendar2.add(calendar2.DAY_OF_MONTH, 15);//vai somar 15 dias  para subtrair colocar o valor negativo
				 System.out.println( "o dia simulado ? 10-03-2021 somando 15 dias vai para "+  new SimpleDateFormat("dd-MM-yyyy").format(calendar2.getTime()));
				
				 calendar2.add(calendar2.MONTH, 3);//vai somar 3 meses 
				 System.out.println( "o dia simulado ? 10-03-2021 somando 3 meses vai para "+  new SimpleDateFormat("dd-MM-yyyy").format(calendar2.getTime()));
				 
				 calendar2.add(calendar2.YEAR, 2);//vai somar 3 meses  para subtrair colocar o valor negativo
				 System.out.println( "o dia simulado ? 10-03-2021 somando 2 anos  vai para "+  new SimpleDateFormat("dd-MM-yyyy").format(calendar2.getTime()));

	
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
	        	   System.out.println("Parcela de n?mero " + parcela + " vencimento em " 
	        	   + new SimpleDateFormat("dd/MM/yyyy").format(calendar3.getTime()));
	        	   
	           }
	           
	           
	           //15.8 - Nova API de Data e Hora do Java  aula 8
	           //Nova Api de data partir do Java 8 utiliza o LocalDate
	           
	           LocalDate dataAtual = LocalDate.now(); //data atual
	           System.out.println(" " );
	           System.out.println("Data atual ? " + dataAtual);
	           
	           LocalTime horaAtual = LocalTime.now(); //hora atual
	           System.out.println("Hora atual ? " + horaAtual);
	           
	           
	           LocalDateTime dataAtualhoraatual = LocalDateTime.now();
	           System.out.println("Data e Hora atual ? " + dataAtualhoraatual);
	           
	           
	           //15.9 - Formatando data e hora com nova API aula 9
	           
	           System.out.println("Data e Hora usando iso_date atual ? " + dataAtualhoraatual.format(DateTimeFormatter.ISO_DATE)); //nesse modo n?o precisa do simpledatetime
	           System.out.println("Data e Hora usando ofPattern atual ?  " + dataAtualhoraatual.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));//ofPattern usado para definir o novo padrao
	           System.out.println("Data e Hora usando ofPattern atual ?  " + dataAtualhoraatual.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));//ofPattern usado para definir o novo padrao
	           System.out.println("Data e Hora atual ? " + dataAtualhoraatual.format(DateTimeFormatter.ofPattern("HH:mm:ss")));
	          System.out.println(" ");
	
	           //Dia, meses, anos e semanas AULA 10
	           
	           LocalDate localdate = LocalDate.now();
	           System.out.println("dia atual:" + localdate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
	           
	           System.out.println("Dia da semana:" + localdate.getDayOfWeek().name());
		           
	           System.out.println("Dia do m?s:" + localdate.getDayOfMonth());
	           
	           System.out.println("Dia do Ano:" + localdate.getDayOfYear());//mostra qtd da dias do ano
	           
	           System.out.println("M?s:" + localdate.getMonth());//mostra qtd da dias do ano
	           
	           System.out.println("Ano:" + localdate.getYear());//mostra qtd da dias do ano
	           
		       //Tempo de processo com Instant
	           
	           System.out.println(" ");
	           Instant inicio = Instant.now();
	           
	           Thread.sleep(2000);//Pode ser um processo com tempo qualquer que nao conhecemos
	           
	           Instant ifinal = Instant.now();
	           
	           Duration duracao = Duration.between(inicio, ifinal);
	           
	           System.out.println("Dur??o em nano Segundos:"+ duracao.toNanos());
	           
	           System.out.println("Dur??o em nano Minutos:"+ duracao.toMinutes());
	           
	           System.out.println("Dur??o em nano Horas:"+ duracao.toHours());
	           
	          
	           System.out.println("Dur??o em nano milisegundos:"+ duracao.toMillis());
	           
	           System.out.println("Dur??o em nano Horas:"+ duracao.toDays());
		          
		     //Faixa de tempo com Objeto Period
	           
	           System.out.println(" ");
	           
	          // LocalDate dataAntiga = LocalDate.of(2020, 2, 7);
	           LocalDate dataAntiga = LocalDate.parse("2019-10-05");
	           
	           //LocalDate dataNova = LocalDate.of(2021, 7, 4);
	           LocalDate dataNova = LocalDate.parse("2021-10-15");
	           
	           System.out.println("Data Antiga ? maior que a data Nova " + dataAntiga.isAfter(dataNova));
	           
	           System.out.println("Data Antiga ? anterior  a data Nova " + dataAntiga.isBefore(dataNova));
	           
	           System.out.println("Data Antiga ? igual  a data Nova " + dataAntiga.isEqual(dataNova));	           
	
	Period periodo = Period.between(dataAntiga, dataNova);
	
	System.out.println("Quantidade de DIas:"+ periodo.getDays());
	
	System.out.println("Quantidade de Meses:"+ periodo.getMonths());
	
	System.out.println("Quantidade de Anos:"+ periodo.getYears());
	
	System.out.println("Quantidade total de meses:"+ periodo.toTotalMonths());
	
	System.out.println("Periodo: "+ periodo.getYears() + " Anos " + periodo.getMonths() + "  Meses " + periodo.getDays() + " e dias");
	
	//Data, anos, dias, meses e parcelas com LocalDate

	System.out.println(" ");
	LocalDate dataBase = LocalDate.parse("2019-10-05");
	
	System.out.println("Mais 5 dias:" + (dataBase = dataBase.plusDays(5)));
	
	System.out.println("Mais 5 semans:" + (dataBase =dataBase.plusWeeks(5)));
	
	System.out.println("Mais 5 anos:" + (dataBase =dataBase.plusYears(5)));
	
	System.out.println("Mais 2 meses:" + (dataBase =dataBase.plusMonths(2)));
	
	System.out.println("Menos 1 anos:" + (dataBase =dataBase.minusYears(1)));	
	
     System.out.println("Menos 5 semans:" + (dataBase =dataBase.minusWeeks(5)));
	
	System.out.println("Menos 2 meses:" + (dataBase =dataBase.minusMonths(2)));
	
	System.out.println("Menos 5 dias:" + (dataBase = dataBase.minusDays(5)));
	
	dataBase = LocalDate.parse("2019-10-05");
	
	for(int mes =1 ;mes <= 12;mes++) {
		
		dataBase = dataBase.plusMonths(1);
		
		System.out.println("Data Vencimento do boleto " + dataBase.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "do m?s " + mes);
	}
			
			
	
	}

}
