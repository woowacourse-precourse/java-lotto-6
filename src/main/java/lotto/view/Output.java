package lotto.view;

import lotto.domain.LottoTickets;

public class Output {

    private static final String LINE_BREAK = "\n";
    private static final String MONEY_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String BUY_COUNT_FORMAT = "%d개를 구매했습니다.";
    private static final String WINNING_NUMBERS_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";

    public void showMoneyInputMessage() {
        System.out.println(MONEY_INPUT_MESSAGE);
    }

    public void showLottoTickets(LottoTickets lottoTickets) {
        showBuyCount(lottoTickets);
        showLottoNumbers(lottoTickets);
    }

    private void showLottoNumbers(LottoTickets lottoTickets) {
        lineBreak();
        lottoTickets.getLottos().forEach(System.out::println);
    }

    private void showBuyCount(LottoTickets lottoTickets) {
        lineBreak();
        System.out.printf(BUY_COUNT_FORMAT, lottoTickets.getSize());
    }

    public void showWinningNumbersInputMessage() {
        lineBreak();
        System.out.println(WINNING_NUMBERS_INPUT_MESSAGE);
    }

    private void lineBreak() {
        System.out.print(LINE_BREAK);
    }
}
