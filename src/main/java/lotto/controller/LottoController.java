package lotto.controller;

import lotto.model.Investor;
import lotto.model.Lotto;
import lotto.model.Money;
import lotto.model.Shop;
import lotto.model.dto.LottoResponse;
import lotto.view.input.InputView;
import lotto.view.output.OutputView;
import java.util.List;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        outputView.askInvestMoney();
        String moneyInput = inputView.readLine();
        Money investMoney = Money.from(moneyInput);
        Investor investor = Investor.createDefault(investMoney);
        Shop lottoShop = Shop.createDefault();
        List<Lotto> lottos = investor.buyLottosFromShop(lottoShop);
        outputView.printBoughtLottoSize(lottos.size());
        List<LottoResponse> lottoResponses = convertLottoResponses(lottos);
        outputView.printEachLottoNumbers(lottoResponses);
        outputView.askGoalNumbers();
        String goalNumbersInput = inputView.readLine();
        outputView.askBonusNumber();
        String bonusNumberInput = inputView.readLine();
        outputView.alertResult();
    }

    private List<LottoResponse> convertLottoResponses(final List<Lotto> lottos) {
        return lottos.stream()
                .map(lotto -> LottoResponse.from(lotto.getNumbers()))
                .toList();
    }
}
