package lotto.controller;

import static lotto.config.LottoConfig.MAX_NUMBER;
import static lotto.config.LottoConfig.MIN_NUMBER;
import static lotto.config.LottoConfig.NUMBER_OF_NUMBERS;
import static lotto.config.LottoConfig.PRICE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.view.OutputView;

public class LottoController {
    private final List<Lotto> lottos;
    private final int lottoAmount;

    public LottoController(int purchaseAmount) {
        this.lottoAmount = calculateLottoAmount(purchaseAmount);
        this.lottos = makeLottos();
    }

    private int calculateLottoAmount(int purchaseAmount) {
        return purchaseAmount / PRICE.getNumber();
    }

    private List<Lotto> makeLottos() {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoAmount; i++) {
            lottos.add(new Lotto(makeRandomLottoNumbers()));
        }
        return lottos;
    }

    private List<Integer> makeRandomLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_NUMBER.getNumber(),
                MAX_NUMBER.getNumber(),
                NUMBER_OF_NUMBERS.getNumber());
    }

    public void printLottos() {
        for (Lotto lotto : lottos) {
            OutputView.printMessage(lotto.getNumbersNaturalOrder());
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getLottoAmount() {
        return lottoAmount;
    }
}
