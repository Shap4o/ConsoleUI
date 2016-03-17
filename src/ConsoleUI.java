import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ConsoleUI {
    public static void main(String[] args){
        String couplePart="[A-Z]{1}[a-z0-9]+[a-z]{1}";
        String text="";
        try{
            text=new Scanner(new File("text.txt")).useDelimiter("\\Z").next();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
        Pattern myPattern=Pattern.compile(couplePart);
        Matcher myMatcher=myPattern.matcher(text);
        int numberOfCouples=0;
        while(myMatcher.find()){
            System.out.print("Найдено совпадение " + myMatcher.group());
            if(myMatcher.find()) {
                System.out.println("    " + myMatcher.group() + " - пара");
                numberOfCouples++;
            }
        }
        System.out.println();
        System.out.println(numberOfCouples+" pairs in total");
    }
}
