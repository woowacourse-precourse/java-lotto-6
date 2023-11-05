package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private static final int LOTTO_SIZE = 6;
    private static final int MAX_NUM = 45;
    private static final int MIN_NUM = 1;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = sortASC(numbers);
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        validateRange(numbers);
    }

    public List<Integer> getNum() {
        return numbers;
    }

    private void validateSize(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 입력하신 번호가 6개가 아닙니다.");
        }
    }

    private void validateDuplicate(List<Integer> numbers) throws IllegalArgumentException {
        Set<Integer> nonDuplicateNum = new HashSet<>(numbers);
        if (nonDuplicateNum.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR] 중복된 로또 번호가 있습니다.");
        }
    }

    private void validateRange(List<Integer> numbers) {
        numbers.forEach(this::validateRange);
    }

    private void validateRange(Integer number) throws IllegalArgumentException {
        if(number < MIN_NUM || number > MAX_NUM) {
            throw new IllegalArgumentException("[ERROR] 1~45를 벗어나는 숫자가 있습니다.");
        }
    }

    public List<Integer> sortASC(List<Integer> numbers) {
        return numbers.stream().sorted().collect(Collectors.toList());
    }

    public boolean isContain(int num) {
        return numbers.contains(num);
    }

    public int getMatchLottoNum(UserLottoNum userLottoNum) {
        return (int) numbers.stream()
                .filter(userLottoNum::isContain)
                .count();
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
