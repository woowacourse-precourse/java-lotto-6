package lotto.io;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleManager {

    public void closeConsole() {
        Console.close();
    }

    public long inputPurchasePrice() {
        String inputPrice = Console.readLine();
        try {
            long price = Long.parseLong(inputPrice);

            if (price < 0) {
                throw new IllegalArgumentException("[ERROR] 구입 금액은 음수일 수 없습니다.");
            } else if (price % 1_000 != 0) {
                throw new IllegalArgumentException("[ERROR] 구입 금액은 천 단위여야 합니다.");
            }

            return price;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자여야 합니다.");
        }
    }

}
