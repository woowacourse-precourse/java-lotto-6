package lotto.repository;

import lotto.Lotto;

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
    public void saveBonusNumber(int bonusNumber) {
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
    public void saveLottoNumbers(Lotto lotto) {
        lottoNumbers.add(lotto);
    }
}
