package lotto.domain;

import static lotto.enums.Constants.*;
import static lotto.utils.LottoNumberUtil.removeSpace;

import lotto.enums.ExceptionMessages;

public class BonusNumber {

    private final int value;

    public BonusNumber(String number, final Lotto lotto){
        number = removeSpace(number);
        validate(number,lotto);
        value = Integer.parseInt(number);
    }

    public int getValue(){
        return value;
    }

    private void validate(String number, Lotto lotto){
        if(isEmpty(number)) ExceptionMessages.BONUS_NUMBER_IS_EMPTY.throwException();
        if(!isDigit(number)) ExceptionMessages.BONUS_NUMBER_IS_NOT_NUMBER.throwException();

        int convertNumber = Integer.parseInt(number);

        if(!isBetweenOneAndFortyFive(convertNumber)) ExceptionMessages.BONUS_NUMBER_IS_NOT_BETWEEN_ONE_AND_FORTYFIVE.throwException();
        if(isDuplicatedWinningLottoNumber(lotto,convertNumber)) ExceptionMessages.BONUS_NUMBER_IS_DUPLICATED_WINNING_NUMBER.throwException();
    }

    private boolean isEmpty(String number){
        return number == null || number.isBlank();
    }

    private boolean isDigit(String number){
        return Character.isDigit(number.charAt(0));
    }

    private boolean isBetweenOneAndFortyFive(int number){
        return number >= MIN_INCLUSIVE.getValue() && number <= MAX_INCLUSIVE.getValue();
    }

    private boolean isDuplicatedWinningLottoNumber(Lotto winningLotto, int number){
        return winningLotto.getNumbers().contains(number);
    }
}
