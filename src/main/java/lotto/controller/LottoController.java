package lotto.controller;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoGenerator;
import lotto.view.LottoView;

public class LottoController {
    private List<Lotto> lottos;
    private LottoView lottoView;

    public LottoController(LottoView lottoView) {
        this.lottoView = lottoView;
        this.lottos = lottoGenerating();
    }

    private List<Lotto> lottoGenerating() {
        List<Lotto> lottos = null;
        while (lottos == null) {
            lottos = createLotto(lottos);
            lottoView.print("");
        }
        return lottos;
    }

    private List<Lotto> createLotto(List<Lotto> lottos) {
        try {
            lottos = createLottoComplete(lottoView.paymentInput());
        } catch (IllegalArgumentException e) {
            lottoView.print(e.getMessage());
        }
        return lottos;
    }

    private List<Lotto> createLottoComplete(String payment) {
        return new LottoGenerator(Integer.parseInt(payment)).getLottos();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
