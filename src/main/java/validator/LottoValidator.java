package validator;

import constant.ErrorMessage;
import constant.LottoConfig;
import domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoValidator {


//    public static void validNumberic(List<Integer> numbers){
//        if(!numbers.stream().allMatch(x -> x instanceof Integer)) {
//            throw new NumberFormatException(ErrorMessage.NUMBERIC_MESSAGE.toString());
//        }
//    }

    public static void  validSize(List<Integer> numbers){
        if (numbers.size() != LottoConfig.NUM_COUNT.getValue()) {
            throw new IllegalArgumentException("로또 번호의 개수는 6개여야 합니다.");
        }
    }

    public static void validDuplcate(List<Integer> numbers){
        List<Integer> copyNums = new ArrayList<>();
        if(!numbers.stream().allMatch(num-> !copyNums.contains(num) && copyNums.add(num))){
            throw new IllegalArgumentException("로또 번호가 중복되었습니다.");
        }
    }

    public static void validRange(List<Integer> numbers){
       if(!numbers.stream().allMatch(x -> x >= LottoConfig.START_INCLUSIVE.getValue()
               && x <= LottoConfig.END_INCLUSIVE.getValue()))
           throw new IllegalArgumentException("로또 번호는 1부터 45사이의 숫자여야 합니다.");
    }

}
