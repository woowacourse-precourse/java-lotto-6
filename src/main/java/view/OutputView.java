package view;

import java.util.List;

import lotto.LottoMoney;

public class OutputView {
    private static final String LINEBREAK = "\n";
    private static final String LOTTO_TICKET_MESSAGE = "개를 구매했습니다.";
    private static final String LUCKEY_WINNING_STATSICS_MESSAGE = "당첨 통계";
    private static final String STICK = "-";

    public void printLottoTicketMessage(LottoMoney lottoMoney) {
        System.out.println(LINEBREAK + lottoMoney.getLottoTicket() + LOTTO_TICKET_MESSAGE);
    }

    public void printLottoNumber(List<Integer> numbers) {
        System.out.println(numbers);
    }

    public void printLottoResultMessage() {
        System.out.println(LINEBREAK + LUCKEY_WINNING_STATSICS_MESSAGE + LINEBREAK + STICK.repeat(3));
    }
}
