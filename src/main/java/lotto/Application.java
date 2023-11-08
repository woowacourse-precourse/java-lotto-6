package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Lotto> lottos;
        while (true) {
            try {
                String amountInput = LottoConsole.inputAmount();
                System.out.println();
                LottoStore lottoStore = new LottoStore();
                lottos = lottoStore.purchaseLottoTickets(amountInput);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        LottoConsole.printLottoListInfo(lottos);
        System.out.println();

        LottoRewardsCenter center;
        while (true) {
            try {
                String answerNumbers = LottoConsole.inputAnswerNumbers();
                System.out.println();
                String bonusNumber = LottoConsole.inputBonusNumber();
                System.out.println();

                LottoChecker checker = new LottoChecker(answerNumbers, bonusNumber);
                center = new LottoRewardsCenter(checker);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        List<LottoPrize> prizes = center.getPrizeResults(lottos);
        Double ROI = center.calculateROI(prizes);

        LottoConsole.printPrizeResults(prizes, ROI);
    }
}
