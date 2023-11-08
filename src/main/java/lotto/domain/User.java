package lotto.domain;
import camp.nextstep.edu.missionutils.Console;
public class User {
    private int userPurchaseAmount;
    public User() {
    }

    public int setUserPurchaseAmount(int userPurchaseAmount) {
        return this.userPurchaseAmount = userPurchaseAmount;
    }
    public int getUserPurchaseAmount() {
        return userPurchaseAmount;
    }

    public boolean validateUserPurchaseAmount() {
        if (userPurchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000원 단위로 가능합니다.");

        }
        return true;
    }


    public int buyLotto(String userInput) {
        try {
            setUserPurchaseAmount(Integer.parseInt(userInput));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 숫자만 가능합니다.");
        }
        validateUserPurchaseAmount();
        return userPurchaseAmount/1000;
    }
}
