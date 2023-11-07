package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        duplicateValidate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자를 입력해주세요.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    // TODO: 추가 기능 구현
    public static Lotto createWinningNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(Const.LOTTO_MAX_NUMBER, Const.LOTTO_MIN_NUMBER, Const.LOTTO_SIZE);
        List<Integer> lottoNumbers = new ArrayList<>(numbers);
        Collections.sort(lottoNumbers);

        return new Lotto(lottoNumbers);
    }

    private void duplicateValidate(List<Integer> numbers) {
        Set<Integer> nonDuplicateNumbers = new HashSet<>();
        for (Integer number : numbers) {
            if (!nonDuplicateNumbers.add(number)) {
                throw new IllegalArgumentException("[ERROR] 숫자들은 중복되지 않아야 합니다.");
            }
        }
    }

    public static Lotto createUserNumbers(List<Integer> userNumbers) {
        return new Lotto(userNumbers);
    }
}
