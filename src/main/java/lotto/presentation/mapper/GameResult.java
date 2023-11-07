package lotto.presentation.mapper;

import lotto.domain.Lotto;
import lotto.application.LottoGameInfo;
import lotto.global.constant.enums.MatchResultType;

import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

public abstract class GameResult {

    /**
     * 출력 요구사항에 맞는 구매 현황 데이터로 변환합니다.
     * @see lotto.presentation.mapper.Resultable
     */
    public static class IssuedLottos implements Resultable {
        private static final String PREFIX = "[";
        private static final String SUFFIX = "]\n";
        private static final String DELIMITER = ", ";
        private static final String PURCHASE_FORMAT = "%d개를 구매했습니다.\n";

        private final LottoGameInfo.PurchaseStatus purchaseStatus;

        private IssuedLottos(LottoGameInfo.PurchaseStatus purchaseStatus) {
            this.purchaseStatus = purchaseStatus;
        }
        public static IssuedLottos from(LottoGameInfo.PurchaseStatus purchaseStatus) {
            return new IssuedLottos(purchaseStatus);
        }

        @Override
        public String toResult() {
            StringBuilder resultBuilder = new StringBuilder();
            resultBuilder.append(String.format(PURCHASE_FORMAT, purchaseStatus.quantity()));

            for (Lotto lotto : purchaseStatus.lottos()) {
                String eachLottoResult = convertToResult(lotto.getLottoNumbers());
                resultBuilder.append(eachLottoResult);
            }
            return resultBuilder.toString();
        }

        private String convertToResult(List<Integer> numbers) {
            StringJoiner numberJoiner = new StringJoiner(DELIMITER, PREFIX, SUFFIX);
            for (Integer number : numbers) {
                numberJoiner.add(String.valueOf(number));
            }
            return numberJoiner.toString();
        }
    }


    /**
     * 출력 요구사항에 맞는 당첨 통계 데이터로 변환합니다.
     * @see lotto.presentation.mapper.Resultable
     */
    public static class WinningStatistic implements Resultable {

        private final Map<MatchResultType, Long> resultBoard;

        private WinningStatistic(Map<MatchResultType, Long> resultBoard) {
            this.resultBoard = resultBoard;
        }

        public static WinningStatistic from(LottoGameInfo.MatchResult matchResult) {
            return new WinningStatistic(matchResult.resultBoard());
        }

        @Override
        public String toResult() {
            StringBuilder builder = new StringBuilder();
            for (MatchResultType matchResultType : MatchResultType.values()) {
                String result = String.format( matchResultType.getFormat(), resultBoard.get(matchResultType));
                builder.append(result);
            }
            return builder.toString();
        }
    }


    /**
     * 출력 요구사항에 맞는 수익률 데이터로 변환합니다.
     * @see lotto.presentation.mapper.Resultable
     */
    public static class RevenueRate implements Resultable {
        private static final String REVENUE_RATE_FORMAT = "총 수익률은 %.1f";
        private static final String RESULT_SUFFIX = "%입니다.";

        private final long inputAmount;
        private final long totalReward;

        private RevenueRate(long inputAmount, long totalReward) {
            this.inputAmount = inputAmount;
            this.totalReward = totalReward;
        }

        public static RevenueRate from(LottoGameInfo.RevenueInfo revenueInfo) {
            return new RevenueRate(revenueInfo.inputAmount(), revenueInfo.totalReward());
        }


        @Override
        public String toResult() {
            return String.format(REVENUE_RATE_FORMAT,  calculateRate()) + RESULT_SUFFIX;
        }

        private double calculateRate() {
            double rate = (double) totalReward / inputAmount;
            return Math.round(rate * 1000) / 10.0;
        }

    }
}
