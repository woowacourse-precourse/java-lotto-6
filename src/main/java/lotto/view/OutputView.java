package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoRank;

public class OutputView {

    private static final String REQUEST_PURCHASE_PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String TOTAL_TICKET_MESSAGE = "개를 구매했습니다.";
    private static final String REQUEST_WINNER_NUMBER_MESSGE = "당첨 번호를 입력해 주세요.";
    private static final String REQUEST_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String LOTTO_STATS = "당첨 통계";
    private static final String RESULT_LINE = "---";
    private static final String RESULT_FORMAT_HEAD = "개 일치 (";
    private static final String RESULT_FORMAT_MIDDLE = "원) - ";
    private static final String RESULT_FORMAT_TAIL = "개";
    private static final int INITIALIZE_STRING_BUILDER = 0;

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
        System.out.println(REQUEST_WINNER_NUMBER_MESSGE);
    }

    public void printRequestBonusNumber() {
        System.out.println(REQUEST_BONUS_NUMBER_MESSAGE);
    }

    public void printLottoResult(Map<LottoRank, Integer> lottoResult) {
        List<Integer> rankResult = new ArrayList<>(lottoResult.values());

        StringBuilder sb = new StringBuilder();
        int rankResultIndex = 0;

        System.out.println(LOTTO_STATS);
        System.out.println(RESULT_LINE);

//        for (LottoResult value : LottoResult.values()) {
//            if (value == LottoResult.LOSING) {
//                rankResultIndex++;
//                continue;
//            }
//            sb.setLength(INITIALIZE_STRING_BUILDER);
//            sb.append(value.getMatchCount()).append(RESULT_FORMAT_HEAD)
//                .append(value.getWinPrizeMoney()).append(RESULT_FORMAT_MIDDLE)
//                .append(rankResult.get(rankResultIndex))
//                .append(RESULT_FORMAT_TAIL);
//            rankResultIndex++;
//            System.out.println(sb);
//        }

        for (LottoRank lottoRank : LottoRank.values()) {
            if (lottoRank == LottoRank.LOSING) {
                rankResultIndex++;
                continue;
            }
            sb.setLength(INITIALIZE_STRING_BUILDER);
            sb.append(lottoRank.getMatchNumberCount()).append(RESULT_FORMAT_HEAD)
                .append(lottoRank.getLottoRankPrize()).append(RESULT_FORMAT_MIDDLE)
                .append(rankResult.get(rankResultIndex))
                .append(RESULT_FORMAT_TAIL);
            rankResultIndex++;
            System.out.println(sb);


        }
    }

    public void printReturnRate(double returnRate) {
        System.out.println("총 수익률은 ");
        System.out.println(returnRate + "%");
        System.out.println("입니다.");

    }
}
