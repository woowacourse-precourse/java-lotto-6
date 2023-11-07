package lotto.domain.lotto;

import lotto.constants.LottoRule;
import lotto.domain.winningNumber.FinalWinningNumber;
import lotto.service.LottoService;

import java.util.*;

public class Lottos {

    int numberOfLotto;
    List<Lotto> lottos = new ArrayList<>();
    HashMap<LottoRank, Integer> rankCount;

    public Lottos(int purchaseAmount) {
        this.numberOfLotto = purchaseAmount / LottoRule.LOTTO_PRICE.getNumber();
        initEachLotto();
        initRankCount();
    }

    private void initEachLotto() {
        for (int i = 0; i < numberOfLotto; i++) {
            lottos.add(new Lotto(LottoService.generateRandomLottoNumber()));
        }
    }

    private void initRankCount() {
        rankCount = new LinkedHashMap<>();
        for (LottoRank lottoRank : LottoRank.values()) {
            rankCount.put(lottoRank, 0);
        }
    }

    public int getNumberOfLotto() {
        return numberOfLotto;
    }

    public List<List<Integer>> getAllLottoNumbers() {
        List<List<Integer>> allLottoNumbers = new ArrayList<>();
        for (Lotto lotto : lottos) {
            allLottoNumbers.add(lotto.getNumbers());
        }
        return Collections.unmodifiableList(allLottoNumbers);
    }

    public HashMap<LottoRank, Integer> getLottosResult(FinalWinningNumber finalWinningNumber) {
        for (Lotto lotto : lottos) {
            LottoRank lottoRank = lotto.compareLottoNumberWithFinalWinningNumber(
                    finalWinningNumber);
            rankCount.put(lottoRank, rankCount.get(lottoRank) + 1);
        }
        rankCount.remove(LottoRank.OUT_OF_RANK);
        return rankCount;
    }

    public double calculateTotalRateOfReturn() {
        double totalSum = 0;
        for (LottoRank lottoRank : rankCount.keySet()) {
            totalSum += lottoRank.getValue() * rankCount.get(lottoRank);
        }
        return totalSum / (numberOfLotto * LottoRule.LOTTO_PRICE.getNumber()) * 100;
    }
}
