package lotto.domain;

import lotto.consts.ExceptionMessage;
import lotto.service.NumberConverter;
import lotto.view.InputView;

import java.util.List;

import static lotto.consts.ConstsString.MAX_LOTTO_NUMBER;
import static lotto.consts.ConstsString.MIN_LOTTO_NUMBER;

public class BonusNumber {
    private int bonusNumber;

    InputView inputView = new InputView();
    NumberConverter numberConverter = new NumberConverter();
    public static int bonus;

    public int inputBonusNumber(){
        bonus = generateBonusNumber();
        validate(bonus);
        return bonus;
    }
    public void validate(int inputNumber){
        checkValidNumber(inputNumber);
    }
    private int generateBonusNumber(){
        return numberConverter.convertNumber(inputView.setBonusNumber());
    }

    private void checkValidNumber(int inputNumber){
        if(inputNumber > MAX_LOTTO_NUMBER || inputNumber < MIN_LOTTO_NUMBER){
            throw new IllegalArgumentException(ExceptionMessage.INVALID_RANGE_NUMBER.getMessage());
        }
    }


    public void checkDuplicated(List<Integer> lottoList, int inputNumber){
        if(lottoList.contains(inputNumber)){
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATED_VALUE_ERROR.getMessage());
        }
    }

    public int getBonus(){
        return bonus;
    }

}
