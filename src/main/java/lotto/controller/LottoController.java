package lotto.controller;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;
import lotto.util.LottoFactory;
import lotto.view.input.LottoBuyInputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {

    private final LottoBuyInputView lottoBuyInputView;

    public LottoController(LottoBuyInputView lottoBuyInputView) {
        this.lottoBuyInputView = lottoBuyInputView;
    }

    public Lottos buyLottos(){
        List<Lotto> lottos = new ArrayList<>();

        int amount = lottoBuyInputView.requestLottoPurchaseAmount();

        for (; amount > 0; amount -= 1000) {
            lottos.add(LottoFactory.getLotto());
        }

        return new Lottos(lottos);
    }
}
