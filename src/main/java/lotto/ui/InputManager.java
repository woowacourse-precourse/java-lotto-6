package lotto.ui;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputManager {
    public int requestAmount() {
        int amount = 0;
        boolean isValidAmount = false;

        while (!isValidAmount) {
            System.out.println("구입금액을 입력해 주세요.");
            try {
                amount = validateAmount(readLine());
                isValidAmount = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return amount;
    }


    private int validateAmount(String input) {
        if (!input.matches("^[0-9]+$")) throw new IllegalArgumentException("[ERROR] 숫자만 입력하세요.");

        int amount = Integer.parseInt(input);

        if (amount < 1_000) throw new IllegalArgumentException("[ERROR] 로또의 최소 구매 가능 금액은 1,000원입니다.");
        if (amount%1_000 != 0) throw new IllegalArgumentException("[ERROR] 로또는 1,000원 단위로만 구매 가능합니다.");

        return amount;
    }


}
