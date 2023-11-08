package lotto;

import camp.nextstep.edu.missionutils.Console;

public class User {
    private int amount;
    private int totalPrize;
    private int rate;

    public int getAmount() {
        return amount;
    }

    public void insertAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        while (true) {
            try {
                this.amount = Integer.parseInt(Console.readLine());
                if ((this.amount % 1000) != 0) {
                    throw new IllegalArgumentException();
                }
                return;
            } catch (ArithmeticException e) {
                System.out.println("[ERROR] 금액을 문자가 아닌 숫자로만 입력해 주세요.");
            } catch (IllegalArgumentException i) {
                System.out.println("[ERROR] 1,000단위 금액으로만 입력해 주세요.");
            }
        }
    }
}
