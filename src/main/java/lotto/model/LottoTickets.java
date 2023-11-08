package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class LottoTickets {

    private final List<Lotto> tickets = new ArrayList<>();

    public LottoTickets(int count) {
        buyLotto(count);
    }

    public List<Lotto> getTickets() {
        return tickets;
    }

    public void buyLotto(int count) {
        IntStream.range(0, count)
                .mapToObj(i -> new Lotto(generateLottoNumbers()))
                .forEach(tickets::add);
    }

    private List<Integer> generateLottoNumbers() {
        List<Integer> randomNum = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        Collections.sort(randomNum);
        return randomNum;
    }
}
