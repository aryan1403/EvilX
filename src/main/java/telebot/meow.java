package telebot;
import java.util.Scanner;
public class meow {
    public static void main(String[] args) {
        int counter = 0;
        for(int i = 0;i < 5;i++)
        {
            for(int j = 0;j <= i;j++)
            {
                counter++;
                if(counter % 2 != 0) System.out.print("* ");
                else System.out.print("# ");
            }
            System.out.println();
            counter = 0;
        }
        
    }
}
