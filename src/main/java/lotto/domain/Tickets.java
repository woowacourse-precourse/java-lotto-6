package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.utils.Constants;

public class Tickets {
    // Fields
    private final int LOTTO_NUMBER_LENGTH = Constants.LOTTO_NUMBER_LENGTH.getValue();
    private final int RANGE_MIN = Constants.RANGE_MIN.getValue();
    private final int RANGE_MAX = Constants.RANGE_MAX.getValue();
    private final List<Lotto> lottos = new ArrayList<>();


    // Features
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


    // Internal Implements
    private List<Integer> generateRandomNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(RANGE_MIN, RANGE_MAX, LOTTO_NUMBER_LENGTH);

        return numbers;
    }

}
