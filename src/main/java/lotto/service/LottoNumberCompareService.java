package lotto.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.repository.Lotto;

public class LottoNumberCompareService {
    private List<Lotto> publishedLottoNumbers = new ArrayList<>();
    private List<Integer> lottoDrawNumber = new ArrayList<>();
    private Integer lottoBonusNumber;

    private Map<String, Integer> matchResult = new LinkedHashMap<>();
    private Integer sumDrawMoney = 0;
    private double earnings = 0f;

    private Integer lottoPrice;

    private LottoNumberCompareService() {
    }

    private static class LottoNumberCompareServiceHolder {
        private static final LottoNumberCompareService LOTTO_NUMBER_COMPARE_SERVICE = new LottoNumberCompareService();
    }

    public static LottoNumberCompareService getInstance() {
        return LottoNumberCompareServiceHolder.LOTTO_NUMBER_COMPARE_SERVICE;
    }

    public void inputNumber(List<Lotto> publishedLottoNumbers, List<Integer> lottoDrawNumber,
                            Integer lottoBonusNumber, Integer lottoPrice) {
        this.publishedLottoNumbers = publishedLottoNumbers;
        this.lottoDrawNumber = lottoDrawNumber;
        this.lottoBonusNumber = lottoBonusNumber;
        this.lottoPrice = lottoPrice;
    }

    public void initMatchResult() {
        for (int i = 30; i <= 60; i += 10) {
            matchResult.put(String.valueOf(i), 0);
            if (i == 50) matchResult.put(String.valueOf(i + 1), 0);
        }

        for (int i = 0; i < publishedLottoNumbers.size(); i++) {
            putResult(eachNumberCompare(publishedLottoNumbers.get(i)), publishedLottoNumbers.get(i));
        }
    }

    public void calcResult() {
        sumDrawMoney();
        earningsRate();
    }

    public double getEarnings() {
        return earnings;
    }

    public Map<String, Integer> getMatchResult() {
        return matchResult;
    }

    private void sumDrawMoney() {
        for (String key : matchResult.keySet()) {
            if (key.equals("30")) sumDrawMoney += (5_000 * matchResult.get(key));

            if (key.equals("40")) sumDrawMoney += (50_000 * matchResult.get(key));

            if (key.equals("50")) sumDrawMoney += (1_500_000 * matchResult.get(key));

            if (key.equals("51"))  sumDrawMoney += (30_000_000 * matchResult.get(key));

            if (key.equals("60"))  sumDrawMoney += (2_000_000_000 * matchResult.get(key));
        }
    }

    private void earningsRate() {
        if (sumDrawMoney != 0) {
            double divResult = ((double) sumDrawMoney / lottoPrice) * 100;
            earnings = (double) Math.round(divResult  * 10) / 10.0;
        }
    }

    private Integer eachNumberCompare(Lotto lotto) {
        Integer matchNumberCount = 0;
        for (int i = 0; i < lottoDrawNumber.size(); i++) {
            if (lottoDrawNumber.contains(lotto.getNumbers().get(i))) {
                ++matchNumberCount;
            }
        }
        return matchNumberCount;
    }

    private void putResult(Integer matchNumberCount, Lotto lotto) {
        if (matchNumberCount >= 3) {
            String key = Integer.toString(matchNumberCount) + "0";
            if (matchNumberCount == 5 && findMatchBounsNumber(lotto)) {
                key = Integer.toString(matchNumberCount) + "1";
            }
            matchResult.put(key, matchResult.get(key) + 1);
        }
    }

    private boolean findMatchBounsNumber(Lotto lotto) {
        for (Integer bonusNumber : lotto.getNumbers()) {
            if (bonusNumber == lottoBonusNumber) {
                return true;
            }
        }
        return false;
    }
}
