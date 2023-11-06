package lotto.repository;

import lotto.Lotto;

import java.util.List;

public interface Repository {
    public Lotto getAnswerLotto();
    public void setAnswerLotto(Lotto lotto);
    public int getCountLotto();
    public void setCountLotto(int countLotto);
    public void saveBonusNumber(int bonusNumber);
    public int getBonusNumber();
    public List<Lotto> getLottoNumbers();
    public void saveLottoNumbers(Lotto lotto);
}
