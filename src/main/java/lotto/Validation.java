package lotto;

public class Validation {

    public int parsePurchaseAmount(String userInput) {
        int inputMoney = 0;
        try {
            inputMoney = Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] : 숫자가 아닌 입력입니다.");
        }

        return inputMoney;
    }

    public void validateUnderZero(int money) {
        if(money < 0) {
            throw new IllegalArgumentException("[ERROR] : 0보다 큰 숫자를 입력해야 합니다.");
        }
    }

    public void validateDivideThousand(int money) {
        if(money%1000 != 0) {
            throw new IllegalArgumentException("[ERROR] : 입력 금액은 1000 단위여야 합니다.");
        }
    }
}
