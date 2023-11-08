package lotto;

import java.util.ArrayList;
import java.util.List;

public class GameRepository {
    private final List<Lotto> lottos = new ArrayList<>();
    private int cash;
    private Lotto winLottoNumber;
    private int bonusNumber;

    public void saveCash(int cash) {
        this.cash = cash;
    }

    public void saveNumber(List<Integer> numbers) {
        lottos.add(new Lotto(numbers));
    }

    public void saveWinLottoNumber(List<Integer> numbers) {
        winLottoNumber = new Lotto(numbers);
    }

    public void saveBonusNumber(int number) {
        bonusNumber = number;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public Lotto getWinLottoNumber() {
        return winLottoNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public int getCash() {
        return cash;
    }
}
