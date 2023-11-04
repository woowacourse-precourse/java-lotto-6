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

    public List<Integer> getMatchesForAllTickets(List<Integer> winningNumber) {
        List<Integer> matchesList = new ArrayList<>();
        for (Lotto lotto : lottos) {
            int matches = lotto.getMatches(winningNumber);
            matchesList.add(matches);
        }
        return matchesList;
    }


    private List<Integer> generateRandomNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);

        return numbers;
    }

}
