package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Utils {
    public static String input(){
        return Console.readLine();
    }
    public static boolean isNumeric(String testValue){
        for (int i = 0; i < testValue.length(); i++){
            if (testValue.charAt(i) < '0' || '9' < testValue.charAt(i)){
                return false;
            }
        }
        return !(testValue.isEmpty());
    }
    public static boolean isNumeric(String testValue, List<String> excludedWords){
        for (int i = 0; i < testValue.length(); i++){
            if (excludedWords.contains(testValue.substring(i, i + 1))){
                continue;
            }
            if (testValue.charAt(i) < '0' || '9' < testValue.charAt(i)){
                return false;
            }
        }
        return !(testValue.isEmpty());
    }
    public static List<Integer> makeRandomNumbers(int start, int end, int cnt){
        List<Integer> makedNumbers;
        do {
            makedNumbers = Randoms.pickUniqueNumbersInRange(start, end, cnt);
        } while(makedNumbers.stream().distinct().count() != makedNumbers.size());
        return makedNumbers;
    }
}
