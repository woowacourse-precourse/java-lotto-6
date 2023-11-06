package lotto.io.lottos;

import java.util.List;
import lotto.game.io.Randoms;

public class LottosRandoms implements Randoms {

    public static final int START_INCLUSIVE = 1;
    public static final int END_INCLUSIVE = 45;
    public static final int COUNT = 6;

    @Override
    public List<Integer> getSixNumbers() {
        return camp.nextstep.edu.missionutils.Randoms
                .pickUniqueNumbersInRange(START_INCLUSIVE, END_INCLUSIVE, COUNT);
    }

}
