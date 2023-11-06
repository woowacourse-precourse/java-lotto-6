package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    static int askPurchaseAmount() {
        System.out.println("구매금액을 입력해 주세요.");
        String input = Console.readLine();
        return validate(input);
    }

    static int validate(String input) {
        int purchaseAmount = 0;
        try {
            purchaseAmount = Integer.parseInt(input);
            if (purchaseAmount % 1000 != 0) {
                throw new IllegalArgumentException();
            }
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 구매금액으로 숫자 외의 값을 입력했습니다.");
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 구매금액이 1,000원으로 나누어 떨어지지 않습니다.");
        } finally {
            askPurchaseAmount();
        }

        return purchaseAmount;
    }
}
