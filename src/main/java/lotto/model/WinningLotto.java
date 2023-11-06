package lotto.model;

import static lotto.config.RuleConfig.DELIMETER;
import static lotto.config.RuleConfig.MAX_LOTTO_NUM;
import static lotto.config.RuleConfig.MIN_LOTTO_NUM;

import java.util.Arrays;
import java.util.List;
import lotto.utils.ErrorMessages;

public class WinningLotto {
    private static WinningLotto instance;
    private Lotto winningLotto;
    private int bonusNumber;
    public static WinningLotto getInstance() {
        if (instance == null) {
            instance = new WinningLotto();
        }
        return instance;
    }

    public void createWinningLotto(String numbersBeforeValidated){
        List<String> winningNumbersBeforeValidated = Arrays.stream(numbersBeforeValidated.split(DELIMETER))
                                                    .map(String::trim).toList();
        validateWinningNumber(winningNumbersBeforeValidated);
        winningLotto = new Lotto(winningNumbersBeforeValidated.stream().map(Integer::parseInt).toList());
    }
    public void createBonusNumber(String bonusNumberBeforeValidated){
        validateBonusNumber(bonusNumberBeforeValidated.trim());
        bonusNumber = Integer.parseInt(bonusNumberBeforeValidated);
    }
    public Lotto getWinningLotto(){
        return winningLotto;
    }
    public int getBonusNumber(){
        return bonusNumber;
    }
    private void validateWinningNumber(List<String> winningNumbersBeforeValidated){
        for(String number : winningNumbersBeforeValidated){
            if(containsLetter(number)){
                throw new IllegalArgumentException(ErrorMessages.NOT_INTEGER.toString());
            }
            if(containsUnderMinNum(number) || containsUpperMaxNum(number)){
                throw new IllegalArgumentException(ErrorMessages.OUT_OF_RANGE.toString());
            }
        }
    }
    private void validateBonusNumber(String bonusNumber){
        if(containsLetter(bonusNumber)){
            throw new IllegalArgumentException(ErrorMessages.NOT_INTEGER.toString());
        }
        if(containsUnderMinNum(bonusNumber) || containsUpperMaxNum(bonusNumber)){
            throw new IllegalArgumentException(ErrorMessages.OUT_OF_RANGE.toString());
        }
        if(hasAlreadyPicked(bonusNumber)){
            throw new IllegalStateException(ErrorMessages.ALREADY_HAVE.toString());
        }
    }
    private boolean containsLetter(String pickedNum){
        try {
            Integer.parseInt(pickedNum);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    private boolean containsUnderMinNum(String pickedNum){
        return Integer.parseInt(pickedNum) < MIN_LOTTO_NUM;
    }
    private boolean containsUpperMaxNum(String pickedNum){
        return Integer.parseInt(pickedNum) > MAX_LOTTO_NUM;
    }
    private boolean hasAlreadyPicked(String bonusNumber){
        return winningLotto.getLotto().contains(Integer.parseInt(bonusNumber));
    }
}
