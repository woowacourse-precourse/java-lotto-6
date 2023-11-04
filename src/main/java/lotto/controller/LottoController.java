package lotto.controller;

import lotto.model.BonusNumber;
import lotto.model.GoalNumbers;
import lotto.model.Lotto;
import lotto.model.dto.LottoResponse;
import lotto.model.dto.PrizeResult;
import lotto.service.InvestorService;
import lotto.service.LottoCompanyService;
import lotto.view.output.OutputView;
import java.util.List;

public class LottoController {

    private final OutputView outputView;
    private final FactoryController factoryController;

    public LottoController(final OutputView outputView, final FactoryController factoryController) {
        this.outputView = outputView;
        this.factoryController = factoryController;
    }

    public void run() {
        InvestorService investorService = factoryController.createInvestorService();
        List<Lotto> lottos = investorService.buyLottos();
        outputView.printBoughtLottoSize(lottos.size());
        printLottoValues(lottos);

        LottoCompanyService lottoCompanyService = initLottoCompanyService(lottos);
        List<PrizeResult> prizeResults = lottoCompanyService.evaluateLottos();
        addPrizeMoney(investorService, prizeResults);

        outputView.alertResult();
        outputView.printEachPrize(prizeResults);
        outputView.printProfitRate(investorService.calculateProfitRate());
    }

    private LottoCompanyService initLottoCompanyService(final List<Lotto> lottos) {
        GoalNumbers goalNumbers = factoryController.createGoalNumbers();
        BonusNumber bonusNumber = factoryController.createBonusNumber();

        return LottoCompanyService.of(goalNumbers, bonusNumber, lottos);
    }

    private void printLottoValues(final List<Lotto> lottos) {
        List<LottoResponse> lottoResponses = convertLottoResponses(lottos);
        outputView.printEachLottoNumbers(lottoResponses);
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
