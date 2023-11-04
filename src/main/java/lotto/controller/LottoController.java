package lotto.controller;

import lotto.model.BonusNumber;
import lotto.model.GoalNumbers;
import lotto.model.Lotto;
import lotto.model.LottoCompany;
import lotto.model.dto.LottoResponse;
import lotto.model.dto.PrizeResult;
import lotto.service.InvestorService;
import lotto.service.LottoCompanyService;
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
        InvestorService investorService = initInvestorService();
        List<Lotto> lottos = investorService.buyLottos();
        outputView.printBoughtLottoSize(lottos.size());
        printLottoValues(lottos);

        LottoCompanyService lottoCompanyService = initLottoCompanyService(lottos);
        List<PrizeResult> prizeResults = lottoCompanyService.evaluateLottos();
        addPrizeMoney(investorService, prizeResults);

        printPrizeResults(prizeResults);
        outputView.printProfitRate(investorService.calculateProfitRate());
    }

    private LottoCompanyService initLottoCompanyService(final List<Lotto> lottos) {
        GoalNumbers goalNumbers = initGoalNumbers();
        BonusNumber bonusNumber = initBonusNumber();
        LottoCompany lottoCompany = LottoCompany.of(goalNumbers, bonusNumber);

        return LottoCompanyService.of(lottoCompany, lottos);
    }

    private GoalNumbers initGoalNumbers() {
        outputView.askGoalNumbers();
        String goalNumbersInput = inputView.readLine();
        return GoalNumbers.from(goalNumbersInput);
    }

    private BonusNumber initBonusNumber() {
        outputView.askBonusNumber();
        String bonusNumberInput = inputView.readLine();
        return BonusNumber.from(bonusNumberInput);
    }

    private InvestorService initInvestorService() {
        outputView.askInvestMoney();
        String investorInput = inputView.readLine();

        return InvestorService.createDefault(investorInput);
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

    private void printPrizeResults(final List<PrizeResult> results) {
        for (PrizeResult result : results) {
            outputView.printEachPrize(result.condition(), result.prize(), result.size());
        }
    }

    private void addPrizeMoney(final InvestorService investorService, final List<PrizeResult> results) {
        for (PrizeResult result : results) {
            investorService.addProfit(result.prize() * result.size());
        }
    }
}
