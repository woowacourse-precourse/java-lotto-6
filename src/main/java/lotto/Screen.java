package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Screen {
    public static void printAskingPurchasingAmountMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static String inputPurchasingAmount() {
        return Console.readLine();
    }

    static public void printAllLottos(List<Lotto> lottos) {
        System.out.printf("\n%s개를 구매했습니다.%n", lottos.size());
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printAskingWinningNumbersMessage() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
    }

    public static List<Integer> inputWinningNumbers() {
        String[] splitNumbers = Console.readLine().split(",");
        return convertType(splitNumbers);
    }

    private static List<Integer> convertType(String[] numbers) {
        try {
            return Stream.of(numbers).map(Integer::parseInt).collect(Collectors.toList());
        }
        catch (NumberFormatException exception) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    static public void printAskingBonusNumberMessage() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
    }

    public static int inputBonusNumber() {
        String bonusNumber = Console.readLine();

        try {
            return Integer.parseInt(bonusNumber);
        }
        catch (NumberFormatException exception) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public static void printErrorMessage(String message) {
        System.out.println(message);
    }

    public static void dispalyResult(Result result) {
        System.out.println("\n당첨 통계\n---");
        displayWinningResult(result);
        displayEarningRate(result);
    }
    private static void displayWinningResult(Result result) {
        System.out.print(result.getWinningResult());
    }

    private static void displayEarningRate(Result result) {
        DecimalFormat formatter = new DecimalFormat("###,###.##");

        System.out.printf("총 수익률은 %s%%입니다.\n", formatter.format(result.getEarningRate()));
    }
}
