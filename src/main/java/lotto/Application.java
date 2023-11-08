package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        String amountInput = LottoConsole.inputAmount();
        System.out.println();

        LottoStore lottoStore = new LottoStore();
        List<Lotto> lottos = lottoStore.purchaseLottoTickets(amountInput);

        LottoConsole.printLottoListInfo(lottos);
        System.out.println();

        String answerNumbers = LottoConsole.inputAnswerNumbers();
        System.out.println();
        String bonusNumber = LottoConsole.inputBonusNumber();
        System.out.println();

        LottoChecker checker = new LottoChecker(answerNumbers, bonusNumber);
        LottoRewardsCenter center = new LottoRewardsCenter(checker);

        List<LottoPrize> prizes = center.getPrizeResults(lottos);
        Double ROI = center.calculateROI(prizes);

        LottoConsole.printPrizeResults(prizes, ROI);
    }
}
