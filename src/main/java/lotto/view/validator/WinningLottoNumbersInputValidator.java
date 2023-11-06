package lotto.view.validator;

import lotto.view.constant.InputConstant;
import lotto.view.exception.LottoInputException;
import lotto.view.message.LottoInputExceptionMessage;

public class WinningLottoNumbersInputValidator {

    public void validate(String winningLottoNumbers){
        isNotEmpty(winningLottoNumbers);
        containsDelimiter(winningLottoNumbers);
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



}