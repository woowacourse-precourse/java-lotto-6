package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.stream.Collectors;
import lotto.model.Lotto;

public class InputView {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;
    private static final int THOUSAND = 1000;
    private static final String SPACE = " ";
    private static final String NO_SPACE = "";
    private static final String COMMA = ",";
    private static final String NEW_LINE = "\n";
    private static final String INVALID_LOTTO_SIZE = "[ERROR] 6자리의 숫자를 입력해 주세요.";
    private static final String INVALID_INT_RANGE = "[ERROR] 너무 큰 금액입니다.";
    private static final String INVALID_DIVISIBLE = "[ERROR] 1000원 단위의 입력이 아닙니다.";
    private static final String INVALID_LOTTO_RANGE = "[ERROR] 로또 번호는 1~45 사이의 숫자입니다.";

    public int inputBuyAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String amount = Console.readLine();
        validateIntRange(amount);
        validateDivisibleByThousand(amount);
        return Integer.parseInt(amount);
    }

    public Lotto inputWinningLotto() {
        System.out.println(NEW_LINE + "당첨 번호를 입력해 주세요.");
        String[] winningNumber = Console.readLine().replaceAll(SPACE, NO_SPACE).split(COMMA);
        validateWinningNumber(winningNumber);
        return new Lotto(
                Arrays.stream(winningNumber)
                        .map(Integer::parseInt)
                        .collect(Collectors.toList())
        );
    }

    public int inputBonusNumber() {
        System.out.println(NEW_LINE + "보너스 번호를 입력해 주세요.");
        String number = Console.readLine();
        validateIntRange(number);
        validateLottoRange(number);
        return Integer.parseInt(number);
    }

    private void validateWinningNumber(String[] numbers) {
        if (numbers.length != LOTTO_SIZE) {
            throw new IllegalArgumentException(INVALID_LOTTO_SIZE);
        }
        for (String number : numbers) {
            validateLottoRange(number);
        }
    }

    private void validateIntRange(String amount) throws IllegalArgumentException {
        try {
            Integer.parseInt(amount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_INT_RANGE);
        }
    }

    private void validateDivisibleByThousand(String amount) {
        int number = Integer.parseInt(amount);
        if (number % THOUSAND != 0) {
            throw new IllegalArgumentException(INVALID_DIVISIBLE);
        }
    }

    private void validateLottoRange(String input) {
        int number = Integer.parseInt(input);
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException(INVALID_LOTTO_RANGE);
        }
    }
}
