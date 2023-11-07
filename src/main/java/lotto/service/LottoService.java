package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.UserLotto;

public class LottoService {

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final String LOTTO_NUMBER_SEPARATOR = ",";
    private static final int FIRST_WINNER_HIT_COUNT = 6;
    private static final int SECOND_WINNER_HIT_COUNT = 5;
    private static final int THIRD_WINNER_HIT_COUNT = 5;
    private static final int FORTH_WINNER_HIT_COUNT = 4;
    private static final int FIFTH_WINNER_HIT_COUNT = 3;
    private static final int PRICE_PER_LOTTO = 1000;


    public int calculateLottoSheet(int price) {
        if (price % PRICE_PER_LOTTO != 0) {
            throw new IllegalArgumentException("[ERROR] 로또는 1000원 단위로 구매해야 합니다. 다시 입력해주세요.");
        }

        return price / PRICE_PER_LOTTO;
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
        if (hitCount == FIRST_WINNER_HIT_COUNT) {
            return LottoRank.FIRST;
        }

        if (hitCount == SECOND_WINNER_HIT_COUNT && isBonusNumberContain) {
            return LottoRank.SECOND;
        }

        if (hitCount == THIRD_WINNER_HIT_COUNT) {
            return LottoRank.THIRD;
        }

        if (hitCount == FORTH_WINNER_HIT_COUNT) {
            return LottoRank.FOURTH;
        }

        if (hitCount == FIFTH_WINNER_HIT_COUNT) {
            return LottoRank.FIFTH;
        }

        return null;
    }

    public UserLotto purchaseLotto(String inputLottoNumbers, String inputBonusNumber) {
        List<Integer> lottoNumbers = Arrays.stream(inputLottoNumbers.split(LOTTO_NUMBER_SEPARATOR))
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
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_NUMBER_COUNT);
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
