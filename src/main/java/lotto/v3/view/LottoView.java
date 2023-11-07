package lotto.v3.view;

import camp.nextstep.edu.missionutils.Console;

public class LottoView {
    public int requestPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return parseAmount(Console.readLine());
    }

    private int parseAmount(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액으로 숫자를 입력해야 합니다.");
        }
    }
}
