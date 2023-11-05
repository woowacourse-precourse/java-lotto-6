package lotto.view.input;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleInput implements Input{

    @Override
    public int inputPurchaseAmount() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 로또 구매 금액은 숫자를 입력해주세요.");
        }
    }
}
