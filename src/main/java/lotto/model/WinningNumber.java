package lotto.model;

import java.util.List;

public class WinningNumber {
    private final List<Integer> winNumber;
    private Integer bonusNumber;

    public WinningNumber(List<Integer> winNumber) {
        duplicateValidate(winNumber);
        sizeValidate(winNumber);
        rangeValidate(winNumber);
        this.winNumber = winNumber;
    }

    private void duplicateValidate(List<Integer> winNumber) {
        if (winNumber.size() != winNumber.stream().distinct().count()) {
            throw new IllegalArgumentException();
        }
    }
    private void rangeValidate(List<Integer> winNumber){
        for (Integer integer : winNumber){
                subRangeValidate(integer);
        }
    }
    private void subRangeValidate(Integer integer){
        if (integer<1||integer>45)
            throw new IllegalArgumentException();
    }
    private void sizeValidate(List<Integer> winNumber){
        if (winNumber.size()!=6){
            throw new IllegalArgumentException();
        }
    }
    private void bonusNumberValidate(Integer bonusNumber){
        subRangeValidate(bonusNumber);
        if (winNumber.contains(bonusNumber)){
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getWinNumber() {
        return winNumber;
    }
    public Integer getBonusNumber(){
        return bonusNumber;
    }

    public void setBonusNumber(Integer inputBonusNumber) {
        bonusNumberValidate(inputBonusNumber);
        this.bonusNumber = inputBonusNumber;
    }
}
