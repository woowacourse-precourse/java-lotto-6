package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    public int getPurchaseAmount() {
        String amount = "";
        try {
            System.out.println("구입금액을 입력해 주세요.");
            amount = readLine();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getPurchaseAmount();
        }
        System.out.println();
        return Integer.parseInt(amount);
    }
}