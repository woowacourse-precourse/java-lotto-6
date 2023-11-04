package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.utils.LottoUtils;
import lotto.validation.Validation;
import lotto.view.OutputView;

public class Buyer {
    private final List<Lotto> lottos;

    public Buyer(String prise) {
        validation(prise);
        this.lottos = generateLottos(LottoUtils.getLottoAmout(prise));
        OutputView.buyAmount(lottos.size());
    }

    private void validation(String prise) {
        Validation.checkIsNumber(prise);
        Validation.checkIsNatural(Integer.parseInt(prise));
        Validation.checkIsDivideByThousand(prise);
    }

    private List<Lotto> generateLottos(final long amout) {
        List<Lotto> autoGenerateLottos = new ArrayList<>();
        for (int i = 0; i < amout; i++) {
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
