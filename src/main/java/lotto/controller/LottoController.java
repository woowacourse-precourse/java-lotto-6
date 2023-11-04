package lotto.controller;

import lotto.model.BonusNumber;
import lotto.model.GoalNumbers;
import lotto.model.Lotto;
import lotto.model.dto.LottoResponse;
import lotto.model.dto.PrizeResult;
import lotto.service.InvestorService;
import lotto.service.LottoCompanyService;
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
        InvestorService investorService = createInvestorService();
        List<Lotto> lottos = investorService.buyLottos();
        outputView.printBoughtLottoSize(lottos.size());
        printLottoValues(lottos);

        LottoCompanyService lottoCompanyService = createLottoCompanyService(lottos);
        List<PrizeResult> prizeResults = lottoCompanyService.evaluateLottos();
        addPrizeMoney(investorService, prizeResults);

        outputView.alertResult();
        outputView.printEachPrize(prizeResults);
        outputView.printProfitRate(investorService.calculateProfitRate());
    }

    public InvestorService createInvestorService() {
        return createInstance(InvestorService.class, () -> {
            outputView.askInvestMoney();
            String investorInput = inputView.readLine();
            return InvestorService.createDefault(investorInput);
        });
    }

    private void printLottoValues(final List<Lotto> lottos) {
        List<LottoResponse> lottoResponses = convertLottoResponses(lottos);
        outputView.printEachLottoNumbers(lottoResponses);
    }

    public LottoCompanyService createLottoCompanyService(final List<Lotto> lottos) {
        return createInstance(LottoCompanyService.class, () -> {
            GoalNumbers goalNumbers = createGoalNumbers();
            BonusNumber bonusNumber = createBonusNumber();

            return LottoCompanyService.of(goalNumbers, bonusNumber, lottos);
        });
    }

    private GoalNumbers createGoalNumbers() {
        return createInstance(GoalNumbers.class, () -> {
            outputView.askGoalNumbers();
            String goalNumbersInput = inputView.readLine();
            return GoalNumbers.from(goalNumbersInput);
        });
    }

    private BonusNumber createBonusNumber() {
        return createInstance(BonusNumber.class, () -> {
            outputView.askBonusNumber();
            String bonusNumberInput = inputView.readLine();
            return BonusNumber.from(bonusNumberInput);
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

    private List<LottoResponse> convertLottoResponses(final List<Lotto> lottos) {
        return lottos.stream()
                .map(lotto -> LottoResponse.from(lotto.getNumbers()))
                .toList();
    }

    private void addPrizeMoney(final InvestorService investorService, final List<PrizeResult> results) {
        for (PrizeResult result : results) {
            investorService.addProfit(result.prize() * result.size());
        }
    }
}
