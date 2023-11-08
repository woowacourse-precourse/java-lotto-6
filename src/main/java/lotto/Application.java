package lotto;

import static lotto.views.UserInput.readBonusNumber;
import static lotto.views.UserInput.readPurchasePrice;
import static lotto.views.UserInput.readWinningNumber;
import static lotto.views.UserOutput.askBonusNumber;
import static lotto.views.UserOutput.askPurchasePrice;
import static lotto.views.UserOutput.askWinningNumber;
import static lotto.views.UserOutput.printNumberOfLottoPurchases;
import static lotto.views.UserOutput.printPurchaseLottoInfo;
import static lotto.views.UserOutput.printWinningStatistics;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoAgency;
import lotto.domain.LottoRank;
import lotto.domain.LottoStore;

public class Application {
    private static final LottoStore lottoStore = new LottoStore();
    private static final LottoAgency lottoAgency = new LottoAgency();

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        askPurchasePrice();
        Integer purchasePrice = readPurchasePrice();
        System.out.println();

        List<Lotto> lottos = lottoStore.purchaseLotto(purchasePrice);
        printNumberOfLottoPurchases(lottos);
        printPurchaseLottoInfo(lottos);
        System.out.println();

        askWinningNumber();
        List<Integer> winningNumbers = readWinningNumber();
        System.out.println();

        askBonusNumber();
        Integer bonusNumber = readBonusNumber(winningNumbers);
        System.out.println();

        Map<LottoRank, Integer> winningResult = lottoAgency.calculateLottoRank(lottos, winningNumbers, bonusNumber);

        Long totalWinningAmount = lottoAgency.calculateTotalWinningAmount(winningResult);

        Double totalReturnRate = lottoAgency.calculateTotalReturnRate(totalWinningAmount, purchasePrice);

        printWinningStatistics(winningResult, totalReturnRate);
    }
}
