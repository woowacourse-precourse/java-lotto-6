package lotto.exception;

import lotto.domain.Lotto;

public class InputException {

    public void validateInputNumber(String input) {
        if(!input.matches("^[0-9]*$"))
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
    }

    public void validateUnit(String amount) {
        if(Integer.parseInt(amount)%1000!=0)
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해야 합니다.");
    }
    public void validateInputWinningNumber(String winningNumber) {
        if(!winningNumber.matches("^[0-9,]*$"))
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자와 쉼표(,)로 이루어져야 합니다.");
    }
    public void validateBonusRange(String bonus) {
        if(Integer.parseInt(bonus)<1 || Integer.parseInt(bonus) > 45)
            throw new IllegalArgumentException("[ERROR] 1부터 45 사이의 숫자를 입력해야 합니다.");
    }
    public void validateDuplicateBonus(String bonus, Lotto winningNumber) {
        if(winningNumber.getNumbers().contains(Integer.parseInt(bonus)))
            throw new IllegalArgumentException("[ERROR] 당첨번호와 보너스번호는 중복되면 안됩니다.");
    }
}
