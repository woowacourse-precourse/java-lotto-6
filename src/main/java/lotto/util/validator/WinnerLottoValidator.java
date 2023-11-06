package lotto.util.validator;

import static lotto.util.Constant.LOTTO_LENGTH;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.util.ExceptionMessage;

public class WinnerLottoValidator extends Validator{

    @Override
    public boolean validation(String input) {
       if (validationInputLength(input)){
           System.out.println(ExceptionMessage.INVALID_INPUT_LENGTH.getMessage());
           return false;
       }
        return true;
    }

    private boolean validationInputLength(String input) {
        List<Integer> numbers = Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        return numbers.size() != LOTTO_LENGTH;
    }



}
