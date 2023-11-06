package lotto.controller;

import java.util.List;
import lotto.domain.LottoService;
import lotto.domain.Lottos;
import lotto.view.GameView;
import org.assertj.core.api.ListAssert;

public class GameController {

    private final LottoService model;
    private final GameView view;

    public GameController(LottoService model, GameView view){
        this.model = model;
        this.view = view;
    }

    public void run(){
        int lottoPurchaseAmount = getLottoPurchaseAmount(view.inputLottoPurchaseAmount());
        Lottos lottos = model.issueLottos(lottoPurchaseAmount);

    }

    private int getLottoPurchaseAmount(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해야 합니다.");
        }
    }
}
