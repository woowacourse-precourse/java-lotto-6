package lotto.repository;

import lotto.domain.Lotto;

import java.util.List;

public interface Repository {
    public Lotto getAnswerLotto();
    public void setAnswerLotto(Lotto lotto);
    public int getCountLotto();
    public void setCountLotto(int countLotto);
    public void setBonusNumber(int bonusNumber);
    public int getBonusNumber();
    public List<Lotto> getLottoNumbers();
    public void setLottoNumbers(Lotto lotto);
}
