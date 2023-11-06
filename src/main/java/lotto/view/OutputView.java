package lotto.view;

import lotto.service.LottoService;

public class OutputView {

    private static final String INPUT_PURCHASE_PRICE_SENTENCE = "구입금액을 입력해 주세요.";
    private static final String OUTPUT_PURCHASE_COUNT_SENTENCE = "개를 구매했습니다.";
    private static final String INPUT_WINNING_NUMBERS_SENTENCE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_SENTENCE = "보너스 번호를 입력해 주세요.";
    private static final String WINNING_STATISTICS = "당첨 통계" + "\n" + "---";

    InputView inputView = new InputView();
    LottoService lottoService = new LottoService();

    public void outputPurchasePrice() {
        System.out.println(INPUT_PURCHASE_PRICE_SENTENCE);
        System.out.println(inputView.inputPurchasePrice());
        System.out.println();
    }

    public void outputIssuingLotteryTicket() {
        int lotteryTicketCount = lottoService.getLotteryTicketCount();
        System.out.println(lotteryTicketCount + OUTPUT_PURCHASE_COUNT_SENTENCE);
    }

    public void outputWinningNumbers() {

    }

    public void outputBonusNumber() {

    }

    public void outputResult() {

    }
}
