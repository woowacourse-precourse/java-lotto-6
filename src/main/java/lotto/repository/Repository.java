package lotto.repository;

import lotto.Lotto;

import java.util.List;

public interface Repository {
    public Lotto getAnswerLotto();
    public void saveBonusNumber(int bonusNumber);
    public int getBonusNumber();
    public List<Lotto> getLottoNumbers();
    public void saveLottoNumbers(Lotto lotto);
}
