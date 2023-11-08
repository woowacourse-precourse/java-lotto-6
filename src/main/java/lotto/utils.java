package lotto;

import java.util.List;
import lotto.configs.Constant;

public class utils {
    public static <T> boolean hasDuplicates(List<T> list){
        return list.stream().distinct().count() != list.size();
    }
    public static boolean hasInvalidValue(List<Integer> list, int min, int max){
        return list.stream().anyMatch(e -> e < min || e > max);
    }
    public static boolean isInteger(String number){
        try{
            Integer.parseInt(number);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }

    public static int getCountOfMatch(List<Integer> list1, List<Integer> list2){
        int count = 0;
        for(int number : list1){
            if(list2.contains(number)){
                count++;
            }
        }
        return count;
    }

    public static String createErrorMessage(String message){
        return String.join(Constant.BLANK, Constant.ERROR_MESSAGE, message);
    }
}
