package lotto;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleView {
    public static void print(String output){
        System.out.println(output);
    }
    public static String getInput(){
        return Console.readLine();
    }

    public static long getLongInput(){
        String _input = getInput();
        try{
            return Long.parseLong(_input);
        }catch (NumberFormatException e){
            print("[ERROR] 유효하지 않은 숫자입니다.");
            return getLongInput();
        }
    }
}
