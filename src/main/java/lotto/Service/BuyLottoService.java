package lotto.Service;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

import java.util.ArrayList;
import java.util.List;
import lotto.dto.LottoResults;
import lotto.model.Lotto;
import lotto.model.PurchasePrice;
import lotto.view.output.OutputView;

public class BuyLottoService {
    private OutputView outputView;

    public BuyLottoService(OutputView outputView) {
        this.outputView = outputView;
    }

    public LottoResults buyLotto(PurchasePrice purchasePrice) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < purchasePrice.getCount(); i++) {
            Lotto lotto = new Lotto(createLottoNumbers());
            outputView.printLottoNumber(lotto);
            lottos.add(lotto);
        }
        outputView.printLottoCount(lottos.size());
        return new LottoResults(lottos);
    }

    private List<Integer> createLottoNumbers() {
        return pickUniqueNumbersInRange(1, 45, 6);
    }
}
