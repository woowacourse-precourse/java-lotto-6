package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

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

    public static List<Integer> makeRandomNumbers(int start, int end, int cnt){
        List<Integer> makedNumbers;
        do {
            makedNumbers = Randoms.pickUniqueNumbersInRange(start, end, cnt);
        } while(makedNumbers.stream().distinct().count() != makedNumbers.size());
        return makedNumbers;
    }
}
