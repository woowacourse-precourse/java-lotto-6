package lotto.module.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import lotto.global.constant.CommonCode;
import lotto.global.constant.WinAmount;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public Lotto() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(CommonCode.MIN_LOTTO_NUM,
                CommonCode.MAX_LOTTO_NUM, CommonCode.LOTTO_NUM_COUNT);
        validate(randomNumbers);
        this.numbers = randomNumbers;
    }

    private void validate(List<Integer> numbers) {
        // 6개 당첨번호
        if (numbers.size() != CommonCode.LOTTO_NUM_COUNT) {
            throw new IllegalArgumentException("[ERROR] 로또번호는 6개이어야 합니다.");
        }
        // 중복체크
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자는 입력불가합니다.");
        }
        // 1-45 범위 숫자체크
        if (numbers.stream().anyMatch(num -> num < CommonCode.MIN_LOTTO_NUM || num > CommonCode.MAX_LOTTO_NUM)) {
            throw new IllegalArgumentException("[ERROR] 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public long findWinCount(Lotto winLotto, int bonusNumber) {
        long winCount = numbers
                .stream()
                .filter(x -> winLotto.numbers.stream().anyMatch(Predicate.isEqual(x)))
                .count();
        // 5개 맞췄을 경우, 보너스번호 체크
        if (winCount == WinAmount.FIFTH.getMatchCount() && numbers.stream().anyMatch(Predicate.isEqual(bonusNumber))) {
            return WinAmount.FIFTH_WITH_BONUS.getMatchCount();
        }
        return winCount;
    }

    public boolean contains(Integer target) {
        return numbers.contains(target);
    }

    public void print() {
        System.out.println(
                numbers.stream()
                        .sorted()
                        .map(String::valueOf)
                        .collect(Collectors.joining(", ", "[", "]"))
        );
    }
}
