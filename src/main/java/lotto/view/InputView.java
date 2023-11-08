package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final String ERROR_PROMPT = "[ERROR] ";
    private static final String COMMA = ",";

    public int requestLottoPurchase() {
        int input;
        while (true) {
            try {
                input = Integer.parseInt(Console.readLine());
                validateLottoPurchase(input);
                break;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(ERROR_PROMPT + "금액으로 숫자를 입력해주세요.");
            }
        }
        return input;
    }

    private void validateLottoPurchase(int input) {
        if (input % 1000 != 0) {
            throw new IllegalArgumentException(ERROR_PROMPT + "1000원 단위로 입력해주세요.");
        }
    }

    public int requestBonusNumber() {
        int input;
        while (true) {
            try {
                input = Integer.parseInt(Console.readLine());
                validateLottoNumber(input);
                break;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(ERROR_PROMPT + "금액으로 숫자를 입력해주세요.");
            }
        }
        return input;
    }

    private void validateLottoNumber(int input) {
        if (input < 1 || 45 < input) {
            throw new IllegalArgumentException(ERROR_PROMPT + "로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public List<Integer> requestWinningNumbers() {
        List<Integer> winningNumbers;
        while (true) {
            try {
                winningNumbers = Arrays.stream(Console.readLine().split(COMMA))
                        .map(String::trim)
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
                validateLottoNumbers(winningNumbers);
                break;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(ERROR_PROMPT + "로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
        return winningNumbers;
    }

    private void validateLottoNumbers(List<Integer> numbers) {
        for (int number : numbers) {
            validateLottoNumber(number);
        }
    }
}