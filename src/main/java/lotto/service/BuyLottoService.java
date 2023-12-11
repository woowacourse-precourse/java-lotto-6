package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoNumbers;
import lotto.model.PurchasePrice;
import lotto.view.output.OutputView;

public class BuyLottoService {
    private final OutputView outputView;

    public BuyLottoService(OutputView outputView) {
        this.outputView = outputView;
    }

    public LottoNumbers buyLotto(PurchasePrice purchasePrice) {
        int lottoCount = purchasePrice.calculateLottoCount();
        List<Lotto> lotto = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lotto.add(Lotto.createLotto());
        }
        LottoNumbers lottoNumbers = LottoNumbers.createLottoNumbers(lotto);
        outputView.printLottoCount(lottoCount, lottoNumbers);
        return lottoNumbers;
    }
}
