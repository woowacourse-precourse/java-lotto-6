package lotto.util.convert;

import java.util.ArrayList;
import java.util.List;

import lotto.util.validate.CommonValidate;
import lotto.util.validate.UserValidate;

public class ConvertUtil {

    public static int stringToInt(String input){
        try{
            CommonValidate.checkBlank(input);
            CommonValidate.checkIsNumber(input);
        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException(e);
        }
        return Integer.parseInt(input);
    }

    public static List<Integer> stringToIntArr(String input){
        List<Integer> numbers;
        try{
            CommonValidate.checkBlank(input);
            numbers = splitString(input);
        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException(e);
        }
        return numbers;
    }

    private static List<Integer> splitString(String input){
        String[] temp = input.split(",");
        List<Integer> numbers = new ArrayList<>(temp.length);
        try{
            for(String number : temp){
                CommonValidate.checkIsNumber(number);
                int n = Integer.parseInt(number);
                UserValidate.checkNumberRange(n);
                numbers.add(n);
            }
        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException(e);
        }
        return numbers;
    }
}
