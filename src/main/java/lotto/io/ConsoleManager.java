package lotto.io;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleManager {

    public void closeConsole() {
        Console.close();
    }

    public void printError(Exception e) {
        System.out.println(e.getMessage());
    }

    public Price inputPurchasePrice() {
        while (true) {
            System.out.println("구입금액을 입력해 주세요.");
            String inputPrice = Console.readLine();

            try {
                return new Price(inputPrice);
            } catch (IllegalArgumentException e) {
                this.printError(e);
            }
        }
    }

    public void printLottoCount(final long count) {
        System.out.println(count + "개를 구매했습니다.");
    }

}
