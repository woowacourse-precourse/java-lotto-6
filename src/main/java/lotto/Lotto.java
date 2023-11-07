package lotto;

import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class Lotto {
    private List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 번호를 입력해주세요.");
        }
    }

    public void setLottoNum() {
        numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
