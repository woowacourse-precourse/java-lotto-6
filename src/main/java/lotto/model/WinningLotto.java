package lotto.model;

import java.util.List;

public class WinningLotto {
    private Lotto lotto;

    public WinningLotto(List<Integer> numbers){
        this.lotto = new Lotto(numbers);
    }
}
