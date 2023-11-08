package lotto.model.lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.user.LottoResults;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static lotto.model.constants.IntegerConstants.*;
import static lotto.model.constants.StringConstants.NEW_LINE;

public class LottoTickets {
    private List<Lotto> tickets = new ArrayList<>();

    public LottoTickets(int amount) {
        IntStream.range(ZERO.get(), amount)
                .forEach(i -> tickets.add(makeRandomLottoTicket()));
    }

    public LottoTickets(List<Lotto> lotto){
        this.tickets = lotto;
    }

    private static Lotto makeRandomLottoTicket() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(MINIMUM_OF_LOTTO.get(), MAXIMUM_OF_LOTTO.get(), SIZE_OF_LOTTO.get()));
    }

    public LottoResults calculateResult(WinningNumber winningNumber, BonusNumber bonusNumber){
        int firstPlace = 0;
        int secondPlace = 0;
        int thirdPlace = 0;
        int forthPlace = 0;
        int fifthPlace = 0;

        for (Lotto ticket : tickets) {
            int hit = ticket.countSameNumber(winningNumber);
            if (hit == FIFTH_PLACE_HIT.get()) fifthPlace++;
            if (hit == FOURTH_PLACE_HIT.get()) forthPlace++;
            if (isHitSecondPlace(hit, ticket, bonusNumber)) {
                secondPlace++;
                continue;
            }
            if (hit == SECOND_AND_THIRD_PLACE_HIT.get()) thirdPlace++;
            if (hit == FIRST_PLACE_HIT.get()) firstPlace++;
        }
        return new LottoResults(firstPlace, secondPlace, thirdPlace, forthPlace, fifthPlace);
    }

    private boolean isHitSecondPlace(int hit, Lotto ticket, BonusNumber bonusNumber){
        return (hit == SECOND_AND_THIRD_PLACE_HIT.get()) && ticket.isHitBonusNumber(bonusNumber);
    }

    public String printTickets(){
        StringBuilder ticketContents = new StringBuilder();

        for (Lotto ticket : tickets) {
            ticketContents.append(ticket.getTicketContent()).append(NEW_LINE.get());
        }

        return ticketContents.toString();
    }

    @Override
    public boolean equals(Object obj) {
        LottoTickets input = (LottoTickets) obj;
        return IntStream.range(0, input.tickets.size()).allMatch(i -> tickets.get(i).equals(input.tickets.get(i)));
    }
}
