package lotto.view;

import lotto.controller.dto.GameResult;
import lotto.controller.dto.GameResult.LottoGameResult;
import lotto.controller.dto.LottoResult;
import lotto.view.vo.WinningNumbers;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static lotto.controller.dto.LottoResult.LottoResponse;
import static lotto.policy.LottoNumberGeneratePolicy.MAX_NUM;
import static lotto.policy.LottoNumberGeneratePolicy.MIN_NUM;

public class Console {

    private static final Pattern REGEX = Pattern.compile("^[0-9]*$");
    private static final String DELIMITER = ",";
    private static final String LOTTO_DELIMITER = ", ";
    private static final String LOTTO_PREFIX = "[";
    private static final String LOTTO_SUFFIX = "]";
    private static final int MAX_INPUT = 2_100_000_000;
    private static final int LOTTO_PRICE = 1_000;
    public static final int WINNING_NUM_SIZE = 6;

    private WinningNumbers winningNumbers;
    private final Input input;
    private final Output output;

    public Console(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    private void validateNull(String value) {
        if (value == null) {
            throw new IllegalArgumentException("[ERROR] 입력값이 null이 될 수 없습니다.");
        }
    }

    private void validateType(String value) {
        Arrays.stream(value.split(DELIMITER))
                .filter(input -> !isNumeric(input))
                .findAny()
                .ifPresent(input -> {
                    throw new IllegalArgumentException("[ERROR] 입력은 숫자만 가능합니다.");
                });
    }

    private boolean isNumeric(String value) {
        return REGEX.matcher(value).matches();
    }

    public int readMoney() {
        output.println("\n구입금액을 입력해 주세요.");
        while (true) {
            try {
                return validatedMoney();
            } catch (IllegalArgumentException e) {
                output.println(e.getMessage());
            }
        }
    }

    private int validatedMoney() {
        String value = input.read();

        validateNull(value);
        validateType(value);
        validatePrice(value);
        return Integer.parseInt(value);
    }

    private void validatePrice(String value) {
        if (isLowerThanMinimumPrice(value)) {
            throw new IllegalArgumentException("[ERROR] 최소 금액보다는 작은값을 입력하셨습니다.");
        }
        if (isNotDivisibleByMinimumPrice(value)) {
            throw new IllegalArgumentException("[ERROR] 최소 금액으로 나누어 떨어지는 값을 입력해주세요.");
        }
        if (isHigherThanMaxInput(value)) {
            throw new IllegalArgumentException("[ERROR] 최대 금액보다 큰 값을 입력하셨습니다.");
        }
    }

    public List<Integer> readWinningNumbers() {
        output.println("\n당첨 번호를 입력해 주세요.");
        while (true) {
            try {
                return validatedWinningNumbers();
            } catch (IllegalArgumentException e) {
                output.println(e.getMessage());
            }
        }

    }

    private List<Integer> validatedWinningNumbers() {
        String value = input.read();
        validateNull(value);
        validateType(value);

        List<Integer> winningNumbers = Arrays.stream(value.split(DELIMITER))
                .map(Integer::parseInt)
                .toList();
        validateLength(winningNumbers);
        validateRange(winningNumbers);
        validateDuplicate(winningNumbers);
        this.winningNumbers = WinningNumbers.of(winningNumbers);
        return winningNumbers;
    }

    private void validateLength(List<Integer> numbers) {
        if (numbers.size() != WINNING_NUM_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private void validateRange(List<Integer> numbers) {
        numbers.stream().filter(number -> number < MIN_NUM || number > MAX_NUM)
                .findAny()
                .ifPresent(number -> {
                    throw new IllegalArgumentException();
                });
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (hasDuplicatedNumber(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean hasDuplicatedNumber(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .count() != WINNING_NUM_SIZE;
    }

    public int readBonusNumber() {
        output.println("\n보너스 번호를 입력해 주세요.");
        while (true) {
            try {
                return validatedBonusNumber();
            } catch (IllegalArgumentException e) {
                output.println(e.getMessage());
            }
        }
    }

    private int validatedBonusNumber() {
        String value = input.read();
        validateNull(value);
        validateType(value);
        validateDuplicate(Integer.parseInt(value), winningNumbers);
        validateRange(Integer.parseInt(value));
        return Integer.parseInt(value);
    }

    private void validateDuplicate(int number, WinningNumbers winningNumbers) {
        if (winningNumbers.hasDuplicate(number)) {
            throw new IllegalArgumentException();
        }
    }

    private void validateRange(int number) {
        if (isOutOfRange(number)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isOutOfRange(int number) {
        return number < MIN_NUM || number > MAX_NUM;
    }


    private boolean isLowerThanMinimumPrice(String price) {
        return Integer.parseInt(price) < LOTTO_PRICE;
    }

    private boolean isNotDivisibleByMinimumPrice(String price) {
        return Integer.parseInt(price) % LOTTO_PRICE != 0;
    }

    private boolean isHigherThanMaxInput(String price) {
        return Integer.parseInt(price) > MAX_INPUT;
    }

    public void printLottoResults(GameResult gameResult) {
        output.println("\n당첨 통계\n---");

        gameResult.results().forEach(this::printLottoResult);
        printProfitRate(gameResult);
    }

    private void printLottoResult(LottoGameResult result) {

        String LottoResultMessage = MessageFormat.format(
                "{0}개 일치 ({1}원) - {2}개",
                result.matchCount(),
                result.winningMoney(),
                result.count()
        );
        if (result.winningMoney() == 30_000_000) {
            LottoResultMessage = MessageFormat.format(
                    "{0}개 일치, 보너스 볼 일치 ({1}원) - {2}개",
                    result.matchCount(),
                    result.winningMoney(),
                    result.count()
            );
            output.println(LottoResultMessage);
            return;
        }

        output.println(LottoResultMessage);
    }

    private void printProfitRate(GameResult gameResult) {
        String profitRateMessage = MessageFormat.format("총 수익률은 {0}%입니다.", gameResult.profitRate());
        output.println(profitRateMessage);
    }

    public void printLottoCount(int lottoCount) {
        String lottoCountMessage = MessageFormat.format("\n{0}개를 구매했습니다.", lottoCount);
        output.println(lottoCountMessage);
    }

    public void printLottos(LottoResult result) {
        result.responses().forEach(this::printLotto);
    }

    private void printLotto(LottoResponse lottoResponse) {
        String lotto = lottoResponse.numbers().stream()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(LOTTO_DELIMITER, LOTTO_PREFIX, LOTTO_SUFFIX));

        output.println(lotto);
    }

}
