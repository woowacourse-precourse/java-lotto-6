package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

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

    public static void printErrorMessage(String message) {
        System.out.println(message);
    }

    static public Lotto inputWinningNumbers() {
        String[] splitNumbers = Console.readLine().split(",");
        Lotto lotto = null;

        try {
            lotto = new Lotto(convertNumbersType(List.of(splitNumbers)));
        }
        catch (IllegalArgumentException exception) {
            printErrorMessage(exception.getMessage());
            inputWinningNumbers();
        }
        return lotto;
    }

    static private List<Integer> convertNumbersType(List<String> winningNumbers) {
        List<Integer> convertNumbers = new ArrayList<>();

        for (String number : winningNumbers) {
            convertNumbers.add(convertType(number));
        }
        return convertNumbers;
    }

    static private int convertType(String number) {
        int convertNumber;

        try {
            convertNumber = Integer.parseInt(number);
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        return convertNumber;
    }

    static public void printAskingWinningNumbersMessage() {
        System.out.println("당첨 번호를 입력해 주세요.");
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
