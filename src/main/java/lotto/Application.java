package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        getPurchasePrice();

    }

    private static void getPurchasePrice() {
        System.out.println("구입금액을 입력해 주세요.");
        try {
            Integer money = Integer.parseInt(Console.readLine());
            validPrice(money);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 구입금액은 숫자여야 합니다.");
            getPurchasePrice();
        }
    }

    private static void validPrice(Integer money) {
        if (money % 1000 != 0) {
            System.out.println("[ERROR] 로또 1개의 가격은 1,000원입니다. 올바른 구입금액을 입력하셔야 합니다.");
            getPurchasePrice();
        }
    }
}
