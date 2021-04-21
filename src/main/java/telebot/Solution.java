package telebot;
import java.util.Scanner;
public class Solution 
{
    static Nebulizer obj = new Nebulizer();
    static Scanner sc = new Scanner(System.in);
    static Scanner sc1 = new Scanner(System.in);
    double[] Nebulizer;
    public static void main(String[] args)
    {
        int id = sc.nextInt();
        String name = sc1.nextLine();
        int price = sc.nextInt();
        String paymentMode = sc1.nextLine();
        boolean isSold = sc1.nextBoolean();
        double[] arr = new double[6];
        System.out.println(findAverageNebulizerPrice(price, paymentMode));
        //System.out.println(sortSoldNebulizerByPrice(arr, price, paymentMode, isSold));
    }
    public static double findAverageNebulizerPrice(int price,String paymentMode)
    {
        double res;
        if(paymentMode.equals("Online"))
        {
            res = price - (price/100);
            if(res > 0) System.out.println("There is no sold Nebulizers");
            return res;
        }
        return price;
    }
    public static Nebulizer[] sortSoldNebulizerByPrice(double[] arr,int price,String paymentMode,boolean isSold)
    {
        for(int i = 0;i < 5;i++)
        {
            arr[i] = findAverageNebulizerPrice(price,paymentMode);
        }
        if(isSold)
        {
            for(int i = 0;i < 5;i++)
            {
                for(int j = 0;j < 5;j++)
                {
                    if(arr[j] > arr[j+1])
                    {
                        double temp = arr[j];
                        arr[j] = arr[j+1];
                        arr[j+1] = temp;
                    }
                }
            }
        }
        
        if(obj.PaymentMode == null) System.out.println("Nebulizers not Found");
        return obj.Nebulizer(arr);
    }
}
class Nebulizer 
{
    int id;
    String name;
    double price;
    String PaymentMode;
    boolean isSold;
    double arr[];
    public Nebulizer[] Nebulizer(double Nebulizer[])
    {
        return Nebulizer(arr);
    }
}
