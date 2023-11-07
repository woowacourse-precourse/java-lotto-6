package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.utils.LottoUtils;
import lotto.validation.Validation;
import lotto.view.OutputView;

public class Buyer {
    private final List<Lotto> lottos;

    public Buyer(Long prise) {
        this.lottos = generateLottos(LottoUtils.getLottoAmount(prise));
        OutputView.buyAmount(lottos.size());
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    private List<Lotto> generateLottos(final long amount) {
        List<Lotto> autoGenerateLottos = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            autoGenerateLottos.add(new Lotto(LottoUtils.generateRandomLottoNumbers()));
        }
        return autoGenerateLottos;
    }

    public void showLottos() {
        for (Lotto lotto : lottos) {
            lotto.showNumbers();
        }
    }
}
