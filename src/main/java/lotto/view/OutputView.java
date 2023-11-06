package lotto.view;

import lotto.domain.Lotto;
import lotto.service.LottoService;

import java.util.List;

public class OutputView {

    private static final String INPUT_PURCHASE_PRICE_SENTENCE = "구입금액을 입력해 주세요.";
    private static final String OUTPUT_PURCHASE_COUNT_SENTENCE = "개를 구매했습니다.";
    private static final String INPUT_WINNING_NUMBERS_SENTENCE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_SENTENCE = "보너스 번호를 입력해 주세요.";
    private static final String WINNING_STATISTICS = "당첨 통계" + "\n" + "---";

    InputView inputView = new InputView();
    LottoService lottoService = new LottoService();

    public void printInputPurchasePriceSentence() {
        System.out.println(INPUT_PURCHASE_PRICE_SENTENCE);
    }

    public void printPurchasePrice(int purchasePrice) {
        System.out.println(purchasePrice + "\n");
    }

    public void printIssuingLotteryTicket(List<Lotto> lottos, int lotteryTicketCount) {
        System.out.println(lotteryTicketCount + OUTPUT_PURCHASE_COUNT_SENTENCE);
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public void outputWinningNumbers() {

    }

    public void outputBonusNumber() {

    }

    public void outputResult() {

    }
}
