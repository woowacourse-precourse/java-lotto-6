package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Lotto> lottos;
        while (true) {
            try {
                String amountInput = LottoConsole.inputAmount();
                LottoStore lottoStore = new LottoStore();
                lottos = lottoStore.purchaseLottoTickets(amountInput);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        LottoConsole.printLottoListInfo(lottos);

        LottoChecker checker = new LottoChecker();
        while (true) {
            try {
                String answerNumbers = LottoConsole.inputAnswerNumbers();
                checker.setAnswerNumber(answerNumbers);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        while (true) {
            try {
                String bonusNumber = LottoConsole.inputBonusNumber();
                checker.setBonusNumber(bonusNumber);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        LottoRewardsCenter center = new LottoRewardsCenter(checker);
        List<LottoPrize> prizes = center.getPrizeResults(lottos);
        Double ROI = center.calculateROI(prizes);

        LottoConsole.printPrizeResults(prizes, ROI);
    }
}
