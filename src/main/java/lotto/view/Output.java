package lotto.view;

import lotto.domain.LottoTickets;

public class Output {

    private static final String MONEY_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String BUY_COUNT_FORMAT = "%n%d개를 구매했습니다.%n";

    public void showMoneyInputMessage() {
        System.out.println(MONEY_INPUT_MESSAGE);
    }

    public void showLottoTickets(LottoTickets lottoTickets) {
        showBuyCount(lottoTickets);
        showLottoNumbers(lottoTickets);
    }

    private void showLottoNumbers(LottoTickets lottoTickets) {
        lottoTickets.getLottos().forEach(System.out::println);
    }

    private void showBuyCount(LottoTickets lottoTickets) {
        System.out.printf(BUY_COUNT_FORMAT, lottoTickets.getSize());
    }
}
