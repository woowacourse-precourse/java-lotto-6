package lotto.Lotto.repository;

import lotto.Lotto.entity.Lotto;
import lotto.LottoPlayer.repository.LottoPlayerRepository;

public class LottoRepository {

    private static final LottoRepository instance = new LottoRepository();

    public static LottoRepository getInstance() {
        return instance;
    }

    private LottoRepository() {
    }

    private Lotto winningLotto;
    private int bonusNumber;

    public void setWinningLotto(Lotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }



}
