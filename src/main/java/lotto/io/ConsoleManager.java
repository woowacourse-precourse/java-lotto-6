package lotto.io;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleManager {

    public void closeConsole() {
        Console.close();
    }

    public long inputPurchasePrice() {
        System.out.println("구입금액을 입력해 주세요.");

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

    public void printLottoCount(final long count) {
        System.out.println(count + "개를 구매했습니다.");
    }

}
