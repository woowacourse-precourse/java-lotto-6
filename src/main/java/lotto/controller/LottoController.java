package lotto.controller;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;
import lotto.util.LottoFactory;
import lotto.view.input.LottoBuyInputView;

import java.util.List;
import java.util.stream.Stream;

public class LottoController {

    private static final int DENOMINATION = 1000;

    private final LottoBuyInputView lottoBuyInputView;

    public LottoController(LottoBuyInputView lottoBuyInputView) {
        this.lottoBuyInputView = lottoBuyInputView;
    }

    public Lottos buyLottos(){
        int amount = lottoBuyInputView.requestLottoPurchaseAmount();
        return new Lottos(createLottos(amount));
    }

    private List<Lotto> createLottos(int amount) {
        return Stream.generate(LottoFactory::getLotto)
                .limit(amount / DENOMINATION)
                .toList();
    }
}
