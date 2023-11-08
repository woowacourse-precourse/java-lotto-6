package lotto.controller;


import lotto.mapper.LottoMatchResultMapper;
import lotto.mapper.LottoNumberMapper;
import lotto.model.*;
import lotto.view.InputView;
import lotto.view.OutputView;
import java.util.Map;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    private int purchaseAmount;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Lottos purchasedLottos = purchaseLotto();
        displayLottos(purchasedLottos);

        LotteryNumbers lotteryNumbers = getLotteryNumbers();

        Map<WinningCriteria, Integer> lottoResult = calculateLottoResult(purchasedLottos, lotteryNumbers);
        displayLottoResult(lottoResult);

        double profitRate = calculateProfitRate(lottoResult, this.purchaseAmount);
        outputView.displayProfitRate(profitRate);

    }

    private Lottos purchaseLotto() {
        this.purchaseAmount = inputView.readPurchaseAmount();

        try {
            Purchase purchase = new Purchase(purchaseAmount);
            return purchase.getPurchasedLottos();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return purchaseLotto();
        }
    }

    private LotteryNumbers getLotteryNumbers() {
        Lotto winningNumbers = getWinningNumbers();

        while (true) {
            try {
                BonusNumber bonusNumber = getBonusNumber();
                return new LotteryNumbers(winningNumbers, bonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Lotto getWinningNumbers() {
        try {
            return new Lotto(inputView.readWinnerNumbers());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getWinningNumbers();
        }
    }

    private BonusNumber getBonusNumber() {
        try {
            return new BonusNumber(inputView.readBonusNumber());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getBonusNumber();
        }
    }

    private Map<WinningCriteria, Integer> calculateLottoResult(Lottos purchasedLottos, LotteryNumbers lotteryNumbers) {
        return new LottoResult(purchasedLottos, lotteryNumbers).getNumberMatchResult();
    }

    private double calculateProfitRate(Map<WinningCriteria, Integer> lottoResult, int purchaseAmount) {
        return new ProfitRate(lottoResult, purchaseAmount).getProfitRate();
    }

    public void displayLottos(Lottos lottos) {
        outputView.displayLottos(LottoNumberMapper.mapToDtos(lottos));
    }

    public void displayLottoResult(Map<WinningCriteria, Integer> lottoResult) {
        outputView.displayLottoResult(LottoMatchResultMapper.mapToDtos(lottoResult));
    }
}
