package lotto.View;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public int buyingPayConsole() {
        try {
            String buyingPrice = Console.readLine();
            if (buyingPrice.isEmpty()) {
                throw new IllegalArgumentException("[ERROR] 구입 금액을 입력해주세요.");
            }
}
