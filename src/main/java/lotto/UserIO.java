package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class UserIO {

    public static Amount scanPayment() {
        while (true) {
            System.out.println("구입금액을 입력해 주세요.");
            try {
                return new Amount(Console.readLine());
            } catch (IllegalArgumentException exception) {
                printLottoErrorMessage(exception.getMessage());
            }
        }
    }

    private static void validateLastComma(String value) {
        if (value.isBlank()) {
            return;
        }
        char lastChar = value.charAt(value.length() - 1);
        if (lastChar == ',') {
            throw new IllegalArgumentException("콤마(,)로 끝낼 수 없습니다.");
        }
    }

    private static List<Integer> convertToIntegerList(String winningNumbers) {
        try {
            return Arrays.stream(winningNumbers.split(","))
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException("숫자만 입력가능 합니다.");
        }
    }

    public static Lotto scanWinningsLotto() {
        while (true) {
            System.out.println("당첨 번호를 입력해 주세요.");
            String winningNumbers = Console.readLine();
            try {
                validateLastComma(winningNumbers);
                return new Lotto(convertToIntegerList(winningNumbers));
            } catch (IllegalArgumentException illegalArgumentException) {
                printLottoErrorMessage(illegalArgumentException.getMessage());
            }
        }
    }

    private static int convertToInteger(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
    }

    public static BonusNumber scanBonusNumber(Lotto winningsLotto) {
        while (true) {
            System.out.println("보너스 번호를 입력해 주세요.");
            try {
                int number = convertToInteger(Console.readLine());
                return new BonusNumber(winningsLotto, number);
            } catch (IllegalArgumentException illegalArgumentException) {
                printLottoErrorMessage(illegalArgumentException.getMessage());
            }
        }
    }

    public static void printLottoErrorMessage(String value) {
        System.out.printf(ErrorMessage.ERROR_FORMAT + "\n", value);
    }
}
