package lotto.domain;

import static lotto.constants.Common.LOTTO_TICKET_LENGTH;
import static lotto.constants.Common.MAXIMUM_LOTTO_NUMBER;
import static lotto.constants.Common.MINIMUM_LOTTO_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoService {
    public Lotto createLottoTicket(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    private void updateResult(GameResult result, boolean isBonus) {
        if (GameResult.SECOND_PRIZE.getMatchCount() == result.getMatchCount()) {
            if (result.getIsBonus() && isBonus) {
                result.increaseResultCount();
            }
            return ;
        }
        result.increaseResultCount();
    }

    public List<Lotto> purchaseLottoTickets(long amount) {
        List<Lotto> tickets = new ArrayList<>();
        List<Integer> numbers;
        while (amount > 0) {
            numbers = Randoms.pickUniqueNumbersInRange(
                    MINIMUM_LOTTO_NUMBER, MAXIMUM_LOTTO_NUMBER, LOTTO_TICKET_LENGTH
            );
            tickets.add(createLottoTicket(numbers));
            amount--;
        }
        return tickets;
    }
}
