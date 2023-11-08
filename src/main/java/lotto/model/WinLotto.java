package lotto.model;

import lotto.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WinLotto {

    private Lotto winLotto;
    private int bonusNum;
    private List<Lotto> secondPlaceLottos;

    public WinLotto(Lotto winLotto, int bonusNum) {
        this.winLotto = winLotto;
        this.bonusNum = bonusNum;
        this.secondPlaceLottos = getSecondPlaceLotto(winLotto, bonusNum);
    }

    private List<Lotto> getSecondPlaceLotto(Lotto winLotto, int bonusNum) {

        List<Lotto> secondPlaceLottos = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            Lotto original = winLotto.copy();
            List<Integer> numbers = original.getNumbers();
            numbers.set(i, bonusNum);
            Collections.sort(numbers);
            secondPlaceLottos.add(new Lotto(numbers));
        }

        return secondPlaceLottos;
    }

    public List<Integer> getWinLottoNumbers() {
        return winLotto.getNumbers();
    }

    public int getBonusNum() {
        return bonusNum;
    }

    public List<Lotto> getSecondPlaceLottos() {
        return secondPlaceLottos;
    }

}
