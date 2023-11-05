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

    public int getTicketsCount() {
        return lottos.size();
    }

    public String getTicketOfIndex(int index) {
        Lotto lotto = lottos.get(index);
        return lotto.toString();
    }

    public List<Integer> getPointsForAllTickets(List<Integer> winningNumber) {
        List<Integer> points = new ArrayList<>();
        for (Lotto lotto : lottos) {
            int point = lotto.getPoint(winningNumber);
            points.add(point);
        }
        return points;
    }


    private List<Integer> generateRandomNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);

        return numbers;
    }

}
