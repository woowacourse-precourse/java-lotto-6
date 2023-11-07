package lotto;

import java.util.*;

import camp.nextstep.edu.missionutils.Randoms;

public class Lotto {
    static final int LOTTO_SIZE = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException();
        }

        // 중복 값 확인
        Set<Integer> check = new HashSet<>(numbers);
        if (check.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException();
        }

        // 값 순서 정렬
        Collections.sort(numbers);
    }

    public LottoMatchResult matchWinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        int matched = 0;
        boolean hasBonus = false;

        Set<Integer> check = new HashSet<>(winningNumbers);

        for (int number : numbers) {
            if (check.contains(number)) {
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
