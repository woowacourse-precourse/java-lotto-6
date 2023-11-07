package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.Money;
import lotto.view.OutputView;

public class LottoGenerateService {

    private static final int LOTTO_SIZE = 6;
    private static final int MIN_LOTTO_NUM = 1;
    private static final int MAX_LOTTO_NUM = 45;

    private final OutputView outputView;

    public LottoGenerateService(OutputView outputView) {
        this.outputView = outputView;
    }

    public Lottos makeLotto(Money money) {
        return new Lottos(generateLottos(money.calNumberOfLotto()));
    }

    private List<Lotto> generateLottos(int number) {
        List<Lotto> lottos = new ArrayList<>();
        for (int count = 0; count < number; count++) {
            List<Integer> list = generateLotto();
            outputView.showLottos(list);
            lottos.add(new Lotto(list));
        }
        return lottos;
    }

    private List<Integer> generateLotto() {
        return Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUM, MAX_LOTTO_NUM, LOTTO_SIZE);
    }

}