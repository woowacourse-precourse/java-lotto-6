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

    public List<Lotto> makeLottos(int lottoAmount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int count = 1; count <= lottoAmount; count++) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            lottos.add(lotto);
        }

        return lottos;
    }
    public List<Integer> getNumbers() {
        return numbers;
    }


}
