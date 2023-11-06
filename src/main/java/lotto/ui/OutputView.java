package lotto.ui;

import java.text.DecimalFormat;
import java.util.Arrays;
import lotto.domain.LottoTicket;
import lotto.dto.WinningResult;
import lotto.enums.Prize;

public class OutputView {
    public void printError(String errorMessage) {
        System.out.println(errorMessage);
    }

    public void printLottoTicket(LottoTicket lottoTicket) {
        System.out.printf("%d개를 구매했습니다.%n", lottoTicket.count());
        lottoTicket.lottoTicket().forEach(System.out::println);
        System.out.println();
    }
}
