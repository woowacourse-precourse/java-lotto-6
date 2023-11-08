package lotto.domain;

import static lotto.domain.policy.LottoSizePolicy.LOTTO_SIZE;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        verifyDuplicatedNumber(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE.getSize()) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현

    /**
     * 중복수 검사
     */
    private void verifyDuplicatedNumber(List<Integer> numbers) throws IllegalArgumentException {
        for (int i = 0; i < numbers.size(); i++) {
            for (int j = i + 1; j < numbers.size(); j++) {
                if (Objects.equals(numbers.get(i), numbers.get(j))) {
                    throw new IllegalArgumentException();
                }
            }
        }
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    public int getSize() {
        return this.numbers.size();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    /**
     * 다른 로또에 대한 일치숫자 개수 계산
     */
    public int getMatchNumberCount(Lotto thatLotto) {
        List<Integer> thatLottoNumbers = thatLotto.getNumbers();
        AtomicInteger matchCount = new AtomicInteger();
        this.numbers.forEach(number -> {
            if (thatLottoNumbers.contains(number)) {
                matchCount.addAndGet(1);
            }
        });
        return matchCount.get();
    }

    /**
     * 보너스 번호 계산
     */
    public boolean hasBonusNumber(int bonus) {
        return this.numbers.contains(bonus);
    }
}
