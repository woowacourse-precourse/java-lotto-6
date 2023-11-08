package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import lotto.constant.LottoInfo;

public class Lotto {
private final List<Integer> numbers;

public Lotto(List<Integer> numbers) {
    validate(numbers);
    this.numbers = numbers;
}

private void validate(List<Integer> numbers) {
    if (numbers.size() != 6) {
        throw new IllegalArgumentException();
    }
}

private LottoInfo getLottoInfo(Lotto answer, int bonus) {
    int match = getMatch(answer);
    boolean hasBonus = numbers.contains(bonus);
    if (match == 6) {
        return LottoInfo.FIRST;
    }
    if (match == 5) {
        if (hasBonus) {
            return LottoInfo.SECOND;
        }
        return LottoInfo.THIRD;
    }
    if (match == 4) {
        return LottoInfo.FOURTH;
    }
    if (match == 3) {
        return LottoInfo.FIFTH;
    }
    return LottoInfo.NOPRIZE;
}

int getRank(Lotto answer, int bonus) {
    return getLottoInfo(answer, bonus).getRank();
}

int getPrize(Lotto answer, int bonus) {
    return getLottoInfo(answer, bonus).getPrize();
}

private int getMatch(Lotto answer) {
    List<Integer> common = numbers.stream().filter(answer.getNumbers()::contains).toList();
    return common.size();
}

public boolean has(int num) {
    return numbers.contains(num);
}


public List<Integer> getNumbers() {
    return numbers;
}

@Override
public String toString() {
    ArrayList<Integer> sortedNumbers = new ArrayList<>(numbers);
    sortedNumbers.sort(Comparator.naturalOrder());
    return sortedNumbers.toString();
}
}
