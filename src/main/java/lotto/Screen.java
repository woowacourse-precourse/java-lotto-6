package lotto;

import camp.nextstep.edu.missionutils.Console;

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
        System.out.printf("%s개를 구매했습니다.%n", lottos.size());
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printAskingWinningNumbersMessage() {
        System.out.println("당첨 번호를 입력해 주세요.");
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

    public static void printErrorMessage(String message) {
        System.out.println(message);
    }


    static public int inputBonusNumber(Lotto winningLotto) {
        String bonusNumber = Console.readLine();

        try {
            checkBonusNumber(bonusNumber, winningLotto);
        }
        catch (IllegalArgumentException exception) {
            printErrorMessage(exception.getMessage());
            inputBonusNumber(winningLotto);
        }
        return Integer.parseInt(bonusNumber);
    }

    static private void checkBonusNumber(String bonusNumber, Lotto winningLotto) {
        int checkingNumber;

        try {
            checkingNumber = Integer.parseInt(bonusNumber);
            checkRange(checkingNumber);
            checkInWinningLotto(checkingNumber, winningLotto);
        }
        catch (IllegalArgumentException exception) {
            throw new IllegalArgumentException(exception.getMessage());
        }
    }

    static private void checkRange(int number) {
        if (number < 1 || number > 45)
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    static private void checkInWinningLotto(int number, Lotto winningLotto) {
        if (winningLotto.getNumbers().contains(number))
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 로또 당첨 번호와 중복되어서는 안됩니다.");
    }

    static public void printAskingBonusNumberMessage() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }
}
