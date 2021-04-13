package co.uk.java12;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class MyRunnableThread implements Runnable {
    public void run() {
        System.out.println("Important job running in MyRunnableThread");
    }
}
public class Java11Application {

    public static void main(String[] args) {
        System.out.println("Hello World");
        System.out.println("----LOCAL PARAMETER TYPE INFERENCE FOR LAMBDA EXPRESSIONS---------");
        System.out.println("----USAGE OF STRING:: REPEAT METHOD TO COPY A STRING---------");
        repeatStrings();

        System.out.println();
    }

    private static void repeatStrings() {
        String str = "abc\t\n";
        System.out.println(str.repeat(3));
        var text = "Hello Java 10";
        System.out.println(text);
        var myList = new ArrayList<Map<String, List<Integer>>>();

        for (var current : myList) {
            // current is infered to type: Map<String, List<Integer>>
            System.out.println(current);
        }

        var list = List.of("A", "B", "C");
        var copy = List.copyOf(list);
        System.out.println(list == copy);   // true

        var map = Map.of("A", 1, "B", 2);
        System.out.println(map);    // {B=2, A=1}
    }
    //https://winterbe.com/posts/2018/09/24/java-11-tutorial/
}
