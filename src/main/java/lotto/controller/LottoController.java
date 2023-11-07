package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.Prize;
import lotto.domain.Result;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.HashMap;
import java.util.List;

public class LottoController {

    public void start(){

        //구매 수량 입력
        int lottoPurchaseAmount = getLottoPurchaseAmount();

        // 구입한 수량 만큼 로또 생성
        List<Lotto> lottoTickets = getLottoTickets(lottoPurchaseAmount);

        // 로또 당첨번호 입력
        List<Integer> lottoWinningNumbers = getLottoWinningNumbers();

        // 보너스 번호 입력
        int bonusNumber = getBonusNumber(lottoWinningNumbers);

        // 당첨통계 출력하기
        printResult(lottoTickets, lottoWinningNumbers, bonusNumber);

    }

    private static void printResult(List<Lotto> lottoTickets, List<Integer> lottoWinningNumbers, int bonusNumber) {
        OutputView.printLottoWinningStatisticsMessage();
        Result result = new Result();
        result.recordLottoResults(lottoTickets, lottoWinningNumbers, bonusNumber);
        HashMap<Prize, Integer> gameResult = result.getResult();
        OutputView.printLottoStatistics(gameResult);
        double profitRate = result.calculateProfitRate();
        OutputView.printLottoProfitRate(profitRate);
    }

    private static int getBonusNumber(List<Integer> lottoWinningNumbers) {
        OutputView.printLottoBonusNumberMessage();
        int bonusNumber = InputView.getValidBonusNumber(lottoWinningNumbers);
        return bonusNumber;
    }

    private static List<Integer> getLottoWinningNumbers() {
        OutputView.printLottoWinningNumberMessage();
        List<Integer> lottoWinningNumbers = InputView.getValidLottoWinningNumbers();
        return lottoWinningNumbers;
    }

    private static List<Lotto> getLottoTickets(int lottoPurchaseAmount) {
        List<Lotto> lottoTickets = LottoGenerator.buyLottoTickets(lottoPurchaseAmount);
        OutputView.printUserPurchase(lottoTickets);
        return lottoTickets;
    }

    private static int getLottoPurchaseAmount() {
        OutputView.printLottoPurchaseAmountMessage();
        int lottoPurchaseAmount = InputView.getValidLottoPurchaseAmount();
        return lottoPurchaseAmount;
    }
}
