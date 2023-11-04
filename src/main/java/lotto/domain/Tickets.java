package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Tickets {
    private final List<Lotto> lottos = new ArrayList<>();


    public void generateTickets(int amount) {
        for (int i = 0; i < amount; i++) {
            Lotto lotto = new Lotto(generateRandomNumbers());
            lottos.add(lotto);
        }
    }


    private List<Integer> generateRandomNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);

        return numbers;
    }


    // testcode
    protected int getTicketsCount() {
        return lottos.size();
    }

}
