package lotto.domain;

import lotto.validation.ErrorMessage;
import lotto.view.OutputView;

import java.util.ArrayList;

public class WinningNum {
    private final ArrayList<Integer> winningNum;
    private Integer bonusNumber;

    public WinningNum(ArrayList<Integer> winningNum) {
        lengthValidate(winningNum);
        duplicatedValidate(winningNum);
        numberRangeValidate(winningNum);

        this.winningNum = winningNum;
    }

    private void lengthValidate(ArrayList<Integer> winningNum) {
        if (winningNum.size() != ConstNum.LENGTH.getNum()) {
            OutputView.errorMessage(ErrorMessage.LENGTH_ERROR.getMessage());

            throw new IllegalArgumentException();
        }
    }

    private void duplicatedValidate(ArrayList<Integer> winningNum) {
        long count = winningNum.stream()
                .distinct()
                .count();

        if (count != ConstNum.LENGTH.getNum()) {
            OutputView.errorMessage(ErrorMessage.DUPLICATED_ERROR.getMessage());

            throw new IllegalArgumentException();
        }
    }

    private void numberRangeValidate(ArrayList<Integer> winningNum) {
        for (Integer num : winningNum) {
            if(num>ConstNum.LOTTO_MAX.getNum() || num<ConstNum.LOTTO_MIN.getNum()){
                OutputView.errorMessage(ErrorMessage.RANGE_ERROR.getMessage());
                throw new IllegalArgumentException();
            }
        }
    }

    public void setBonusNumber(Integer number) {
        duplicatedValidate(number);
        bonusRangeValidate(number);
        this.bonusNumber = number;
    }

    private void duplicatedValidate(Integer bonusNumber) {
        if (winningNum.contains(bonusNumber)) {
            OutputView.errorMessage(ErrorMessage.BONUS_DUPLICATED_ERROR.getMessage());

            throw new IllegalArgumentException();
        }
    }

    private void bonusRangeValidate(Integer bonusNumber) {
        if (bonusNumber > ConstNum.LOTTO_MAX.getNum() || bonusNumber < ConstNum.LOTTO_MIN.getNum()) {
            OutputView.errorMessage(ErrorMessage.BONUS_RANGE_ERROR.getMessage());

            throw new IllegalArgumentException();
        }
    }

    public Integer compare(Lotto lotto) {
        Integer count = 0;
        Boolean bonus = false;
        for (Integer num : winningNum) {
            if(lotto.hasNumber(num)){
                count++;
            }
        }

        if(lotto.hasNumber(bonusNumber)) bonus = true;

        return getRank(count,bonus);
    }

    private Integer getRank(int count,Boolean bonus) {
        if(count==6) return 1;
        if (count == 5) {
            if(bonus) return 2;

            return 3;
        }
        if (count==4) return 4;
        if(count==3) return 5;

        return -1;
    }
}
