package lotto.io.lottos;

import java.util.List;
import lotto.game.io.Randoms;

public class NotSixLottosRandoms implements Randoms {

    @Override
    public List<Integer> getSixNumbers() {
        return List.of(1, 2, 3, 4, 5);
    }

}
