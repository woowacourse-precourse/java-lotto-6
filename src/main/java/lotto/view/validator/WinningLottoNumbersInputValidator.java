package lotto.view.validator;

import java.util.Arrays;
import lotto.domain.constant.LottoConstant;
import lotto.view.constant.InputConstant;
import lotto.view.exception.LottoInputException;
import lotto.view.message.LottoInputExceptionMessage;

public class WinningLottoNumbersInputValidator {

    public void validate(String winningLottoNumbers){
        isNotEmpty(winningLottoNumbers);
        containsDelimiter(winningLottoNumbers);
        containsSixNumbers(winningLottoNumbers);
        isEachNumberNotEmpty(winningLottoNumbers);
    }

    private void isNotEmpty(String winningLottoNumbers){
        if(winningLottoNumbers.isEmpty()){
            throw LottoInputException.of(LottoInputExceptionMessage.INPUT_IS_EMPTY);
        }
    }

    private void containsDelimiter(String winningLottoNumbers){
        if(!winningLottoNumbers.contains(InputConstant.WINNING_LOTTO_NUMBERS_DELIMITER)){
            throw LottoInputException.of(LottoInputExceptionMessage.WINNING_LOTTO_NUMBERS_DOES_NOT_CONTAIN_DELIMITER);
        }
    }

    private void containsSixNumbers(String winningLottoNumbers){
        if(!dividedIntoSixNumbers(winningLottoNumbers)){
            throw LottoInputException.of(LottoInputExceptionMessage.WINNING_LOTTO_NUMBERS_DOES_NOT_CONTAIN_SIX_NUMBERS);
        }
    }

    private boolean dividedIntoSixNumbers(String winningLottoNumbers){
        return winningLottoNumbers.split(InputConstant.WINNING_LOTTO_NUMBERS_DELIMITER).length == LottoConstant.LOTTO_ITEM_COUNT.getValue();
    }

    private void isEachNumberNotEmpty(String winningLottoNumbers){
        String[] numbers = winningLottoNumbers.split(InputConstant.WINNING_LOTTO_NUMBERS_DELIMITER);
        if(isMoreThanOneNumberEmpty(numbers)){
            throw LottoInputException.of(LottoInputExceptionMessage.WINNING_LOTTO_NUMBERS_CONTAINS_EMPTY_NUMBER);
        }
    }

    private boolean isMoreThanOneNumberEmpty(String[] numbers){
        return Arrays.stream(numbers)
                .anyMatch(String::isEmpty);
    }


}