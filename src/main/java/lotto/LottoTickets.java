package lotto;

import static lotto.LottoConfig.COUNT;
import static lotto.LottoConfig.END_NUM;
import static lotto.LottoConfig.START_NUM;

import camp.nextstep.edu.missionutils.Randoms;
import dto.LottoMoneyDTO;
import java.util.LinkedList;
import java.util.List;

public class LottoTickets {
    private List<Lotto> tickets;

    public LottoTickets(LottoMoneyDTO money) {
        tickets = new LinkedList<>();

        for (int i = 0; i < money.getAmount(); i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(START_NUM, END_NUM, COUNT);
            Lotto lotto = new Lotto(numbers);
            tickets.add(lotto);
        }
    }

    public List<String> sayLottoNumbers() {
        List<String> lines = new LinkedList<>();
        for (Lotto ticket : tickets) {
            String line = ticket.sayNumbers();
            lines.add(line);
        }
        return lines;
    }
}
