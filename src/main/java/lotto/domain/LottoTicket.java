package lotto.domain;

import lotto.Lotto;
import lotto.Utils;

import java.util.ArrayList;
import java.util.List;

public class LottoTicket {
    private static final int TICKET_PRICE = 1000;
    int ticketNumber;

    public LottoTicket(int input) {
        validateIsDivided(input);
        ticketNumber = input / TICKET_PRICE;
    }

    public List<Lotto> generateLottos() {
        List<Lotto> lottos = new ArrayList<>();
        for (int ticket = 0; ticket < ticketNumber; ticket++) {
            lottos.add(new Lotto(Utils.generateRandomLottoNumbers()));
        }
        return lottos;
    }
    public int getTicketNumber () {
        return ticketNumber;
    }

    private void validateIsDivided(int paid) {
        if (paid % TICKET_PRICE == 0) {
            return;
        }
        throw new IllegalArgumentException(String.format("잔돈이 남습니다. %d 원 단위로 입력해주세요. ", TICKET_PRICE));
    }
}
