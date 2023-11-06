package lotto;

import java.util.List;

public class Bonus {
    private final Integer number;
    private final Lotto lotto;


    public Bonus(Integer number, Lotto lotto) {
        validate(number, lotto);
        this.number = number;
        this.lotto = lotto;
    }

    private void validate(Integer number, Lotto lotto) {
        List<Integer> lottoNumbers = lotto.getNumbers();

        if (!(number >= 1 && number <= 45)) {
            throw new IllegalArgumentException(); // 보너스 번호는 1부터 45 사이의 숫자여야 합니다.
        }

        if (lottoNumbers.contains(number)) {
            throw new IllegalArgumentException(); // 보너스 번호는 중복이 아니여야 합니다.
        }
    }
}
