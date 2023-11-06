package lotto;

import static lotto.config.RuleConfig.DELIMETER;
import static lotto.config.RuleConfig.MAX_LOTTO_NUM;
import static lotto.config.RuleConfig.MIN_LOTTO_NUM;

import java.util.Arrays;
import java.util.List;

public class WinningLotto {
    private static Lotto winningLotto;
    private static int bonusNumber;

    public static void createWinningLotto(String numbersBeforeValidated){
        List<String> answer = Arrays.stream(numbersBeforeValidated.split(DELIMETER)).map(String::trim).toList();
        validateWinningNumber(answer);
        winningLotto = new Lotto(answer.stream().map(Integer::parseInt).toList());
    }
    public static void createBonusNumber(String bonusNumberBeforeValidated){
        validateBonusNum(bonusNumberBeforeValidated.trim());
        bonusNumber = Integer.parseInt(bonusNumberBeforeValidated);
    }
    public static Lotto getWinningLotto(){
        return winningLotto;
    }
    public static int getBonusNumber(){
        return bonusNumber;
    }
    public static void validateWinningNumber(List<String> pickedNum){
        for(String num : pickedNum){
            if(containsLetter(num)){
                throw new IllegalArgumentException(ErrorMessages.NOT_INTEGER.toString());
            }
            if(containsUnderMinNum(num) || containsUpperMaxNum(num)){
                throw new IllegalArgumentException(ErrorMessages.OUT_OF_RANGE.toString());
            }
        }

    }
    public static void validateBonusNum(String bonusNum){
        if(containsLetter(bonusNum)){
            throw new IllegalArgumentException(ErrorMessages.NOT_INTEGER.toString());
        }
        if(containsUnderMinNum(bonusNum) || containsUpperMaxNum(bonusNum)){
            throw new IllegalArgumentException(ErrorMessages.OUT_OF_RANGE.toString());
        }
        if(hasAlreadyPicked(bonusNum)){
            throw new IllegalStateException(ErrorMessages.ALREADY_HAVE.toString());
        }
    }
    public static boolean containsLetter(String pickedNum){
        try {
            Integer.parseInt(pickedNum);
            return false;
        } catch (NumberFormatException ex) {
            return true;
        }
    }

    public static boolean containsUnderMinNum(String pickedNum){
        return Integer.parseInt(pickedNum) < MIN_LOTTO_NUM;
    }
    public static boolean containsUpperMaxNum(String pickedNum){
        return Integer.parseInt(pickedNum) > MAX_LOTTO_NUM;
    }
    public static boolean hasAlreadyPicked(String pickedNum){
        return winningLotto.getLotto().contains(Integer.parseInt(pickedNum));
    }
}
