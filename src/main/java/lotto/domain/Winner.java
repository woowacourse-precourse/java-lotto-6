package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class Winner {
    private static final String FIRST_PLACE = "1stPlace";
    private static final String SECOND_PLACE = "2ndPlace";
    private static final String THIRD_PLACE = "3rdPlace";
    private static final String FOURTH_PLACE = "4thPlace";
    private static final String FIFTH_PLACE = "5thPlace";


    private Map<String, Integer> winners;

    public Winner() {
        winners = new HashMap<>();
        winners.put(FIRST_PLACE, 0);
        winners.put(SECOND_PLACE, 0);
        winners.put(THIRD_PLACE, 0);
        winners.put(FOURTH_PLACE, 0);
        winners.put(FIFTH_PLACE, 0);
    }

    public void increase1stPlace() {
        winners.put(FIRST_PLACE, winners.get(FIRST_PLACE) + 1);
    }

    public void increase2ndPlace() {
        winners.put(SECOND_PLACE, winners.get(SECOND_PLACE) + 1);
    }

    public void increase3rdPlace() {
        winners.put(THIRD_PLACE, winners.get(THIRD_PLACE) + 1);
    }

    public void increase4thPlace() {
        winners.put(FOURTH_PLACE, winners.get(FOURTH_PLACE) + 1);
    }

    public void increase5thPlace() {
        winners.put(FIFTH_PLACE, winners.get(FIFTH_PLACE) + 1);
    }

    public int get1stPlace() {
        return winners.get(FIRST_PLACE);
    }

    public int get2ndPlace() {
        return winners.get(SECOND_PLACE);
    }

    public int get3rdPlace() {
        return winners.get(THIRD_PLACE);
    }

    public int get4thPlace() {
        return winners.get(FOURTH_PLACE);
    }

    public int get5thPlace() {
        return winners.get(FIFTH_PLACE);
    }
}
