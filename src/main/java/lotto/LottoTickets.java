package lotto;

import static lotto.LottoConfig.COUNT;
import static lotto.LottoConfig.END_NUM;
import static lotto.LottoConfig.START_NUM;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LottoTickets {
    private final List<Lotto> tickets;

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

    public LottoPrizeBag matchPrize(LottoWinningNumber winningNumber) {
        List<LottoPrize> lottoPrizes = new ArrayList<>();
        for (Lotto ticket : tickets) {
            LottoPrize prize = ticket.match(winningNumber.getCommonNumbers(), winningNumber.getBonusNumber());
            lottoPrizes.add(prize);
        }
        return new LottoPrizeBag(lottoPrizes);
    }

    public int size() {
        return tickets.size();
    }
}
