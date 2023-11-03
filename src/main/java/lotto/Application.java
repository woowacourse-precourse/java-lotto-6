package lotto;

import lotto.constant.DisplayMessages;
import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // 클래스 생성, 메서드 분리, 리팩토링 필요
//        int paperCount;
//        LottoMachine lottoMachine = new LottoMachine();
//        int amount = lottoMachine.purchaseLotto();
//        WinningNumbers winningNumbers = new WinningNumbers();
//        LotteryChecker lotteryChecker = new LotteryChecker();
//        ProfitCalculator profitCalculator = new ProfitCalculator();
//
//        while (true) {
//            if (lottoMachine.calculateAmount(amount) != -1) {
//                paperCount = lottoMachine.calculateAmount(amount);
//                break;
//            }
//            amount = lottoMachine.purchaseLotto();
//        }
//
//        OutputView.purchaseCount(paperCount);
//
//        List<Lotto> lottoList = lottoMachine.buyLotto(paperCount);
//        for (Lotto lotto : lottoList) {
//            lotto.printLottoNumbers();
//        }
//        System.out.println();
//
//        List<Integer> winningNumber = winningNumbers.createWinningNumber();
//
//        System.out.println();
//
//        List<Integer> bonusNumber = winningNumbers.createBonusNumber();
//
//        lotteryChecker.prizeCheck(lottoList, winningNumber);
//
//        for (Lotto lotto : lottoList) {
//            int prize = lotto.getPrize();
//        }
//
//        List<Integer> integers = lotteryChecker.prizeCalculate(lottoList);
//
//        profitCalculator.calculate(integers);
//        int totalSum = profitCalculator.getTotalSum();
//        System.out.println("총 상금 : " + totalSum);
//
//        DisplayMessages.MATCH_COUNT.format();
//
//        double v = profitCalculator.earnRate(totalSum, amount);
//        System.out.println("총 수익률은 " + v + "%입니다.");
    }
}
