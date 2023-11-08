package lotto.View.InputValidator;

import static lotto.Constants.LottoGameInputConstants.LOTTO_MAX_NUM;
import static lotto.Constants.LottoGameInputConstants.LOTTO_MIN_NUM;
import static lotto.Message.InputValidatorPrompt.ASK_NO_EMPTY_INPUT;
import static lotto.Message.InputValidatorPrompt.ASK_NO_WHITE_SPACE;
import static lotto.Message.InputValidatorPrompt.ASK_WINNING_NUM_IN_NUMBER;
import static lotto.Message.InputValidatorPrompt.ASK_WINNING_NUM_IN_VALID_RANGE;
import static lotto.Message.InputValidatorPrompt.ASK_BONUS_WINNING_NUM_NOT_DUPLICATE_WITH_WINNING_NUM;
import static lotto.Message.OutputPrompt.WHITE_SPACE;

import java.util.List;

public class BonusWinningNumValidator {
    public void validate(String bonusWinningNumInput, List<Integer> winningNumInput){
        isNotEmpty(bonusWinningNumInput);
        containsNoWhiteSpace(bonusWinningNumInput);
        isNumber(bonusWinningNumInput);
        isBetweenValidRange(bonusWinningNumInput);
        isNotDuplicated(bonusWinningNumInput, winningNumInput);
    }

    public void isNotEmpty(String bonusWinningNumInput) throws IllegalArgumentException{
        if(bonusWinningNumInput.isEmpty()){
            throw new IllegalArgumentException(ASK_NO_EMPTY_INPUT.getMessage());
        }
    }

    public void containsNoWhiteSpace(String bonusWinningNumInput) throws IllegalArgumentException{
        if(bonusWinningNumInput.contains(WHITE_SPACE.getMessage())){
            throw new IllegalArgumentException(ASK_NO_WHITE_SPACE.getMessage());
        }
    }

    public void isNumber(String bonusWinningNumInput) throws IllegalArgumentException {
        try{
            Integer.parseInt(bonusWinningNumInput);
        }
        catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(ASK_WINNING_NUM_IN_NUMBER.getMessage());
        }
    }

    public void isBetweenValidRange(String bonusWinningNumInput) throws IllegalArgumentException{
        if(Integer.parseInt(bonusWinningNumInput) < LOTTO_MIN_NUM.getNum() || Integer.parseInt(bonusWinningNumInput) > LOTTO_MAX_NUM.getNum()){
                throw new IllegalArgumentException(ASK_WINNING_NUM_IN_VALID_RANGE.getMessage());
        }
    }

    public void isNotDuplicated(String bonusWinningNumInput, List<Integer> winningNumInput) throws IllegalArgumentException {
        if(winningNumInput.contains(Integer.parseInt(bonusWinningNumInput))){
            throw new IllegalArgumentException(ASK_BONUS_WINNING_NUM_NOT_DUPLICATE_WITH_WINNING_NUM.getMessage());
        }
    }
}
