package BasicPractice;
import java.text.NumberFormat;

public class CurrencyFormating {
    public static void main(String[] args) {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        String result1 = currency.format(391937.288);
        System.out.println(result1);

        NumberFormat percentage = NumberFormat.getPercentInstance();
        String result2 = percentage.format(1.5);
        System.out.println(result2);
            //or
        String result3 = NumberFormat.getPercentInstance().format(1.6);
        System.out.println(result3);
    }
    
}
