package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Lotto {
    private static final int TWO_LOTTO_SIZE = 12;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        HashSet<Integer> nonDuplicate = new HashSet<>(numbers);
        if (nonDuplicate.size() != numbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * 정렬된 로또 번호를 출력
     *
     * @return 정렬된 로또 번호
     */
    @Override
    public String toString() {
        List<Integer> copied = new ArrayList<>(numbers);
        Collections.sort(copied);
        return copied.toString();
    }

    /**
     * 당첨 로또와 비교
     * <p>
     * 당첨 로또 번호와의 중복 번호 갯수를 구함.
     *
     * @param selectedLottos 당첨 로또
     * @return 일치하는 번호 갯수
     */
    public int compareWithSelected(List<Integer> selectedLottos) {
        int count = 0;
        List<Integer> sum = new ArrayList<>(numbers);
        sum.addAll(selectedLottos);
        HashSet<Integer> nonDuplicate = new HashSet<>(sum);
        count = TWO_LOTTO_SIZE - nonDuplicate.size();

        return count;
    }

    public boolean findBonus(int bonus) {
        return numbers.contains(bonus);
    }
}
