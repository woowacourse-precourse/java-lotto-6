package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.vo.WinLotto;

public class Game {
    private static final int LOTTO_MIN_NUM = 1;
    private static final int LOTTO_MAX_NUM = 45;
    private static final int LOTTO_LEN = 6;

    /**
     * 2. 구매 가능한 로또 개수만큼 로또 자동 발급기능
     */
    public List<Lotto> generateLottoList(int lottoCount) {
        List<Lotto> list = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            //랜덤 값 자동 생성 및 세팅
            list.add(new Lotto(getRandomNumList()));
        }
        return list;
    }

    private List<Integer> getRandomNumList() {
        List<Integer> list = Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUM, LOTTO_MAX_NUM, LOTTO_LEN);
        return sort(list);
    }

    private List<Integer> sort(List<Integer> list) {
        // ApplicationTest 에서 테스트할 때 immutable list 를 넘겨줄 때가 있어서 mutable list 로 만들어줌
        List<Integer> copiedList = new ArrayList<>(list);
        Collections.sort(copiedList);
        return copiedList;
    }

    private Map<Rank, Integer> getRankCountMap() {
        Map<Rank, Integer> rankCountMap = new LinkedHashMap<>();

        rankCountMap.put(Rank.RANK_5, 0);
        rankCountMap.put(Rank.RANK_4, 0);
        rankCountMap.put(Rank.RANK_3, 0);
        rankCountMap.put(Rank.RANK_2, 0);
        rankCountMap.put(Rank.RANK_1, 0);

        return rankCountMap;
    }

    /**
     * 6. 당첨에 대한 통계 기능
     * <p>
     * 전체 로또들 당첨 결과 보기
     */
    public Map<Rank, Integer> judgePrizeLotto(WinLotto winLotto, List<Lotto> lottos) {
        Map<Rank, Integer> rankCountMap = getRankCountMap();

        for (Lotto lotto : lottos) {
            // 몇등인지 계산한다.
            Rank rank = calculateRank(winLotto, lotto);
            rankCountMap.put(rank, rankCountMap.getOrDefault(rank, 0) + 1);
        }

        return rankCountMap;
    }

    private Rank calculateRank(WinLotto winLotto, Lotto lotto) {
        int duplicatedCount = countDuplicate(lotto, winLotto);
        boolean isDuplicatedBonusNum = isBunus(lotto, winLotto.getBonusNum());

        if (duplicatedCount == 6) {
            return Rank.RANK_1;
        }

        if (duplicatedCount == 5 && isDuplicatedBonusNum) {
            return Rank.RANK_2;
        }

        if (duplicatedCount == 5) {
            return Rank.RANK_3;
        }

        if (duplicatedCount == 4) {
            return Rank.RANK_4;
        }

        if (duplicatedCount == 3) {
            return Rank.RANK_5;
        }

        return Rank.UNRANK;
    }

    private boolean isBunus(Lotto lotto, int bonus) {
        List<Integer> list = lotto.getNumbers();
        if (list.contains(bonus)) {
            return true;
        }

        return false;
    }

    //각 리스트별 카운팅 개수 리턴해서
    private int countDuplicate(Lotto lotto, WinLotto winLotto) {
        List<String> lotto_num = lotto.getNumbers().stream()
                .map(Object::toString)
                .collect(Collectors.toList());

        List<String> winLotto_list = winLotto.getNumbers().stream()
                .map(Object::toString)
                .collect(Collectors.toList());

        lotto_num.retainAll(winLotto_list);//중복되는 것만 남게

        return lotto_num.size();
    }


    /**
     * 수익률 계산 기능
     */
    public int getLottoTotalPrizePrice(Map<Rank, Integer> rankIntegerMap) {
        int lottoPrizePrice = 0;

        for (Rank rank : rankIntegerMap.keySet()) {
            if (rank == Rank.UNRANK) {
                continue;
            }

            lottoPrizePrice += rank.getPrize() * rankIntegerMap.get(rank);
        }
        return lottoPrizePrice;
    }

    public double getPercentPrize(int inPrice, int outPrice) {
        double inVal = inPrice + 0.0;
        double outVal = outPrice + 0.0;

        double result = outVal / inVal * 100;
        result = Math.round(result * 100) / 100.0; //소수점 둘째 자리에서 반올림하고,
        return result;
    }
}
