package Domain.WinningNumber;

import Controller.WinningNumberInputController;
import Util.CheckInteger;
import Util.CheckList;
import View.WinningNumberInputErrorText;

import java.util.List;

/*
    당첨 번호를 나타내는 객체
 */
public class WinningNumber {
    private List<Integer> numbers;
    private Integer bonusNum;

    public WinningNumber(List<Integer> numbers, Integer bonusNum){
        CheckList.lengthSame(numbers, 6, WinningNumberInputErrorText.notSixWord());
        CheckList.checkDuplicate(numbers, WinningNumberInputErrorText.dupilicateNumber());
        CheckList.checkNotInList(numbers, bonusNum, WinningNumberInputErrorText.dupilicateBonusNumber());
        CheckInteger.intOutOfRange(bonusNum, 1, 45, WinningNumberInputErrorText.numberOutOfRange());

        this.numbers = numbers;
        this.bonusNum = bonusNum;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Integer getBonusNum() {
        return bonusNum;
    }
}
