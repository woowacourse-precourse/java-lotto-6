package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Utils {
    public static String input(){
        return Console.readLine();
    }

    public static boolean isNumeric(String str){
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) < '0' || '9' < str.charAt(i)){
                return false;
            }
        }
        return true;
    }
}
