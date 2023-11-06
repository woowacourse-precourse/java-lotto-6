package lotto.domain;


import java.util.NoSuchElementException;

public class Money {
    private int money;

    public Money(String inputMoney) {
        isInteger(inputMoney);
        money = Integer.parseInt(inputMoney);
        isThousands(money);
    }

    public void isInteger(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) < '0' || input.charAt(i) > '9') {
                System.out.println("[ERROR] 숫자만 입력해주시기 바랍니다.");
                throw new NoSuchElementException();
            }
        }
    }

    public void isThousands(int money) {
        if (money % 1000 != 0) {
            System.out.println("[ERROR] 구입 금액은 1000의 단위여야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    public int getMoney() {
        return money;
    }
}
