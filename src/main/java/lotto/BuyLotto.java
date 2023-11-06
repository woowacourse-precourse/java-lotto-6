package lotto;

import java.util.ArrayList;
import java.util.List;

public class BuyLotto {
    private static List<Lotto> lotto = new ArrayList<>();

    public boolean checkSameNumber(List<Integer> paper, int number) {
        boolean result = true;
        for (int i = 0; i < paper.size(); i++) {
            if (paper.get(i) == number) {
                result = false;
                break;
            }
        }
        return result;
    }
}
