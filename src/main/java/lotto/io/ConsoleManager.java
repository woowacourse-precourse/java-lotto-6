package lotto.io;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.Lotto;
import lotto.vo.Price;

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

    public void printLottoCount(final int count) {
        System.out.println("\n" + count + "개를 구매했습니다.");
    }

    public void printLotto(List<Lotto> lottos) {
        lottos.forEach(System.out::println);
    }

    public Lotto inputWinningLottoNumbers() {
        while (true) {
            System.out.println("당첨 번호를 입력해 주세요.");
            String inputWinningNumbers = Console.readLine();

            try {
                return new Lotto(inputWinningNumbers);
            } catch (IllegalArgumentException e) {
                this.printError(e);
            }
        }
    }
}
