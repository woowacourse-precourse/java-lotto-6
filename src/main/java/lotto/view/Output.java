package lotto.view;

import lotto.dto.LottoDto;
import lotto.dto.LottoTicketsDto;

public class Output {
    private Output() {}

    public static void printLottoTickets(LottoTicketsDto lottoTicketsDto) {
        for (LottoDto lottoDto : lottoTicketsDto.getLottoTickets()) {
            System.out.println(lottoDto.getNumbers());
        }
        System.out.println();
    }
}
