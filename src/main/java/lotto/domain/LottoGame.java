package lotto.domain;

import static lotto.consts.LottoConst.LOTTO_MAX_NUMBER;
import static lotto.consts.LottoConst.LOTTO_MIN_NUMBER;
import static lotto.consts.LottoConst.LOTTO_PRICE;
import static lotto.consts.LottoConst.LOTTO_SIZE;
import static lotto.domain.LottoResult.findByCountAndValidBonus;
import static lotto.domain.LottoResult.values;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LottoGame {

    private final List<Lotto> lottos = new ArrayList<>();
    private final Map<LottoResult, Integer> lottoMap = new LinkedHashMap<>();

    public LottoGame(int lottoMoney) {
        buildLottos(lottoMoney);
        buildLottoMap();
    }

    private void buildLottos(int lottoMoney) {
        int lottoCount = lottoMoney / LOTTO_PRICE;
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> lottoNums = Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_SIZE);
            List<Integer> sortedLottoNums = lottoNums.stream().sorted().toList();
            lottos.add(new Lotto(sortedLottoNums));
        }
    }

    private void buildLottoMap() {
        for (LottoResult lottoResult : values()) {
            lottoMap.put(lottoResult, 0);
        }
    }

    public void addValueLottoMap(WinNumber winNumber, BonusNumber bonusNumber) {
        List<Integer> winNums = winNumber.getLottoNums();
        int bonusNum = bonusNumber.getBonusNumber();

        for (Lotto lotto : lottos) {
            List<Integer> lottoNums = lotto.getNumbers();
            int count = calculateCounts(lottoNums, winNums);
            boolean bonusNumContained = isBonusNumContained(lottoNums, bonusNum);
            validLottoResultAndPutValue(count, bonusNumContained);
        }
    }

    private void validLottoResultAndPutValue(int count, boolean bonusNumContained) {
        LottoResult lottoResult = findByCountAndValidBonus(count, bonusNumContained);
        if (lottoResult != null) {
            lottoMap.put(lottoResult, lottoMap.get(lottoResult) + 1);
        }
    }

    private int calculateCounts(List<Integer> lottoNums, List<Integer> winNums) {
        return (int) lottoNums.stream().filter(winNums::contains).count();
    }

    public double calculatePrizePercentage(int money) {
        return calculatePrize() * 100 / money;
    }

    private double calculatePrize() {
        double prize = 0;
        for (LottoResult lottoResult : lottoMap.keySet()) {
            prize += lottoResult.getPrize() * lottoMap.get(lottoResult);
        }
        return prize;
    }

    private boolean isBonusNumContained(List<Integer> lottoNums, int bonusNum) {
        return lottoNums.contains(bonusNum);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public Map<LottoResult, Integer> getLottoMap() {
        return lottoMap;
    }
}