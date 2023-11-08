package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoRank;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class UserOutputView {

    private static final String SECOND = "SECOND";
    private static final String BOUGHT_LOTTO = "%s%d개를 구매했습니다.\n";
    private static final String OUTPUT_LAST_FRAME = "총 수익률은 %.1f%%입니다.";
    private static final String OUTPUT_MIDDLE_FRAME = "%d개 일치 (%s원) - %d개\n";
    private static final String OUTPUT_MIDDLE_BONUS_FRAME = "%d개 일치, 보너스 볼 일치 (%s원) - %d개\n";
    private static final String OUTPUT_HEAD_FRAME = System.lineSeparator() + """
            당첨 통계
            ---
            %s%s
            """;
    private static final int START_WIN_NUMBER = 3;
    private static final int END_WIN_NUMBER = 6;
    private static final int MAKE_PERCENT = 100;
    private static final int MAKE_BONUS = 1;
    private final DecimalFormat separatorFormat = new DecimalFormat("###,###");
    private static int numberSeparator;


    public void boughtLottoEachPrint(int count) {
        System.out.printf(BOUGHT_LOTTO, System.lineSeparator(), count);
    }

    public void boughtLottoPrint(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.formatString());
        }
    }

    public void statistics(int usedMoney, int money, Map<String, Integer> myHistory) {
        String middleFrame = middleStatisticsFrameBuild(myHistory);
        String tailFrame = tailFrameBuilder(usedMoney, money);
        System.out.println(statisticsFrameBuild(middleFrame, tailFrame));
    }

    private String statisticsFrameBuild(String middleFrame, String tailFrame) {
        return String.format(OUTPUT_HEAD_FRAME, middleFrame, tailFrame);
    }

    private String middleStatisticsFrameBuild(Map<String, Integer> myHistory) {
        numberSeparator = START_WIN_NUMBER;
        StringBuilder frameBuilder = new StringBuilder();
        Arrays.stream(LottoRank.values()).filter(LottoRank::isWin).forEach(lottoRank -> {
            frameBuilder.append(middleStringFormatter(
                    lottoRank,
                    separatorFormat.format(lottoRank.lottoRankMapper(lottoRank)),
                    myHistory.get(lottoRank.name())));
        });
        return frameBuilder.toString();
    }

    private String tailFrameBuilder(int usedMoney, int winningsMoney) {
        return String.format(OUTPUT_LAST_FRAME, (float) winningsMoney / (float) usedMoney * MAKE_PERCENT);
    }

    private String middleStringFormatter(LottoRank lottoRank, String winMoney, int lottoRankCount) {
        if (lottoRank.name().equals(SECOND)) {
            return String.format(OUTPUT_MIDDLE_BONUS_FRAME, numberSeparator - MAKE_BONUS, winMoney, lottoRankCount);
        }
        return String.format(OUTPUT_MIDDLE_FRAME, numberSeparator++, winMoney, lottoRankCount);
    }
}
