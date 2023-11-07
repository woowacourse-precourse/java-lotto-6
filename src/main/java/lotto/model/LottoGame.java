package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constant.LottoValue;
import lotto.constant.LottoWinningValue;
import lotto.domain.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoGame {
    // 가격 만큼 로또 장 수 발행
    public UserLottos generateAllLottos(Price price) {
        int totalLottoCnt = price.getPrice() / LottoValue.PRICE_PER_PIECE.getValue(); // 사용자가 구매한 로또 장 수

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < totalLottoCnt; i++) {
            Lotto lotto = generateLotto();
            lottos.add(lotto);
        }

        return new UserLottos(lottos);
    }

    // 로또 한 장 발행
    private Lotto generateLotto() {
        int startRange = LottoValue.MIN_VALUE.getValue();
        int endRange = LottoValue.MAX_VALUE.getValue();
        int cnt = LottoValue.WINNING_NUMBER_CNT.getValue();

        return new Lotto(pickRandNums(startRange, endRange, cnt));
    }

    private List<Integer> pickRandNums(int start, int end, int cnt) {
        return Randoms.pickUniqueNumbersInRange(start, end, cnt);
    }

    // 당첨 통계 계산
    public Map<Integer, Integer> calcWinningStatistics(UserLottos userLottos, LottoWinning lottoWinning) {
        Map<Integer, Integer> rankMap = new HashMap<>();

        for (Lotto lotto : userLottos.getLottos()) {
            int rank = calcRank(lotto, lottoWinning);
            rankMap.put(rank, rankMap.getOrDefault(rank, 0) + 1);
        }
        return rankMap;
    }

    // 해당 로또 리스트가 몇 등인지 계산
    // 당첨되지 않았을 경우 -1 반환
    private int calcRank(Lotto lotto, LottoWinning winnigNums) {
        // 당첨 번호 일치하는 개수 찾기
        int matchWinningNum = (int) (lotto.getNumbers().stream()
                .filter(winnigNums.getWinningNum().getNumbers()::contains)
                .count());
        int matchBonusNum = 0;
        if (lotto.getNumbers().contains(winnigNums.getBonusNum())) {
            matchBonusNum++;
        }

        LottoWinningValue winnig = LottoWinningValue.valueOfWinningMatchCnt(matchWinningNum, matchBonusNum);
        if (null != winnig) {
            return winnig.getRank();
        }
        return -1;
    }

    // 수익률 계산해서 반환하는 메서드
    public RateOfReturn calcRateOfReturn(Map<Integer, Integer> rankMap, Price price) {
        int rateOfReturn = 0;
        for (int rank : rankMap.keySet()) {
            if (-1 == rank) continue;

            rateOfReturn += rankMap.get(rank) * LottoWinningValue.valueOfRank(rank).getWinningAmount();
        }
        return new RateOfReturn((double)rateOfReturn / price.getPrice());
    }
}
