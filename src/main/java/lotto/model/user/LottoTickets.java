package lotto.model.user;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.lotto.BonusNumber;
import lotto.model.lotto.Lotto;
import lotto.model.lotto.WinningNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LottoTickets {
    private List<Lotto> tickets = new ArrayList<>();

    public LottoTickets(int amount) {
        for(int i=0; i<amount; i++){
            Lotto lottoTicket = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            tickets.add(lottoTicket);
        }
    }

    public LottoTickets(List<Lotto> lotto){
        this.tickets = lotto;
    }

    public LottoResults calculateResult(WinningNumber winningNumber, BonusNumber bonusNumber){
        int firstPlace = 0;
        int secondPlace = 0;
        int thirdPlace = 0;
        int forthPlace = 0;
        int fifthPlace = 0;

        for(int i=0; i<tickets.size(); i++){
            int hit = tickets.get(i).countSameNumber(winningNumber);
            if(hit == 3) fifthPlace++;
            if(hit == 4) forthPlace++;

            if((hit == 5) && (tickets.get(i).isHitBonusNumber(bonusNumber))) {
                secondPlace++; continue;
            }

            if(hit == 5) thirdPlace++;
            if(hit == 6) firstPlace++;
        }
        return new LottoResults(firstPlace, secondPlace, thirdPlace, forthPlace, fifthPlace);
    }

    public String printTickets(){
        StringBuilder ticketContents = new StringBuilder();

        for (Lotto ticket : tickets) {
            ticketContents.append(ticket.getTicketContent()).append("\n");
        }

        return ticketContents.toString();
    }

    @Override
    public boolean equals(Object obj) {
        LottoTickets input = (LottoTickets) obj;
        return IntStream.range(0, input.tickets.size()).allMatch(i -> tickets.get(i).equals(input.tickets.get(i)));
    }
}
