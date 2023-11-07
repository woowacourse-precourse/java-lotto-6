package lotto.controller.subcontroller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.PurchaseAmount;
import lotto.domain.repository.LottoRepository;
import lotto.domain.repository.PurchaseAmountRepository;
import lotto.view.InputView;
import lotto.view.OutputView;

public class IssueLottoController implements Controllable {
    private final InputView inputView;
    private final OutputView outputView;

    public IssueLottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    @Override
    public void process() {
        PurchaseAmount purchaseAmount = inputPurchaseAmount();
        PurchaseAmountRepository.add(purchaseAmount);

        int count = purchaseAmount.calculateLottoCount();
        issueLotto(count);

        outputView.outputLottoNumbers(LottoRepository.lotties());
    }

    private PurchaseAmount inputPurchaseAmount() {
        try {
            int amount = inputView.inputPurchaseAmount();
            return new PurchaseAmount(amount);
        } catch (IllegalArgumentException exception) {
            outputView.printExceptionMessage(exception);
            return inputPurchaseAmount();
        }
    }

    private void issueLotto(int amount) {
        for (int i = 0; i < amount; i++) {
            Lotto lotto = new Lotto(createLottoNumbers());
            LottoRepository.add(lotto);
        }
    }

    private List<Integer> createLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
