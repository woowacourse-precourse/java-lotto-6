package lotto.repository;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoRepository implements Repository{
    private Lotto answerLotto;
    private int countLotto;
    private int bonusNumber;
    private final List<Lotto> lottoNumbers = new ArrayList<>();

    @Override
    public Lotto getAnswerLotto() {
        return answerLotto;
    }
    @Override
    public void setAnswerLotto(Lotto answerLotto){this.answerLotto = answerLotto; }
    @Override
    public int getCountLotto(){return countLotto;}
    @Override
    public void setCountLotto(int countLotto){this.countLotto = countLotto;}
    @Override
    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }
    @Override
    public int getBonusNumber() {
        return bonusNumber;
    }
    @Override
    public List<Lotto> getLottoNumbers() {
        return lottoNumbers;
    }
    @Override
    public void setLottoNumbers(Lotto lotto) {
        lottoNumbers.add(lotto);
    }
}
