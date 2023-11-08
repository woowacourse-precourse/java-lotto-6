package lotto.model;

import lotto.view.Input;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DHLottery {
    private List<Integer> winningNumber;
    private Integer bonusNumber;

    public DHLottery() {
        this.winningNumber = new ArrayList<>();
        this.bonusNumber = null;
    }

    public void setWinningNumber() {
        while(true) {
            List<Integer> winningNumber = Input.inputWinningNumber();
            System.out.println("");
            try {
                numberof6Validate(winningNumber);
                sameNumberValidate(winningNumber);
                outofRangeValidate(winningNumber);

                this.winningNumber = winningNumber;
                break;
            }
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void setBonusNumber() {
        while (true) {
            Integer bonusNumber = Input.inputBonusNumber();
            System.out.println("");
            try {
                sameNumberValidate(bonusNumber);
                outofRangeValidate(bonusNumber);

                this.bonusNumber = bonusNumber;
                break;
            }
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void numberof6Validate(List<Integer> winningNumber) throws IllegalArgumentException {
        // 6개 아닐 시
        if (winningNumber.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호가 6개가 아닙니다. 다시 입력하세요");
        }

    }
    private void sameNumberValidate(List<Integer> winningNumber) throws IllegalArgumentException {
        // 중복 숫자
        Set<Integer> winningNumberSet = new HashSet<>(winningNumber);
        if(winningNumberSet.size()!= winningNumber.size()){
            throw new IllegalArgumentException("[ERROR] 중복된 값이 존재합니다. 다시 입력하세요");
        }
    }

    private void outofRangeValidate(List<Integer> winningNumber) throws IllegalArgumentException {
        // 범위 이외의 숫자 입력
        for (int i = 0; i < winningNumber.size(); i++)
            if (!(1 <= winningNumber.get(i) && winningNumber.get(i) <= 45))
                throw new IllegalArgumentException("[ERROR] 범위 이외의 값이 존재합니다. 다시 입력하세요");
    }

    private void sameNumberValidate(Integer bonusNumber) throws IllegalArgumentException {
        if (this.winningNumber.contains(bonusNumber))
            throw new IllegalArgumentException("[ERROR] 중복된 값이 존재합니다. 다시 입력하세요");
    }

    private void outofRangeValidate(Integer bonusNumber) throws IllegalArgumentException {
        // 범위 이외의 숫자 입력
        if (!(1 <= bonusNumber && bonusNumber <= 45))
            throw new IllegalArgumentException("[ERROR] 범위 이외의 값이 존재합니다. 다시 입력하세요");
    }

    public List<Integer> getWinningNumber() {
        return winningNumber;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }

    @Override
    public String toString() {
        return "DHLottery{" +
                "winningNumber=" + winningNumber +
                ", bonusNumber=" + bonusNumber +
                '}';
    }
}
