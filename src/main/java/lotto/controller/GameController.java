package lotto.controller;

import java.util.List;
import lotto.domain.LottoService;
import lotto.domain.Lottos;
import lotto.controller.utils.InputParser;
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
        int purchaseAmount = getPurchaseAmount(view.inputLottoPurchaseAmount());
        model.savePurchaseCount(purchaseAmount);

        model.issueLottos(model.findPurchaseCount());
        printLottos(model.findPurchaseCount(), model.findAllLottos());

        List<Integer> numbers = getLottoNumbers(view.inputLottoNumbers());
        int bonusNumber = getLottoBonusNumber(view.inputLottoBonusNumber());
        model.saveWinningLotto(numbers, bonusNumber);

        model.createWinningResult(model.findAllLottos(), model.findWinningLotto());

    }

    private int getPurchaseAmount(String lottPurchaseAmount) {
        return inputParser.parseToInteger(lottPurchaseAmount);
    }

    private List<Integer> getLottoNumbers(String lottoNumbers) {
        return inputParser.parseLottoNumbers(lottoNumbers);
    }

    private int getLottoBonusNumber(String lottoBonusNumber) {
        return inputParser.parseToInteger(lottoBonusNumber);
    }

    private void printLottos(int lottoPurchaseCount, Lottos lottos) {
        view.printLottoCount(lottoPurchaseCount);
        lottos.getLottos()
                .forEach(lotto -> view.printLottoNumbers(lotto.getNumbers()));
    }

}
