package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.util.LottoRank;

import java.util.ArrayList;
import java.util.List;


public class LottoStore {
    public static final int LOTTO_PRICE = 1000;
    public static final int LOTTO_START_NUMBER = 1;
    public static final int LOTTO_LAST_NUMBER = 45;
    public static final int LOTTO_NUMBER_COUNT = 6;

    public static List<Lotto> lottoIssuance(int amount) {
        List<Lotto> lottos = new ArrayList<>();
        int countOfLotto = amount / LOTTO_PRICE;

        for (int i = 0; i < countOfLotto; i++) {
            lottos.add(new Lotto(generateRandomLottoNumbers()));
        }
        return lottos;
    }

    private static List<Integer> generateRandomLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_START_NUMBER, LOTTO_LAST_NUMBER, LOTTO_NUMBER_COUNT);
    }

    public String getLottoResultsSummary(int[] lottoResult, double rateOfReturn) {
        StringBuilder sb = new StringBuilder();
        sb.append("당첨 통계\n---\n");

        for (int i = lottoResult.length - 1; i > 0; i--) {
            sb.append(getLottoMatchMessage(i, lottoResult[i]));
        }
        sb.append("총 수익률은 ").append(rateOfReturn).append("%입니다.");
        return sb.toString();
    }

    private String getLottoMatchMessage(int rank, int count) {
        StringBuilder sb = new StringBuilder();
        LottoRank lottoRank = LottoRank.values()[rank];

        sb.append(lottoRank.getMatchCount());
        sb.append("개 일치");
        if (isSecondPrize(lottoRank.getRank())) {
            sb.append(", 보너스 볼 일치");
        }
        sb.append(" (")
                .append(lottoRank.getWinningAmountFormat())
                .append("원) - ");
        sb.append(count);
        sb.append("개");

        return sb.toString() + "\n";
    }

    private boolean isSecondPrize(int rank) {
        return rank == LottoRank.SECOND_PRIZE.getRank();
    }


}
