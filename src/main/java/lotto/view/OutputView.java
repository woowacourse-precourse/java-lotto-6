package lotto.view;

import java.util.Comparator;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import lotto.dto.output.LottoDto;
import lotto.dto.output.LottoTicketsDto;
import lotto.io.output.StdWriter;

public class OutputView {
    private static final String NEM_LINE = "\n";
    private final StdWriter writer;

    public OutputView(StdWriter writer) {
        this.writer = writer;
    }

    public void printLottoTickets(LottoTicketsDto lottoTicketsDto) {
        List<LottoDto> lottoTickets = lottoTicketsDto.lottoTickets();
        printLottoTicketsCount(lottoTickets);
        printLottoTicketsByNaturalOrder(lottoTickets);
    }

    private void printLottoTicketsCount(List<LottoDto> lottoTickets) {
        String message = String.format("%s%d개를 구매했습니다.", NEM_LINE, lottoTickets.size());
        writer.writeLine(message);
    }

    // ref. 오름차순 정렬
    // imp. View는 데이터를 렌더링하고 사용자에게 보여준다...
    //  StringBuilder가 있어도 괜찮은 걸까?
    private void printLottoTicketsByNaturalOrder(List<LottoDto> lottoTickets) {
        StringJoiner joiner = new StringJoiner(NEM_LINE);

        for (LottoDto lottoTicket : lottoTickets) {
            String lottoTicketFormat = lottoTicket.lottoNumbers()
                    .stream()
                    .sorted(Comparator.comparingInt(Integer::intValue))
                    .map(String::valueOf)
                    .collect(Collectors.joining(", ", "[", "]"));

            joiner.add(lottoTicketFormat);
        }

        writer.writeLine(joiner.toString());
    }
}
