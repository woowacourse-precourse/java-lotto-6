package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
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
