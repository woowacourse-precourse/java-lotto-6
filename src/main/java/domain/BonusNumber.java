package domain;

import util.ExceptionMessage;

/**
 * packageName    : domain
 * fileName       : BonusNumber
 * author         : qkrtn_ulqpbq2
 * date           : 2023-11-06
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-06        qkrtn_ulqpbq2       최초 생성
 */
public class BonusNumber {

    private static final int LOTTO_GAME_START_NUMBER = 1;
    private static final int LOTTO_GAME_END_NUMBER = 45;
    private static final String COMMA = ",";
    private static final String SPACE = " ";
    private final int bonusNumber;

    public int getBonusNumber(){
        return bonusNumber;
    }
    public BonusNumber(String bonusNumber, Lotto winningNumbers){
        validate(bonusNumber, winningNumbers);
        this.bonusNumber = convertStringToInt(bonusNumber);
    }

    private void validate(String bonusNumber, Lotto winningNumbers){
        isStringEmpty(bonusNumber);
        isSeparatorChar(bonusNumber);
        isDigit(bonusNumber);
        isBetweenLottoRange(convertStringToInt(bonusNumber));
        isNumberInLotto(convertStringToInt(bonusNumber), winningNumbers);
    }

    private int convertStringToInt(String number) {
        return Integer.parseInt(number);
    }
    private void isStringEmpty(String bonusNumber){
        if(bonusNumber == null || bonusNumber.isBlank()){
            ExceptionMessage.BONUS_WRONG_NUMBER_OF_VALUE.throwException();
        }
    }

    private void isSeparatorChar(String bonusNumber){
        if(bonusNumber.contains(COMMA) || bonusNumber.contains(SPACE)){
            ExceptionMessage.BONUS_WRONG_NUMBER_OF_VALUE.throwException();
        }
    }

    private void isDigit(String bonusNumber){
        if(!(bonusNumber.chars().allMatch(Character::isDigit))){
            ExceptionMessage.IS_RAGNE_BONUS.throwException();
        }
    }

    private void isBetweenLottoRange(int number) {
        if(number < LOTTO_GAME_START_NUMBER || number > LOTTO_GAME_END_NUMBER){
            ExceptionMessage.IS_RAGNE_BONUS.throwException();
        };
    }

    private void isNumberInLotto(int number, Lotto winningNumbers){
        if(winningNumbers.getNumbers().contains(number)){
            ExceptionMessage.NOT_IN_WINNING_NUMBERS.throwException();
        }
    }
}
