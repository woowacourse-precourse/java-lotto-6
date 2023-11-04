package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoTicket;

import java.util.List;
import java.util.stream.IntStream;

import static java.text.MessageFormat.format;

public class OutputView {
    private static final String ERROR_MESSAGE_FORMAT = "[ERROR] {0}";
    private static final String PRINT_LOTTO_SIZE_FORMAT = "\n{0}개를 구매했습니다.";
    private static final int ZERO = 0;

    public void printErrorMessage(String errorMessage) {
        System.out.println(format(ERROR_MESSAGE_FORMAT, errorMessage));
    }

    public void printLottoTicket(LottoTicket lottoTicket) {
        List<Lotto> lottoTicketNumber = lottoTicket.getLottoTicket();
        System.out.println(format(PRINT_LOTTO_SIZE_FORMAT, lottoTicketNumber.size()));
        IntStream.range(ZERO, lottoTicketNumber.size())
                .forEach(i -> System.out.println(lottoTicketNumber.get(i)));
    }
}
