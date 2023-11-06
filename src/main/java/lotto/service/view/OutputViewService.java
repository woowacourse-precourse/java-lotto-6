package lotto.service.view;

import lotto.model.Lotto;
import lotto.model.LottoResult;

import java.util.Comparator;
import java.util.List;

import static lotto.common.MessageType.*;

/**
 * @Class : 로또 관리 UI 출력 클래스
 */
public class OutputViewService {

    private static final int ADVANCE_SIZE = 3;

    public static void outputAmount() {
        System.out.println(ASK_PURCHASE_AMOUNT.getMessage());
    }

    public static void outputEa(int ea) {
        System.out.println(getEaMessage(ea));
    }

    public static void outputLottoList(List<Lotto> lottoList) {
        lottoList.forEach(l -> System.out.println(l.toString()));
        System.out.println();
    }

    public static void outputWinnigNumbers() {
        System.out.println(ASK_WINNING_NUMBERS.getMessage());
    }

    public static void outputBonusNumber() {
        System.out.println(ASK_BONUS_NUMBERS.getMessage());
    }

    public static void outputStatisticIntro() {
        System.out.println(WINNING_STATISTICS.getMessage());
        System.out.println(ADVANCE.getMessage().repeat(ADVANCE_SIZE));
    }

    public static void outputStatistics(List<LottoResult> lottoResultList) {
        lottoResultList.sort(Comparator.comparingInt(lr -> lr.getReward()));
        lottoResultList.forEach(lr -> {
            System.out.println(getStatisticsMessage(lr.getMatchCount(), lr.getReward(), lr.getSameEa(), lr.isLottoSecondRank()));
        });
    }

    public static void outputRateOfReturn(double rateOfReturn) {
        System.out.println(getRateOfReturnMessage(rateOfReturn));
    }

    public static void outPutErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }
}
