package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Purchase {
    private int getCost() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        try {
            int cost = Integer.parseInt(input);
            if (cost < 0) {
                throw new IllegalArgumentException();
            }
            if (cost % 1000 != 0) {
                throw new IllegalArgumentException();
            }
            return cost;
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        }
    }

    public int totalCost() {
        while (true) {
            try {
                int total = getCost();
            return total;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자를 입력하세요.");
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 금액은 천 단위의 양수여야 합니다.");
            }
        }
    }

    public int getAmount(int money) {
        return (money / 1000);
    }
}
