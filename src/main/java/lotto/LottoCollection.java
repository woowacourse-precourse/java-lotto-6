package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoCollection {
    public List<Lotto> lottoCollection;
    private final int numberOfLotto;

    private final Map<Integer, Integer> rankingCount = new HashMap<>();

    public LottoCollection(int numberOfLotto) {
        this.numberOfLotto = numberOfLotto;
        this.lottoCollection = new ArrayList<>();
        generateLottoNumbers(numberOfLotto);
    }

    private void generateLottoNumbers(int numberOfLotto) {
        for (int i = 0; i < numberOfLotto; i++) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            lottoCollection.add(lotto);
        }
    }

    public void printLottoNumbers() {
        System.out.println(numberOfLotto + "개를 구매했습니다.");
        for (Lotto lotto : lottoCollection) {
            lotto.printLottoNumbers();
        }
    }

    public void matchLottoNumbers(LottoResult result) {
        int matchingCount = 0;
        boolean matchingBonusCount = false;
        for (Lotto lotto : lottoCollection) {
            matchingCount = lotto.countMatchingLottoNumbers(result);
            matchingBonusCount = lotto.hasBonusNumber(result);
            setRank(matchingCount, matchingBonusCount);
        }
    }

    private void setRank(int matchingCount, boolean matchingBonusCount) {
        int rank = 0;
        if (matchingCount == 3) {
            rank = 5;
        } else if (matchingCount == 4) {
            rank = 4;
        } else if (matchingCount == 5 && !matchingBonusCount) {
            rank = 3;
        } else if (matchingCount == 5) {
            rank = 2;
        } else if (matchingCount == 6) {
            rank = 1;
        }
        rankingCount.put(rank, rankingCount.getOrDefault(rank, 0) + 1);
    }

    private LottoRank getLottoRankByNumber(int number) {
        for (LottoRank rank : LottoRank.values()) {
            if (rank.ordinal() + 1 == number) {
                return rank;
            }
        }
        return null;
    }
}
