package lotto.controller.subcontroller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.repository.LottoRepository;
import lotto.view.InputView;
import lotto.view.OutputView;

public class IssueLottoController implements Controllable {
    private static final int LOTTO_UNIT = 1000;

    private final InputView inputView;
    private final OutputView outputView;

    public IssueLottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    @Override
    public void process() {
        int purchase = inputView.inputPurchaseLotto();
        int amount = getLottoAmount(purchase);
        issueLotto(amount);
        outputView.outputLottoNumbers(LottoRepository.lotties());
    }

    private int getLottoAmount(int purchase) {
        return purchase / LOTTO_UNIT;
    }

    private void issueLotto(int amount) {
        for (int i = 0; i < amount; i++) {
            Lotto lotto = new Lotto(createLottoNumbers());
            LottoRepository.add(lotto);
        }
    }

    private List<Integer> createLottoNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }
}
