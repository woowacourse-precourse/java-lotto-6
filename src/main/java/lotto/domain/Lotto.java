package lotto.domain;

import lotto.enums.LottoEnum;

import java.util.*;
import java.util.stream.Collectors;

import static lotto.LottoConst.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream()
            .sorted()
            .collect(Collectors.toUnmodifiableList());
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_COUNT) {
            throw new IllegalArgumentException("로또 숫자는 6개가 존재해야합니다");
        }
        Set<Integer> set = new HashSet<>();
        for (int number : numbers) {
            if (!set.add(number)){
                throw new IllegalArgumentException("중복되는 숫자가 존재합니다");
            }
        }
    }

    public LottoEnum countResult(WinNum winNum) {
        int count = 0, bonusCount = 0;

        for (int number : numbers) {
            count += winNum.count(number);
            bonusCount += winNum.bonusCount(number);
        }

        return LottoEnum.getLottoEnum(count, bonusCount);
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for (int number : numbers) {
            sb.append(number).append(", ");
        }
        int index = sb.lastIndexOf(", ");
        sb.delete(index, sb.length());
        sb.append("]");
        return sb.toString();
    }
}
