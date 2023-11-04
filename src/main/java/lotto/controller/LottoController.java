package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoIssuer;
import lotto.view.InputView;

public class LottoController {

    private LottoIssuer lottoIssuer = new LottoIssuer();

    public void play() {
        getLottos();
        // TODO - 이후 기능 구현
    }

    private List<Lotto> getLottos() {
        try {
            return lottoIssuer.buy(InputView.getPrice());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getLottos();
        }
    }


}
