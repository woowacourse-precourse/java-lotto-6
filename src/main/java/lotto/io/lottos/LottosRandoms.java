package lotto.io.lottos;

import java.util.List;
import lotto.io.Randoms;

public class LottosRandoms implements Randoms {

    @Override
    public List<Integer> getSixNumbers(int startInclusive, int endInclusive, int count) {
        return camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange(startInclusive, endInclusive, count);
    }

}
