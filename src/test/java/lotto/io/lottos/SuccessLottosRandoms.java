package lotto.io.lottos;

import java.util.List;
import lotto.game.io.Randoms;

public class SuccessLottosRandoms implements Randoms {

    private int number = 1;

    @Override
    public List<Integer> getSixNumbers() {
        return List.of(number++,
                number++,
                number++,
                number++,
                number++,
                number++);
    }

}
