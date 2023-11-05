package lotto.service;

import java.util.List;
import lotto.util.Validator;

public class InputWinnerNumberService {

    public List<Integer> checkRightWinnerNumbers(Validator validator, String inputWinnerNumbers) {
        try {
            List<String> splitedInputWinnerNumbers = List.of(inputWinnerNumbers.split(","));
            validator.validateRightCommaCount(inputWinnerNumbers, splitedInputWinnerNumbers);
            validator.validateOnlyNumber(splitedInputWinnerNumbers);



        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException(e.getMessage());
        }

    }
}
