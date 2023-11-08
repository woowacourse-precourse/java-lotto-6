package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Purchase {
    private int cost;
    private int amount;

    private void checkCost(String raw) {
        try {
            this.cost = Integer.parseInt(raw);
            if (cost < 0) {
                throw new IllegalArgumentException("[ERROR] 금액은 음수일 수 없습니다.");
            }
            if (cost % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 금액은 천 단위의 수여야 합니다.");
            }
        } catch (NumberFormatException e) {
            throw new NumberFormatException("[ERROR] 숫자를 입력하세요.");
        }
    }

    private void totalCost() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                String input = Console.readLine();
                checkCost(input);
                return;
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void calcAmount() {
        this.amount = this.cost / 1000;
    }

    public int getAmount() {
        totalCost();
        calcAmount();
        System.out.printf("\n%d개를 구매했습니다.", this.amount);
        return this.amount;
    }
}
