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
        // 구매 계좌 입력, 검증, 객체 생성
        PurchaseAmount purchaseAmount = initPlayerAmount();
        int ticketNumber = purchaseAmount.getTicketNumber();

        // 로또 매니저 생성
        LottoManager lottoManager = new LottoManager(new LottoGenerator());
        lottoManager.generateLottos(ticketNumber);

        // 발행 로또 출력
        //

        // 당첨 금액 입력, 검증, 객체 생성
        WinningLotto winningLotto = initWinningLotto();

        // 로또 비교기 객체 생성
        LottoRankManager rankManager = new LottoRankManager(winningLotto, new LottoRankResult());
        rankManager.compareLottos(lottoManager.getLottos());
        List<Integer> rankResult = rankManager.getRankResult();

        // 당첨금 계산기 객체 생성
        LottoPrizeManager prizeManager = new LottoPrizeManager(new LottoPrizeResult());
        prizeManager.calculateTotalPrize(rankResult);
        long totalPrize = prizeManager.getTotalPrize();
        int purchaseMoney = purchaseAmount.getPurchaseMoney();
        double rateOfReturn = prizeManager.getRateOfReturn(purchaseMoney);

        // 당첨 통계 출력

    }

    private PurchaseAmount initPlayerAmount() {
        PurchaseAmount purchaseAmount = null;
        do {
            try {
                //output
                int purchaseMoney = inputView.readPurchaseMoney();
                purchaseAmount = new PurchaseAmount(purchaseMoney);
            } catch (IllegalArgumentException e) {
                // 예외 메시지 출력
            }
        } while (purchaseAmount == null);
        return purchaseAmount;
    }

    private WinningLotto initWinningLotto() {
        WinningLotto winningLotto = null;
        do {
            try {
                List<Integer> winningNumbers = getWinningNumbers();
                int winningBonus = getWinningBonus(winningNumbers);
                winningLotto = new WinningLotto(winningNumbers, winningBonus);
            } catch (IllegalArgumentException e) {
                // output exception
            }
        } while (winningLotto == null);
        return winningLotto;
    }

    private List<Integer> getWinningNumbers() {
        List<Integer> winningNumbers = null;
        do {
            try {
                // 출력
                winningNumbers = inputView.readWinningNumbers();
            } catch (IllegalArgumentException e) {
                // 예외 메시지 출력
            }
        } while (winningNumbers == null);
        return winningNumbers;
    }

    private int getWinningBonus(List<Integer> winningNumbers) {
        int bonus = -1;
        do {
            try {
                //output
                bonus = inputView.readBonusNumber();
            } catch (IllegalArgumentException e) {
                //output
            }
        } while (bonus == -1);
        return bonus;
    }

}
