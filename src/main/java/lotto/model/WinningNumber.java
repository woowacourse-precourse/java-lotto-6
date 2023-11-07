package lotto.model;

import lotto.util.CheckParameter;

import java.util.List;

public class WinningNumber {
    private final Integer maxNumber = 45;
    private final Integer minNumber = 1;
    private Integer bonusNumber;
    private final Lotto winningNumber;

    public WinningNumber(List<Integer> winningNumber){
        this.bonusNumber = 0;
        validateWinningNumber(winningNumber);
        this.winningNumber = new Lotto(winningNumber);
    }

    private void validateWinningNumber(List<Integer> winningNumber){
        for(int number : winningNumber){
            if(number < minNumber || number > maxNumber){
                throw new IllegalArgumentException();
            }
        }
    }

    public void setBonusNumber(String bonusNumber) {
        validateBonusNumber(bonusNumber);
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    private void validateBonusNumber(String bonusNumber){
        if(!CheckParameter.checkIsNumber(bonusNumber)){
            throw new IllegalArgumentException();
        }

       if(winningNumber.getLottoNumber().contains(Integer.parseInt(bonusNumber))){
            throw new IllegalArgumentException();
        }
    }

    public Lotto getWinningNumber() {
        return winningNumber;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }
}
