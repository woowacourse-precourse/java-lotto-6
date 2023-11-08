package lotto.model;

import lotto.util.MakeStringToInteger;

import java.util.List;

import static lotto.util.Config.lottoMaxNumber;
import static lotto.util.Config.lottoMinNumber;

public class WinningNumber {
    private Integer bonusNumber;
    private final Lotto winningNumber;

    public WinningNumber(List<Integer> winningNumber){
        this.bonusNumber = 0;
        validateWinningNumber(winningNumber);
        this.winningNumber = new Lotto(winningNumber);
    }

    private void validateWinningNumber(List<Integer> winningNumber){
        for(int number : winningNumber){
            validationNumber(number);
        }
    }

    private void validationNumber(Integer number){
        if(number < lottoMinNumber || number > lottoMaxNumber){
            throw new IllegalArgumentException();
        }
    }

    public void setBonusNumber(String bonusNumber) {
        validateBonusNumber(bonusNumber);
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    private void validateBonusNumber(String bonusNumber){
        Integer number = MakeStringToInteger.stringToInteger(bonusNumber);
        if(winningNumber.getLottoNumber().contains(number)) {
           throw new IllegalArgumentException();
        }
        validationNumber(number);
    }

    public Lotto getWinningNumber() {
        return winningNumber;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }
}
