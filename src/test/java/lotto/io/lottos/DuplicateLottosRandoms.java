package lotto.io.lottos;

import java.util.List;
import lotto.game.io.Randoms;

public class DuplicateLottosRandoms implements Randoms {

    @Override
    public List<Integer> getSixNumbers() {
        return List.of(1, 1, 1, 1, 1, 1);
    }

}
