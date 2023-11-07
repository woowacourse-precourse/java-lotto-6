package lotto;

import java.util.List;

public class InputValidator {
    public int validateAndReturnLottoInput(String inputMoney) throws IllegalArgumentException {
        int money = Integer.parseInt(inputMoney);
        validateMoneyUnit(money);
        return money;
    }
    private void validateMoneyUnit(int money) {
        if ((money % 1000) != 0) {
            throw new IllegalArgumentException("OUT OF UNIT!");
        } else if (money <= 0) {
            throw new IllegalArgumentException("PURCHASE MONEY MUST BE POSITIVE!");
        }
    }

//    public boolean winningNumberValidate() {}
//    private boolean checkDuplicateNumber(List<Integer> winNumbers) throws IllegalAccessException {}
//    private boolean checkWinNumberSize(List<Integer> winNumbers) throws IllegalAccessException {}
//    private boolean checkNumbersRange(List<Integer> winNumbers) throws IllegalAccessException {}
//    private boolean checkCorrectNumber(int number) {}
}
