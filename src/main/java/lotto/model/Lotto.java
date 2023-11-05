package lotto.model;

import static lotto.constant.LottoMessage.LOTTO_NUMBERS_DELIMITER;
import static lotto.constant.LottoRuleConstant.LOTTO_MAX_NUM;
import static lotto.constant.LottoRuleConstant.LOTTO_MIN_NUM;
import static lotto.constant.LottoRuleConstant.LOTTO_SIZE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto() {
        numbers = createAutoLottoNumbers();

        numbers.sort(Comparator.naturalOrder());
    }

    public Lotto(List<Integer> numbers) {
        validateLottoNumber(numbers);

        this.numbers = new ArrayList<>(numbers);

        this.numbers.sort(Comparator.naturalOrder());
    }

    private List<Integer> createAutoLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUM, LOTTO_MAX_NUM, LOTTO_SIZE);
    }

    private void validateLottoNumber(List<Integer> numbers) {
        checkNumberCount(numbers);
        checkDuplicateNumber(numbers);
        checkRange(numbers);
    }

    private void checkNumberCount(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개입니다.");
        }
    }

    private void checkDuplicateNumber(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>(numbers);

        if (numbers.size() != numberSet.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복된 숫자를 가질 수 없습니다.");
        }
    }

    private void checkRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(number -> checkMinimum(number) || checkMaximum(number))) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1이상 45이하의 수만 가능합니다.");
        }
    }

    private boolean checkMinimum(Integer number) {
        return number < LOTTO_MIN_NUM;
    }

    private boolean checkMaximum(Integer number) {
        return number > LOTTO_MAX_NUM;
    }

    @Override
    public String toString() {
        return numbers.stream().map(String::valueOf).collect(Collectors.joining(LOTTO_NUMBERS_DELIMITER));
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
