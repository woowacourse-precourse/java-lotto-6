package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Lotto;
import lotto.service.LottoService;
import lotto.service.ValidateService;
import lotto.view.GameView;

import java.util.ArrayList;
import java.util.List;

import static lotto.constant.Constant.*;

public class LottoGame {

    private ValidateService validateService;
    private LottoService lottoService;
    private GameView gameView;

    private int buyPrice;
    private List<Lotto> lotto = new ArrayList<>();

    public LottoGame() {
        this.validateService = new ValidateService();
        this.lottoService = new LottoService();
        this.gameView = new GameView();
    }

    public void start() {
        buyLottoInput();
        publishLotto();
    }

    private void buyLottoInput() {
        boolean correctInputFlag;
        do {
            try {
                String buyPriceInput = Console.readLine();
                buyPrice = validateService.validateBuyLottoInput(buyPriceInput);
                correctInputFlag = true;
            } catch (IllegalArgumentException e) {
                gameView.errorMessageView(e.getMessage());
                correctInputFlag = false;
            }
        } while (!correctInputFlag);
    }

    private void publishLotto() {
        int lottoCount = calculateLottoCount();
        lottoService.createLotto(lottoCount, lotto);
    }

    private int calculateLottoCount() {
        int lottoCount = buyPrice / LOTTO_PRICE_FOR_ONE;
        return lottoCount;
    }
}
