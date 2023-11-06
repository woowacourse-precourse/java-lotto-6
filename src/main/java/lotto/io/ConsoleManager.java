package lotto.io;

import camp.nextstep.edu.missionutils.Console;
import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lotto.BonusNumber;
import lotto.Lotto;
import lotto.WinningType;
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

    public BonusNumber inputBonusNumber(final Lotto numbers) {
        while (true) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.");

                String inputBonusNumber = Console.readLine();

                return new BonusNumber(inputBonusNumber, numbers);
            } catch (IllegalArgumentException e) {
                this.printError(e);
            }
        }
    }

    public void printStatics(Map<WinningType, Integer> statics) {
        System.out.println("당첨 통계");
        System.out.println("---");
        Arrays.stream(WinningType.values())
                .filter(type -> type != WinningType.NONE)
                .forEach(type -> {
                    Integer count = statics.get(type);
                    String message = MessageFormat.format("{0}{1}개", type.getMessage(), count);
                    System.out.println(message);
                });
    }

    public void printProfitRate(float profitRate) {
        DecimalFormat decimalFormat = new DecimalFormat("#.0");

        String message = "총 수익률은 " + decimalFormat.format(profitRate) + "%입니다.";

        System.out.println(message);
    }
}
