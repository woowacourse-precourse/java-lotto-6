package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(Const.winningRangeStartNumber, Const.winningRangeEndNumber, Const.LottoCount);
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
