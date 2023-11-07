package lotto.controller;

import java.util.List;
import lotto.domain.PurchaseCount;
import lotto.domain.LottoService;
import lotto.domain.Lottos;
import lotto.domain.WinningLotto;
import lotto.utils.InputParser;
import lotto.view.GameView;

public class GameController {

    private final LottoService model;
    private final GameView view;
    private final InputParser inputParser = new InputParser();

    public GameController(LottoService model, GameView view){
        this.model = model;
        this.view = view;
    }

    public void run(){
        PurchaseCount purchaseCount = new PurchaseCount(view.inputLottoPurchaseAmount());
        model.issueLottos(purchaseCount.getValue());
        printLottos(purchaseCount.getValue(), model.findAllLottos());

        List<Integer> numbers = getLottoNumbers(view.inputLottoNumbers());
        int bonusNumber = getLottoBonusNumber(view.inputLottoBonusNumber());
        WinningLotto winningLotto = new WinningLotto(numbers, bonusNumber);
        System.out.println(winningLotto.getNumbers());
        System.out.println( winningLotto.getBonusNumber());
    }

    private List<Integer> getLottoNumbers(String lottoNumbers) {
        return inputParser.parseLottoNumbers(lottoNumbers);
    }

    private int getLottoBonusNumber(String lottoBonusNumber) {
        return inputParser.parseLottoBonusNumber(lottoBonusNumber);
    }

    private void printLottos(int lottoPurchaseCount, Lottos lottos) {
        view.printLottoCount(lottoPurchaseCount);
        lottos.getLottos()
                .forEach(lotto -> view.printLottoNumbers(lotto.getNumbers()));
    }

}
