package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.UserLotto;

import static lotto.domain.LottoConstant.*;

public class LottoService {

    public List<Lotto> generateLotto(int lottoQuantity) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < lottoQuantity; i++) {
            List<Integer> lottoNumbers = generateLottoNumbers();

            lottos.add(new Lotto(lottoNumbers));
        }

        return lottos;
    }

    public EnumMap<LottoRank, Integer> getLottoResult(List<Lotto> lottoes, UserLotto userLotto) {
        EnumMap<LottoRank, Integer> lottoResult = initLottoResultMap();

        for (Lotto lotto : lottoes) {
            long hitCount = countMatchingNumbers(lotto.getNumbers(), userLotto.getNumbers());
            boolean isContainBonusNumber = checkBonusNumber(lotto.getNumbers(), userLotto.getBonusNumber());

            LottoRank rank = getLottoRank(hitCount, isContainBonusNumber);

            int rankCount = lottoResult.getOrDefault(rank, 0);
            lottoResult.put(rank, ++rankCount);
        }

        return lottoResult;
    }

    private static LottoRank getLottoRank(long hitCount, boolean isBonusNumberContain) {
        List<LottoRank> lottoRanks = Arrays.asList(LottoRank.values());

        for (LottoRank rank : lottoRanks) {
            if (hitCount == SECOND_WINNER_HIT_COUNT && isBonusNumberContain) {
                return LottoRank.SECOND;
            }

            if (rank.getMatchCount() == hitCount) {
                return rank;
            }
        }
        return LottoRank.MISS;
    }

    public double calculatePrizeRatio(EnumMap<LottoRank, Integer> lottoResult, int userPurchasePrice) {
        int totalPrize = 0;

        for (Map.Entry<LottoRank, Integer> entry : lottoResult.entrySet()) {
            LottoRank rank = entry.getKey();
            int count = entry.getValue();
            totalPrize += rank.getWinningAmount() * count;
        }

        return  ((double) totalPrize / userPurchasePrice) * 100.0;
    }

    private long countMatchingNumbers(List<Integer> lottoNumbers, List<Integer> userLottoNumbers) {
        return lottoNumbers.stream()
                .filter(userLottoNumbers::contains)
                .count();
    }

    private static boolean checkBonusNumber(List<Integer> lottoNumbers, int bonusNumber) {
        return lottoNumbers.contains(bonusNumber);
    }

    private static List<Integer> generateLottoNumbers() {
        List<Integer> lottoNumbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_NUMBER_SIZE));
        Collections.sort(lottoNumbers);

        return lottoNumbers;
    }

    private EnumMap<LottoRank, Integer> initLottoResultMap() {
        EnumMap<LottoRank, Integer> lottoRanks = new EnumMap<>(LottoRank.class);

        for (LottoRank lottoRank : LottoRank.values()) {
            lottoRanks.put(lottoRank, 0);
        }

        return lottoRanks;
    }
}
