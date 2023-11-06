package lotto.domain;

public class UserInputChecker {
    public UserInputChecker() {
    }
    public int checkPurchaseAmount(String inputPurchaseAmount) {
        int purchaseAmount = Integer.parseInt(inputPurchaseAmount);
        try {
            checkInputUnit(purchaseAmount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return purchaseAmount;
    }
    public int checkInputUnit(int purchaseAmount) { //구입금액 단위 확인
        if (purchaseAmount % 1000 != 0)
            throw new IllegalArgumentException("[ERROR] 구입금액은 1000원 단위로만 입력 가능합나다.");
        return purchaseAmount;
    }
    public void checkInt(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닙니다.");
        }
    }

}
