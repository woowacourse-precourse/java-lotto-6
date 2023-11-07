package lotto;

import static lotto.LottoConfig.COUNT;
import static lotto.LottoConfig.END_NUM;
import static lotto.LottoConfig.START_NUM;

import camp.nextstep.edu.missionutils.Randoms;
import dto.LottoResultDTO;
import dto.WinningNumberDTO;
import java.util.LinkedList;
import java.util.List;

public class LottoTickets {
    private List<Lotto> tickets;

    public static LottoTickets buy(int money) {
        int amount = money / LottoConfig.PRICE;
        return new LottoTickets(amount);
    }

    private LottoTickets(int amount) {
        tickets = new LinkedList<>();

        for (int i = 0; i < amount; i++) {
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

    public LottoResultDTO matchPrize(WinningNumberDTO winningNumbers) {
        return null;
    }

    public int size() {
        return tickets.size();
    }
}
