package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import msg.ErrorMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoConfig.COUNT) {
            throw new IllegalArgumentException(ErrorMessage.COUNT_DIFFERENCE.value());
        }
        List<Integer> uniqueNumbers = new ArrayList<>();
        numbers.forEach(number -> {
            if (uniqueNumbers.contains(number)) {
                throw new IllegalArgumentException(ErrorMessage.DUPLICATE.value());
            }
            uniqueNumbers.add(number);
        });
        numbers.forEach(number -> {
            if (number < LottoConfig.START_NUM || number > LottoConfig.END_NUM) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER.value());
            }
        });
    }

    public String sayNumbers() {
        ArrayList<Integer> sortableNumbers = new ArrayList<>(numbers);
        Collections.sort(sortableNumbers);
        return sortableNumbers.stream().map(String::valueOf).collect(Collectors.joining(", "));
    }

    public LottoPrize match(List<Integer> commonNumbers, int bonusNumber) {
        int hitTimes = 0;
        boolean hitBonus = false;
        for (Integer number : numbers) {
            if (commonNumbers.contains(number)) {
                hitTimes = hitTimes + 1;
            }
        }
        if (numbers.contains(bonusNumber)) {
            hitBonus = true;
        }

        return LottoPrize.of(hitTimes, hitBonus);
    }
}
