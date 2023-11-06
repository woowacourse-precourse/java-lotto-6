package lotto.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WinningLotto {
    private static final String TYPE_ERROR_MESSAGE = "숫자를 입력해 주세요.";
    private static final String SIZE_ERROR_MESSAGE = "6개의 숫자를 입력해 주세요.";
    private static final String RANGE_ERROR_MESSAGE = "1부터 45까지의 범위를 가져야 합니다.";
    private static final String DUPLICATE_ERROR_MESSAGE = "중복된 숫자는 허용하지 않습니다.";
    private static final String SPLIT_DELIMITER = ",";
    private static final int MIN = 1;
    private static final int MAX = 45;
    private static final int LOTTO_SIZE = 6;
    private static final int WINNING_LOTTO_SIZE = 7;

    private final Lotto winningLotto;
    private final int bonusNumber;

    private WinningLotto(Lotto winningLotto, int bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto of(String inputLottoNumbers, String inputBonusNumber) {
        List<Integer> lottoNumbers = parse(inputLottoNumbers);
        validateSize(lottoNumbers);

        validateType(inputBonusNumber);
        int bonusNumber = Integer.parseInt(inputBonusNumber);
        validateRange(bonusNumber);

        validateDup(lottoNumbers, bonusNumber);
        return new WinningLotto(Lotto.from(lottoNumbers), bonusNumber);
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private static List<Integer> parse(String inputLottoNumbers) {
        return Arrays.stream(inputLottoNumbers.split(SPLIT_DELIMITER))
                .peek(WinningLotto::validateType)
                .map(Integer::parseInt)
                .peek(WinningLotto::validateRange)
                .sorted()
                .collect(Collectors.toList());
    }

    private static void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(SIZE_ERROR_MESSAGE);
        }
    }

    private static void validateType(String inputData) {
        try {
            Integer.parseInt(inputData);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(TYPE_ERROR_MESSAGE);
        }
    }

    private static void validateRange(int number) {
        if (number < MIN || number > MAX) {
            throw new IllegalArgumentException(RANGE_ERROR_MESSAGE);
        }
    }

    private static void validateDup(List<Integer> lottoNumbers, int bonusNumber) {
        Set<Integer> numbers = new HashSet<>(lottoNumbers);
        numbers.add(bonusNumber);

        if (numbers.size() != WINNING_LOTTO_SIZE) {
            throw new IllegalArgumentException(DUPLICATE_ERROR_MESSAGE);
        }
    }
}
