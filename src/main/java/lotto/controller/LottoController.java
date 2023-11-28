package lotto.controller;

import java.util.List;
import lotto.model.BonusNumber;
import lotto.model.LottoNumbers;
import lotto.model.PurchasePrice;
import lotto.model.Statistics;
import lotto.model.WinnerNumber;
import lotto.service.BuyLottoService;
import lotto.service.CalculateStatisticService;
import lotto.view.input.InputView;
import lotto.view.output.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final BuyLottoService buyLottoService;
    private final CalculateStatisticService calculateStatisticService;

    public LottoController(InputView inputView, OutputView outputView, BuyLottoService buyLottoService,
                           CalculateStatisticService calculateStatisticService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.buyLottoService = buyLottoService;
        this.calculateStatisticService = calculateStatisticService;
    }

    public void run() {
        PurchasePrice purchasePrice = createPurchasePrice(); // 구입 금액 입력

        LottoNumbers lottoNumbers = buyLottoService.buyLotto(purchasePrice); // 로또 구입

        WinnerNumber winnerNumber = createWinnerNumber(); // 당첨 번호 입력

        BonusNumber bonusNumber = createBonusNumber(winnerNumber); // 보너스 번호 입력

        // 당첨, 보너스 번호 & 로또 번호 비교
        Statistics statistics = Statistics.createStatistics();
        statistics.calculateMatching(lottoNumbers, winnerNumber, bonusNumber);

        outputView.printStatistic(statistics.getResult());

        long totalPrize = calculateStatisticService.calculatePrizeMoney(statistics.getResult());// 상금 계산
        outputView.printEarningRate(totalPrize, purchasePrice);
    }

    private BonusNumber createBonusNumber(WinnerNumber winnerNumber) {
        while (true) {
            try {
                outputView.printBonusNumberMessage();
                int bonus = inputView.inputBonusNumber();
                return BonusNumber.createBonusNumber(winnerNumber.getWinnerNumbers(), bonus);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private WinnerNumber createWinnerNumber() {
        while (true) {
            try {
                outputView.printWinnerNumberMessage();
                List<Integer> winners = inputView.inputWinnerNumber();
                return WinnerNumber.createWinnerNumber(winners);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private PurchasePrice createPurchasePrice() {
        while (true) {
            try {
                outputView.printPurchasePriceMessage();
                int price = inputView.readPrice();
                PurchasePrice purchasePrice = PurchasePrice.createPurchasePrice(price);
                return purchasePrice;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
