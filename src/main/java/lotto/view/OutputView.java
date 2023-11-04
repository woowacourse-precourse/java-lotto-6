package lotto.view;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import lotto.dto.LottoNumberDto;
import lotto.dto.output.LottoDto;
import lotto.dto.output.LottosDto;
import lotto.io.output.StdWriter;

public class OutputView {
    private static final String NEM_LINE = "\n";
    private final StdWriter writer;

    public OutputView(StdWriter writer) {
        this.writer = writer;
    }

    public void printLottoTickets(LottosDto lottosDto) {
        List<LottoDto> lottoTickets = lottosDto.lottos();
        printLottoTicketsCount(lottoTickets);
        printLottoTicketsByNaturalOrder(lottoTickets);
    }

    private void printLottoTicketsCount(List<LottoDto> lottoTickets) {
        String message = String.format("%s%d개를 구매했습니다.", NEM_LINE, lottoTickets.size());
        writer.writeLine(message);
    }

    // fix
    // ref. 오름차순 정렬
    // imp. View는 데이터를 렌더링하고 사용자에게 보여준다...
    //  StringBuilder가 있어도 괜찮은 걸까?
    private void printLottoTicketsByNaturalOrder(List<LottoDto> lottoTickets) {
        for (LottoDto lotto : lottoTickets) {
            List<LottoNumberDto> lottoNumbers = lotto.lottoNumbers();
            String lottoTicketFormat = lottoNumbers.stream()
                    .sorted((Comparator.comparingInt(LottoNumberDto::number)))
                    .map(lottoNumber -> String.valueOf(lottoNumber.number()))
                    .collect(Collectors.joining(", ", "[", "]"));

            writer.writeLine(lottoTicketFormat);
        }
        writer.write(NEM_LINE);
    }
}
