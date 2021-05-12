import models.Fatura;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class ExemplosExercicioCalendar {

    public static void main(String[] args) {
        //Declarações
        Fatura fatura = new Fatura();
        Scanner scan = new Scanner(System.in);
        Calendar dataVencimento = Calendar.getInstance();
        SimpleDateFormat formatarData = new SimpleDateFormat("dd/MM/yyyy");

        //Captura de dados
        System.out.println("Digite o código da fatura: ");
        fatura.setCode(scan.next());
        System.out.println("Digite a data de vencimento da fatura: ");
        String dataDigitada = scan.next();

        //Armazenar a data atual;
        Calendar dataAtual = Calendar.getInstance();

        //Converter a data digitada para calendar;
        try {
            dataVencimento.setTime(formatarData.parse(dataDigitada));
        }catch(ParseException e) {
            System.err.println("Parse Exception: " + e.getMessage());
        }

        //Data atual, código, data de vencimento
        System.out.println("\n==============================================================");
        System.out.println("Código da fatura: " + fatura.getCode());
        System.out.println("Data de hoje: " + dataAtual.getTime());
        System.out.println("Data de vencimento da fatura: " + dataVencimento.getTime());
        System.out.println("==============================================================");

        //Acrescentar 10 dias para o limite de pagamento sem juros;
        dataVencimento.add(Calendar.DATE, 10);

        //Caso a data para pagamento caia num sábado ou domingo, o cliente pode pagar na segunda-feira;
        int dayOfWeek = dataVencimento.get(Calendar.DAY_OF_WEEK);

        if(dayOfWeek == 7){
            dataVencimento.add(Calendar.DATE, 2);
            System.out.println("O cliente pode pagar a fatura na próxima segunda-feira, dia: " + dataVencimento.getTime());

        }else if(dayOfWeek == 1) {
            dataVencimento.add(Calendar.DATE, 1);
            System.out.println("O cliente pode pagar a fatura na próxima segunda-feira, dia: " + dataVencimento.getTime());
        }else {
            System.out.println("Data limite para pagar a fatura sem juros: " + dataVencimento.getTime());
        }

        //Calcular quantos dias o cliente tem para pagar a fatura
        var data1 = dataVencimento.getTime();
        var data2 = dataAtual.getTime();
        long diffEmMil = Math.abs(data2.getTime() - data1.getTime());
        long diff = TimeUnit.DAYS.convert(diffEmMil, TimeUnit.MILLISECONDS);

        System.out.println("Você tem " + diff + " dias para pagar a fatura sem juros!!!");
    }
}
