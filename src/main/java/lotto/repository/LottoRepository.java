package lotto.repository;

import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoRepository implements Repository{
    private Lotto answerLotto;
    private int bonusNumber;
    private final List<Lotto> lottoNumbers = new ArrayList<>();

    @Override
    public Lotto getAnswerLotto() {
        return answerLotto;
    }

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
