package lotto.View.InputValidator;

import static lotto.Message.InputValidatorPrompt.ASK_WINNING_NUM_IN_NUMBER;
import static lotto.Message.InputValidatorPrompt.ASK_WINNING_NUM_IN_VALID_RANGE;
import static lotto.Message.InputValidatorPrompt.ASK_WINNING_NUM_WITH_NO_DUPLICATION;
import static lotto.Message.InputValidatorPrompt.ASK_WINNING_NUM_IN_RIGHT_AMOUNT;

import static lotto.Message.LottoGameInputConstants.LOTTO_WINNING_NUM_AMOUNT;
import static lotto.Message.LottoGameInputConstants.LOTTO_MIN_NUM;
import static lotto.Message.LottoGameInputConstants.LOTTO_MAX_NUM;

import java.util.Arrays;
import java.util.List;


public class WinningNumValidator implements Validator {

    // TODO: 빈값, 공백 검증 로직 추가

    public void validate(String winningNumInput){
        List<String> winningNumbers = Arrays.asList(winningNumInput.split(","));
        areRightAmount(winningNumbers);
        areNumbers(winningNumbers);
        areNotDuplicated(winningNumbers);
        areBetweenValidRange(winningNumbers);
        return ;
    }

    public void areRightAmount(List<String> winningNumbers) throws IllegalArgumentException {
        if (winningNumbers.size() != LOTTO_WINNING_NUM_AMOUNT.getNum()) {
            throw new IllegalArgumentException(ASK_WINNING_NUM_IN_RIGHT_AMOUNT.getMessage());
        }
    }

    public void areNumbers(List<String> winningNumbers) throws IllegalArgumentException {
        for(String winningNum : winningNumbers) {
            try{
                Integer.parseInt(winningNum);
            }
            catch (NumberFormatException numberFormatException) {
                throw new IllegalArgumentException(ASK_WINNING_NUM_IN_NUMBER.getMessage());
            }
        }
    }

    public void areNotDuplicated(List<String> winningNumbers) throws IllegalArgumentException {
        if(winningNumbers.stream().distinct().count() != LOTTO_WINNING_NUM_AMOUNT.getNum()){
            throw new IllegalArgumentException(ASK_WINNING_NUM_WITH_NO_DUPLICATION.getMessage());
        }
    }

    public void areBetweenValidRange(List<String> winningNumbers) throws IllegalArgumentException{
        for(String winningNum : winningNumbers) {
            if(Integer.parseInt(winningNum) < LOTTO_MIN_NUM.getNum() || Integer.parseInt(winningNum) > LOTTO_MAX_NUM.getNum()){
                throw new IllegalArgumentException(ASK_WINNING_NUM_IN_VALID_RANGE.getMessage());
            }
        }
    }

}


