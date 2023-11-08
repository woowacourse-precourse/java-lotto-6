package lotto.controller;

import lotto.domain.BonusLottoNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoResultCalculation;
import lotto.domain.RandomLottoNumber;
import lotto.type.ErrorMessageType;
import lotto.type.ResultType;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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

    public int getLottoTicket(String money) throws IllegalArgumentException {
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

    public void setBonusNumber(String bonus) throws IllegalArgumentException {
        bonusLottoNumber = new BonusLottoNumber(bonus);
        if(inputLottoNumber.getNumbers().contains(bonusLottoNumber.getBounsNum())) {
            throw new IllegalArgumentException(ErrorMessageType.NOT_DIVIDE_THOUSAND.message());
        }
    }

    public void setInputLottoNumber(String numbers) throws IllegalArgumentException {
        String[] splitedNumbers = numbers.split(",");
        List<Integer> intNumbers = new ArrayList<>();
        for (String str : splitedNumbers) {
            str = str.replaceAll(" ", "");       // 각각의 공백 제거
            if (!Pattern.matches("^[1-9][0-9]*$", str)) {
                throw new IllegalArgumentException(ErrorMessageType.NOT_NUMBER.message());
            }
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
        return resultType.orElse(ResultType.NOTHING);
    }

    public ResultType getTotalResult(List<Integer> target, List<Integer> tryLotto, int bonus) {
        int sameNumber = getLottoResult(target, tryLotto);
        boolean isBonus = getBonusResult(target, bonus);
        ResultType resultType = getRankResult(sameNumber, isBonus);
        return resultType;
    }

    public Map<ResultType, Long> getResultTypeCount(List<ResultType> resultTypes) {
        return resultTypes.stream()
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()));
    }

    public Map<ResultType, Long> getAllOfResult() {
        List<ResultType> resultTypes = new ArrayList<>();
        List<Integer> tryLotto = inputLottoNumber.getNumbers();
        int bonus = bonusLottoNumber.getBounsNum();
        for (Lotto lotto : randomLottos) {
            ResultType resultType = getTotalResult(lotto.getNumbers(), tryLotto, bonus);
            resultTypes.add(resultType);
        }
        Map<ResultType, Long> resultTypeLongMap = getResultTypeCount(resultTypes);

        return resultTypeLongMap;
    }

    public double getReturnRate(Map<ResultType, Long> resultTypeLongMap) {
        int totalWinningMoney = 0;
        Iterator<Map.Entry<ResultType, Long>> iterator = resultTypeLongMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<ResultType, Long> entry = iterator.next();
            totalWinningMoney += entry.getKey().reward() * entry.getValue();
        }
        double returnRate = lottoResultCalculation.calculateReturn(totalWinningMoney);
        return returnRate;
    }
}
