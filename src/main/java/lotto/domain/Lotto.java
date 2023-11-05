package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import lotto.Configuration;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto() {
        this.numbers = new ArrayList<>(
                Randoms.pickUniqueNumbersInRange(Configuration.MIN_LOTTO_NUMBER, Configuration.MAX_LOTTO_NUMBER,
                        Configuration.LOTTO_LENGTH));
        Collections.sort(this.numbers);
    }

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
        Collections.sort(this.numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    private void validate(List<Integer> numbers) {
        final String NUMBER_RANGE_EXCEPTION_MASSAGE = "[ERROR] 로또 번호는 1~45 사이의 숫자여야 합니다.";
        final String NUMBER_COUNT_EXCEPTION_MASSAGE = "[ERROR] 로또 번호는 6개로 이루어져 있어야 합니다.";
        final String NUMBER_DUPLICATED_EXCEPTION_MASSAGE = "[ERROR] 로또 번호는 중복되지 않아야 합니다.";

        if (numbers.size() != 6) {
            throw new IllegalArgumentException(NUMBER_COUNT_EXCEPTION_MASSAGE);
        }
        if (new HashSet<>(numbers).size() != numbers.size()) {
            throw new IllegalArgumentException(NUMBER_DUPLICATED_EXCEPTION_MASSAGE);
        }
        if (numbers.stream()
                .anyMatch(number -> (!isInLottoRange(number)))) {
            throw new IllegalArgumentException(NUMBER_RANGE_EXCEPTION_MASSAGE);
        }
    }

    public static boolean isInLottoRange(int number) {
        return number >= Configuration.MIN_LOTTO_NUMBER && number <= Configuration.MAX_LOTTO_NUMBER;
    }
}
