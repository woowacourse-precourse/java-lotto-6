package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.stream.Collectors;

public class Screen {
    static public int inputPurchasingAmount() {
        String puchasingAmount = Console.readLine();

        try {
            checkPurchasingAmount(puchasingAmount);
        }
        catch (IllegalArgumentException exception) {
            printErrorMessage(exception.getMessage());
            inputPurchasingAmount();
        }
        return Integer.parseInt(puchasingAmount);
    }

    static private void checkPurchasingAmount(String purchasingAmount) {
        if (!isValidPurchasingAmount(purchasingAmount))
            throw new IllegalArgumentException("[ERROR] 구입금액은 1000 단위이어야 합니다.");
    }

    static private boolean isValidPurchasingAmount(String purchasingAmount) {
        return purchasingAmount.matches("^[1-9]\\d*000$");
    }

    static public void printPurchasingAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    static public void printAllLottos(List<Lotto> lottos) {
        System.out.printf("%s개를 구매했습니다.%n", lottos.size());
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    static public Lotto inputWinningNumbers() {
        String[] splitNumbers = Console.readLine().split(",");
        Lotto lotto = null;

        try {
            checkWinningNumbers(splitNumbers);
            lotto = new Lotto(convertNumbersType(List.of(splitNumbers)));
        }
        catch (IllegalArgumentException exception) {
            printErrorMessage(exception.getMessage());
            inputWinningNumbers();
        }
        return lotto;
    }

    static private void checkWinningNumbers(String[] winningNumbers) {
        int idx = 0;

        while (idx < winningNumbers.length) {
            checkValidNumber(winningNumbers[idx]);
            idx++;
        }
    }

    static private void checkValidNumber(String number) {
        if (!isNumber(number))
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    static private boolean isNumber(String number) {
        return number.matches("\\d+");
    }

    static private List<Integer> convertNumbersType(List<String> numbers) {
        return numbers.stream().map(Integer::parseInt).collect(Collectors.toList());
    }

    static public void printAskingWinningNumbersMessage() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    static private void printErrorMessage(String message) {
        System.out.println(message);
    }

}
