package lotto.controller;

import lotto.domain.BonusLottoNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoResultCalculation;
import lotto.domain.RandomLottoNumber;

import java.util.ArrayList;
import java.util.List;

public class LottoGetter implements LottoGetterInterface {
    private LottoResultCalculation lottoResultCalculation;
    private RandomLottoNumber randomLottoNumber;
    private List<Lotto> randomLottoResult;

    public LottoGetter() {
        lottoResultCalculation = new LottoResultCalculation();
        randomLottoNumber = new RandomLottoNumber();
        randomLottoResult = new ArrayList<>();
    }

    @Override
    public int getLottoTicket(int money) {
        return lottoResultCalculation.caculateLottoTicket(money);
    }

    @Override
    public List<Lotto> getLottoNumber(int tickets) {
        randomLottoResult.clear();
        for (int i = 0; i < tickets; i++) {
            randomLottoNumber.initRandomNumber();
            Lotto lottoNumbers = new Lotto(randomLottoNumber.getNumbers());
            this.randomLottoResult.add(lottoNumbers);
        }
        return randomLottoResult;
    }

    @Override
    public BonusLottoNumber getBounsNumber(int bonus) {
        return new BonusLottoNumber(bonus);
    }

    @Override
    public String getLottoString() {
        StringBuffer stringResult = new StringBuffer();
        for (Lotto lotto : randomLottoResult) {
            stringResult.append(lotto.getNumbers().toString());
            stringResult.append("\n");
        }
        return stringResult.toString();
    }
}
