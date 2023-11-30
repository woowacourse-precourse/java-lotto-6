package lotto.model;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private UserLottoUtil userLottoUtil = new UserLottoUtil();

    public Lotto(List<Integer> numbers) {
        userLottoUtil.validateSizeUserLotto(numbers);
        userLottoUtil.duplicateLotto(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
