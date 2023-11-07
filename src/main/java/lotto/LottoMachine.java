package lotto;

import java.util.List;

public class LottoMachine {
    //    private List<Integer> winningNumber = new ArrayList<>();
    // 크기가 정해져있고, 불편해서 배열쓰는게 나을수도....
    private List<Integer> winningNumber;
    private int bonusNumber;

    public LottoMachine() {
        String[] winningNumberInput = BuyerInfoInput.inputWinningNumber();
        validateWinningNumber(winningNumberInput);
        String bonusNumberInput = BuyerInfoInput.inputBonusNumber();
        validateBonusNumber(bonusNumberInput, winningNumberInput);

        for (String num : winningNumberInput) {
            this.winningNumber.add(Integer.parseInt(num));
        }

        this.bonusNumber = Integer.parseInt(bonusNumberInput);

    }

    public List<Integer> getWinningNumber() {
        return winningNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void validateWinningNumber(String[] winningNumber) {
        Validator.isWinningNumberValid(winningNumber);
        Validator.isWinningNumberDistinct(winningNumber);
        Validator.isWinningNumberSizeValid(winningNumber);
    }

    public void validateBonusNumber(String bonusNumber, String[] winningNumber) {
        Validator.isBonusNumberValid(bonusNumber);
        Validator.isBonusNumberDistinct(winningNumber, bonusNumber);
    }


}
