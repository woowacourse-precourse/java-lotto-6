package lotto.view;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoRank;

public class OutputView {

    private static final String REQUEST_PURCHASE_PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String TOTAL_TICKET_MESSAGE = "개를 구매했습니다.";
    private static final String REQUEST_WINNER_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String REQUEST_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String LOTTO_STATS = "당첨 통계";
    private static final String RESULT_LINE = "---";
    private static final String RESULT_FORMAT_HEAD = "개 일치 (";
    private static final String RESULT_FORMAT_MIDDLE = "원) - ";
    private static final String RESULT_FORMAT_TAIL = "개";
    private static final int INITIALIZE_STRING_BUILDER = 0;
    private static final String TOTAL_RETURN_RATE = "총 수익률은 ";
    private static final String RETURN_RATE_MESSAGE = "입니다.";
    private static final String RETURN_RATE_MARK = "%";
    private static final String RETURN_RATE_FORMAT = "###,###.##";

    public void printRequestPurchasePrice() {
        System.out.println(REQUEST_PURCHASE_PRICE_MESSAGE);
    }

    public void printTotalTicket(int totalTicket, List<Lotto> lottoPaper) {
        System.out.println(totalTicket + TOTAL_TICKET_MESSAGE);
        for (Lotto lotto : lottoPaper) {
            System.out.println(lotto.createDto().getNumbers());
        }
    }

    public void printRequestWinnerNumber() {
        System.out.println(REQUEST_WINNER_NUMBER_MESSAGE);
    }

    public void printRequestBonusNumber() {
        System.out.println(REQUEST_BONUS_NUMBER_MESSAGE);
    }

//    public void printLottoResult(Map<LottoRank, Integer> lottoResult) {
//        StringBuilder sb = new StringBuilder();
//        int count = 1;
//        lottoResult.
//
//        for (LottoRankMessage value : LottoRankMessage.values()) {
//
//            sb.setLength(INITIALIZE_STRING_BUILDER);
//            sb.append(value.getErrorMessage())
//                .append(winner.get(count));
//            System.out.println();
//        }
//    }

    public void printLottoResult(Map<LottoRank, Integer> lottoResult) {
        List<Integer> rankResult = new ArrayList<>(lottoResult.values());
        StringBuilder sb = new StringBuilder();
        int rankResultIndex = 0;

        System.out.println(LOTTO_STATS);
        System.out.println(RESULT_LINE);
        for (Entry<LottoRank, Integer> lottoResultValue : lottoResult.entrySet()) {
            if (lottoResultValue.getKey() == LottoRank.LOSING) {
                continue;
            }
            sb.setLength(INITIALIZE_STRING_BUILDER);
            sb.append(lottoResultValue.getKey().getResultMessage())
                .append(lottoResultValue.getValue())
                .append("개");
            System.out.println(sb);
        }

//        for (LottoRank lottoRank : LottoRank.values()) {
//            if (lottoRank == LottoRank.LOSING) {
//                rankResultIndex++;
//                continue;
//            }
//            rankResultIndex = getRankResultIndex(lottoRank, sb, rankResult, rankResultIndex);
//        }
    }

//    private int getRankResultIndex(LottoRank lottoRank, StringBuilder sb, List<Integer> rankResult,
//        int rankResultIndex) {
//        DecimalFormat decFormat = new DecimalFormat(RETURN_RATE_FORMAT);
//        int lottoRankPrize = lottoRank.getLottoRankPrize();
//        String lottoRankPrizeMoney = decFormat.format(lottoRankPrize);
//
//        sb.setLength(INITIALIZE_STRING_BUILDER);
//        sb.append(lottoRank.getMatchNumberCount()).append(RESULT_FORMAT_HEAD)
//            .append(lottoRankPrizeMoney).append(RESULT_FORMAT_MIDDLE)
//            .append(rankResult.get(rankResultIndex))
//            .append(RESULT_FORMAT_TAIL);
//        rankResultIndex++;
//        System.out.println(sb);
//        return rankResultIndex;
//    }

    public void printReturnRate(double returnRate) {
        StringBuilder sb = new StringBuilder();
        DecimalFormat decFormat = new DecimalFormat(RETURN_RATE_FORMAT);
        double rate = returnRate;
        String returnRateResult = decFormat.format(rate);

        sb.append(TOTAL_RETURN_RATE)
            .append(returnRateResult)
            .append(RETURN_RATE_MARK)
            .append(RETURN_RATE_MESSAGE);
        System.out.println(sb);
    }
}
