package lotto.controller;

import lotto.model.GoalNumbers;
import lotto.model.Investor;
import lotto.model.Lotto;
import lotto.model.LottoCompany;
import lotto.model.LottoNumber;
import lotto.model.Shop;
import lotto.model.dto.LottoResponse;
import lotto.model.dto.PrizeResult;
import lotto.view.input.InputView;
import lotto.view.output.OutputView;
import java.util.List;
import java.util.function.Supplier;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Investor investor = initInvestor();
        Shop shop = Shop.withOrderedMoney(investor.getInvestMoney());
        List<Lotto> lottos = shop.createLottos();

        outputView.printBoughtLottoSize(lottos.size());
        printLottoValues(lottos);

        LottoCompany lottoCompany = initLottoCompany();
        List<PrizeResult> prizeResults = lottoCompany.evaluateLottos(lottos);
        addPrizeMoney(investor, prizeResults);

        outputView.alertResult();
        outputView.printEachPrize(prizeResults);
        outputView.printProfitRate(investor.calculateProfitRate());
    }

    private Investor initInvestor() {
        return createInstance(Investor.class, () -> {
            outputView.askInvestMoney();
            String investMoneyInput = inputView.readLine();
            return Investor.createDefault(investMoneyInput);
        });
    }

    private void printLottoValues(final List<Lotto> lottos) {
        List<LottoResponse> lottoResponses = lottos.stream()
                .map(lotto -> LottoResponse.from(lotto.getNumbers()))
                .toList();

        outputView.printEachLottoNumbers(lottoResponses);
    }

    public LottoCompany initLottoCompany() {
        GoalNumbers goalNumbers = initGoalNumbers();

        return createInstance(LottoCompany.class, () -> {
            LottoNumber bonusNumber = initBonusNumber();
            return LottoCompany.of(goalNumbers, bonusNumber);
        });
    }

    private GoalNumbers initGoalNumbers() {
        return createInstance(GoalNumbers.class, () -> {
            outputView.askGoalNumbers();
            String goalNumbersInput = inputView.readLine();
            return GoalNumbers.from(goalNumbersInput);
        });
    }

    private LottoNumber initBonusNumber() {
        return createInstance(LottoNumber.class, () -> {
            outputView.askBonusNumber();
            String bonusNumberInput = inputView.readLine();
            return LottoNumber.from(bonusNumberInput);
        });
    }

    private <T> T createInstance(final Class<T> classType, final Supplier<T> creator) {
        T created = null;
        while (created == null) {
            created = tryGetInstance(creator, created);
        }
        return created;
    }

    private <T> T tryGetInstance(final Supplier<T> creator, T created) {
        try {
            created = creator.get();
        } catch (IllegalArgumentException exception) {
            outputView.printExceptionMessage(exception.getMessage());
        }
        return created;
    }

    private void addPrizeMoney(final Investor investor, final List<PrizeResult> results) {
        for (PrizeResult result : results) {
            investor.addProfitMoney(result.prize() * result.size());
        }
    }
}
