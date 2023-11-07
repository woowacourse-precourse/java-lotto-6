package validator;

import constant.ConfigMessage;
import constant.ErrorMessage;
import constant.ConfigNumber;
import util.Parser;

import java.util.ArrayList;
import java.util.List;

public class LottoValidator {

    public static List<Integer> validNumberic(String numbers){
        try {
            return Parser.splitString(numbers, ConfigMessage.DELIMITER.getValue()).stream()
                    .map(Integer::parseInt)
                    .toList();
        } catch (Exception e) {
            throw new NumberFormatException(ErrorMessage.MESSAGE + " " + ErrorMessage.NUMBERIC_MESSAGE);
        }
    }

    public static void  validSize(List<Integer> numbers){
        if (numbers.size() != ConfigNumber.NUM_COUNT.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.MESSAGE + " " +ErrorMessage.COUNT_MESSAGE);
        }
    }

    public static void validDuplcate(List<Integer> numbers){
        List<Integer> copyNums = new ArrayList<>();
        if(!numbers.stream().allMatch(num-> !copyNums.contains(num) && copyNums.add(num))){
            throw new IllegalArgumentException(ErrorMessage.MESSAGE + " " + ErrorMessage.DUPLICATE_MESSAGE);
        }
    }

    public static void validRange(List<Integer> numbers){
       if(!numbers.stream().allMatch(x -> x >= ConfigNumber.START_INCLUSIVE.getValue()
               && x <= ConfigNumber.END_INCLUSIVE.getValue()))
           throw new IllegalArgumentException(ErrorMessage.MESSAGE + " " + ErrorMessage.RANGE_MESSAGE);
    }

}
