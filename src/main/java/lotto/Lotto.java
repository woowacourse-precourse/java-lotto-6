package lotto;

import java.util.*;

import camp.nextstep.edu.missionutils.Randoms;

public class Lotto {
    static final int LOTTO_SIZE = 6;
    static final int LOTTO_NUMBER_MIN = 1;
    static final int LOTTO_NUMBER_MAX = 45;

    private static final String ERROR_LOTTO_SIZE = "로또는 %d개의 숫자로 이루어져야합니다.";
    private static final String ERROR_NOT_LOTTO_NUMBER = "로또 번호는 %d부터 %d 사이의 숫자여야 합니다.";
    private static final String ERROR_DUPLICATE = "로또는 중복되지 않은 값이어야 합니다.";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(String.format(ERROR_LOTTO_SIZE, LOTTO_SIZE));
        }

        // 값 범위 확인
        for (Integer number : numbers) {
            if (number < LOTTO_NUMBER_MIN || number > LOTTO_NUMBER_MAX) {
                throw new IllegalArgumentException(String.format(ERROR_NOT_LOTTO_NUMBER, LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX));
            }
        }

        // 중복 값 확인
        Set<Integer> check = new HashSet<>(numbers);
        if (check.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(ERROR_DUPLICATE);
        }
    }

    public LottoMatchResult matchWinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        int matched = 0;
        boolean hasBonus = false;

        for (int number : numbers) {
            if (winningNumbers.contains(number)) {
                matched++;
            }

            if (number == bonusNumber) {
                hasBonus = true;
            }
        }

        return LottoMatchResult.fromMatchedCount(matched, hasBonus);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    public static Lotto generateRandomLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }

    public static List<Lotto> generateRandomLottos(int number) {
        List<Lotto> generatedLottos = new ArrayList<>();

        for (int i = 0; i < number; i++) {
            generatedLottos.add(generateRandomLotto());
        }

        return generatedLottos;
    }
}
