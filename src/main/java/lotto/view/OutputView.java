package lotto.view;

import lotto.domain.dto.output.LottoDto;
import lotto.domain.dto.output.LottosDto;
import lotto.io.Writer;

import java.util.List;

public class OutputView {
    private static final String QUANTITY_MSG = "\n%d개를 구매했습니다.";
    private final Writer writer;

    public OutputView(Writer writer) {
        this.writer = writer;
    }

    private static String getQuantity(LottosDto lottosDto) {
        return String.format(QUANTITY_MSG, lottosDto.quantity());
    }

    private static String getNumbers(LottoDto lottoDto) {
        return lottoDto.numbers()
                .toString();
    }

    public void printPurchasedLotto(LottosDto lottosDto) {
        writer.writeln(getQuantity(lottosDto));
        List<LottoDto> lottoTickets = lottosDto.lottoNumbers();
        for (LottoDto lottoTicket : lottoTickets) {
            writer.writeln(lottoTicket.numbers().toString());
        }
    }


}

