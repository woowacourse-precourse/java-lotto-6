package lotto.controller;

import lotto.domain.LottoService;
import lotto.domain.Lottos;
import lotto.view.GameView;

public class GameController {

    private final LottoService model;
    private final GameView view;

    public GameController(LottoService model, GameView view){
        this.model = model;
        this.view = view;
    }

    public void run(){
        int lottoPurchaseCount = getLottoPurchaseCount(view.inputLottoPurchaseAmount());
        model.issueLottos(lottoPurchaseCount);
        printLottos(lottoPurchaseCount, model.findAllLottos());
    }

    private int getLottoPurchaseCount(String input) {
        try {
            return Integer.parseInt(input)/1000;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해야 합니다.");
        }
    }

    private void printLottos(int lottoPurchaseCount, Lottos lottos) {
        view.printLottoCount(lottoPurchaseCount);
        lottos.getLottos()
                .forEach(lotto -> view.printLottoNumbers(lotto.getNumbers()));
    }

}
