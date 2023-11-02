package lotto.controller;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;
import lotto.util.LottoFactory;
import lotto.view.input.LottoBuyInputView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class LottoController {

    private final LottoBuyInputView lottoBuyInputView;

    public LottoController(LottoBuyInputView lottoBuyInputView) {
        this.lottoBuyInputView = lottoBuyInputView;
    }

    public Lottos buyLottos(){
        int amount = lottoBuyInputView.requestLottoPurchaseAmount();
        List<Lotto> lottos = createLottos(amount);

        return new Lottos(lottos);
    }

    private List<Lotto> createLottos(int amount) {
        return Stream.generate(LottoFactory::getLotto)
                .limit(amount / 1000)
                .toList();
    }
}
