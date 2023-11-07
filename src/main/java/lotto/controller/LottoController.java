package lotto.controller;

import lotto.domain.BonusLottoNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoResultCalculation;
import lotto.domain.RandomLottoNumber;
import lotto.type.ResultType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class LottoController {
    private LottoResultCalculation lottoResultCalculation;
    private RandomLottoNumber randomLottoNumber;
    private List<Lotto> randomLottos;
    private BonusLottoNumber bonusLottoNumber;

    private Lotto inputLottoNumber;

    public LottoController() {
        lottoResultCalculation = new LottoResultCalculation();
        randomLottoNumber = new RandomLottoNumber();
        randomLottos = new ArrayList<>();
        inputLottoNumber = null;
        bonusLottoNumber = null;
    }

    public int getLottoTicket(int money) {
        return lottoResultCalculation.caculateLottoTicket(money);
    }

    public void setRandomLottoNumber(int tickets) {
        randomLottos.clear();
        for (int i = 0; i < tickets; i++) {
            randomLottoNumber.initRandomNumber();
            Lotto lottoNumbers = new Lotto(randomLottoNumber.getNumbers());
            this.randomLottos.add(lottoNumbers);
        }
    }

    public void setBounsNumber(int bonus) {
        bonusLottoNumber = new BonusLottoNumber(bonus);
    }

    public void setinputLottoNumber(String numbers) {
        String[] splitedNumbers = numbers.split(",");
        List<Integer> intNumbers = new ArrayList<>();
        for(String str : splitedNumbers) {
            intNumbers.add(Integer.parseInt(str));
        }
        inputLottoNumber = new Lotto(intNumbers);
    }

    public String getLottoString() {
        StringBuffer stringResult = new StringBuffer();
        for (Lotto lotto : randomLottos) {
            stringResult.append(lotto.getNumbers().toString());
            stringResult.append("\n");
        }
        return stringResult.toString();
    }

    public int getLottoResult(List<Integer> target, List<Integer> tryLotto) {
        int result = lottoResultCalculation.checkResult(target, tryLotto);
        return result;
    }

    public boolean getBonusResult(List<Integer> target, int bouns) {
        boolean result = lottoResultCalculation.checkBonusNumber(target, bouns);
        return result;
    }

    public ResultType getRankResult(int sameNumber, boolean isBonus) {
        Optional<ResultType> resultType = Arrays.stream(ResultType.values())
                .filter(result -> result.sameNumber() == sameNumber && result.isBonus() == isBonus)
                .findFirst();
        return resultType.orElse(null);
    }

    public ResultType getTotalResult(List<Integer> target, List<Integer> tryLotto, int bonus) {
        int sameNumber = getLottoResult(target, tryLotto);
        boolean isBonus = getBonusResult(target, bonus);
        ResultType resultType = getRankResult(sameNumber, isBonus);
        return resultType;
    }

    public List<ResultType> getAllOfResult(List<Integer> tryLotto, int bonus) {
        List<ResultType> result = new ArrayList<>();
        for(Lotto lotto : randomLottos) {
            ResultType resultType = getTotalResult(lotto.getNumbers(), tryLotto, bonus);
            result.add(resultType);
        }
        return result;
    }
}
