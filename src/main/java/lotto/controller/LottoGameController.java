package lotto.controller;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoGameController {
    private InputView inputView;
    private OutputView outputView;

    public LottoGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        // 구매 금액 입력
        PurchaseAmount purchaseAmount = initPurchaseAmount();
        int purchaseMoney = purchaseAmount.getPurchaseMoney();
        int ticketNumber = purchaseAmount.getTicketNumber();
        outputView.printBlankLine();
        outputView.printTicketNumber(ticketNumber);

        // 로또 매니저 생성
        LottoManager lottoManager = initLottoManager();
        lottoManager.generateLottos(ticketNumber);
        List<Lotto> lottos = lottoManager.getLottos();

        // 발행 로또 출력
        outputView.printLottos(lottos);

        // 당첨 금액 입력, 검증, 객체 생성
        WinningLotto winningLotto = initWinningLotto();

        // 로또 등수 계산
        LottoRankManager rankManager = initRankManager(winningLotto);
        rankManager.compareLottos(lottos);
        List<Integer> rankResult = rankManager.getRankResult();

        // 총 당첨금 계산
        LottoPrizeManager prizeManager = initPrizeManager();
        prizeManager.calculateTotalPrize(rankResult);
        long totalPrize = prizeManager.getTotalPrize();
        double rateOfReturn = prizeManager.getRateOfReturn(purchaseMoney);

        // 당첨 통계 출력
        outputView.printLottoResult(rankResult, rateOfReturn);
    }

    private PurchaseAmount initPurchaseAmount() {
        while (true) {
            try {
                outputView.printInputPurchaseMoney();
                return new PurchaseAmount(inputView.readPurchaseMoney());
            } catch (IllegalArgumentException e) {
                // 예외 메시지 출력
            }
        }
    }

    private WinningLotto initWinningLotto() {
        while (true) {
            try {
                List<Integer> winningNumbers = inputWinningNumbers();
                outputView.printBlankLine();
                int bonus = inputWinningBonus();
                outputView.printBlankLine();
                return new WinningLotto(winningNumbers, bonus);
            } catch (IllegalArgumentException e) {
                // output exception
            }
        }
    }

    private List<Integer> inputWinningNumbers() {
        while (true) {
            try {
                outputView.printInputWinningNumbers();
                return inputView.readWinningNumbers();
            } catch (IllegalArgumentException e) {
                // output exception
            }
        }
    }

    private int inputWinningBonus() {
        while (true) {
            try {
                outputView.printInputBonusNumber();
                return inputView.readBonusNumber();
            } catch (IllegalArgumentException e) {
                // output exception
            }
        }
    }

    private LottoManager initLottoManager() {
        LottoGenerator generator = new LottoGenerator();
        return new LottoManager(generator);
    }

    private LottoRankManager initRankManager(WinningLotto winningLotto) {
        LottoRankResult rankResult = new LottoRankResult();
        return new LottoRankManager(winningLotto, rankResult);
    }

    private LottoPrizeManager initPrizeManager() {
        LottoPrizeResult prizeResult = new LottoPrizeResult();
        return new LottoPrizeManager(prizeResult);
    }

}
