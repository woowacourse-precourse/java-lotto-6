package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.view.LottoView;

public class LottoController {
    private List<Lotto> lottos;
    private LottoView lottoView;

    public LottoController(LottoView lottoView) {
        this.lottoView = lottoView;
        this.lottos = buyingLotto();
    }

    private List<Lotto> buyingLotto() {
        boolean successInput = false;
        List<Lotto> lottos = null;
        while (!successInput) {
            try {
                lottos = lottoGenerating(lottoView.paymentInput());
                successInput = true;
            } catch (IllegalArgumentException e) {
                lottoView.print(e.getMessage());
            }
            lottoView.print("");
        }
        return lottos;
    }

    private List<Lotto> lottoGenerating(String payment) {
        return new LottoGenerator(Integer.parseInt(payment)).getLottos();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
