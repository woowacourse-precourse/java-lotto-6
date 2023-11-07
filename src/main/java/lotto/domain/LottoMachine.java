package lotto.domain;

import java.util.ArrayList;

public class LottoMachine {
    private static final int LOTTO_TICKET_PRICE = 1000;

    public List<LottoTicket> issueTickets(int purchaseAmount) {
        int ticketCount = purchaseAmount / LOTTO_TICKET_PRICE;
        List<LottoTicket> tickets = new ArrayList<>();
        for(int i = 0; i < ticketCount; i++) {
            tickets.add(new LottoTicket(generateRandomNumbers()));
        }
        return tickets;
    }

    // 로또 번호 생성 로직 작성 필요
    private List<LottoNumber> generateRandomNumbers() {

    }
}