package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.UserLotto;

public class LottoService {

    public int calculateLottoSheet(int price) {
        if (price % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또는 1000원 단위로 구매해야 합니다. 다시 입력해주세요.");
        }

        return price / 1000;
    }

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

            if (rank == null) {
                continue;
            }

            int rankCount = lottoResult.getOrDefault(rank, 0);
            rankCount++;

            lottoResult.put(rank, rankCount);
        }

        return lottoResult;
    }

    private static LottoRank getLottoRank(long hitCount, boolean isBonusNumberContain) {
        if (hitCount == 6) {
            return LottoRank.FIRST;
        }

        if (hitCount == 5 && isBonusNumberContain) {
            return LottoRank.SECOND;
        }

        if (hitCount == 5) {
            return LottoRank.THIRD;
        }

        if (hitCount == 4) {
            return LottoRank.FOURTH;
        }

        if (hitCount == 3) {
            return LottoRank.FIFTH;
        }

        return null;
    }

    public UserLotto purchaseLotto(String inputLottoNumbers, String inputBonusNumber) {
        List<Integer> lottoNumbers = Arrays.stream(inputLottoNumbers.split(","))
                .map(Integer::parseInt)
                .toList();

        int bonusNumber = Integer.parseInt(inputBonusNumber);

        return new UserLotto(lottoNumbers, bonusNumber);
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
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
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
