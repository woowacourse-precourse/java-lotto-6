package lotto;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleView {
    public static void print(String output){
        System.out.println(output);
    }
    public static String getInput(){
        return Console.readLine();
    }
    
}
