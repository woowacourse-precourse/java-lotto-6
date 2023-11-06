package lotto.ui;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoPrizeStatus;
import lotto.domain.ResultStatics;

public class OutputView {

    public void enterYourAmount() {
        System.out.println("\n구입금액을 입력해주세요.");
    }

    public void showLottosNumber(List<Lotto> lottos) {
        int issueCount = lottos.size();
        System.out.println(issueCount + "개를 구매했습니다.");
        for (int i = 0; i < issueCount; i++) {
            System.out.println(lottos.get(i));
        }
    }

    public void showErrorReason(String message) {
        System.out.println(message);
    }

    public void enterYourNumber() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
    }

    public void enterYourBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
    }

    public void showResultStatistics(ResultStatics resultStatics) {
        Map<LottoPrizeStatus, Integer> resultMap = resultStatics.getPrizeResult();
        double earningRate = resultStatics.getEarningRate();
        System.out.println("당첨 통계");
        System.out.println("---");
        DecimalFormat df = new DecimalFormat("#,###.0");
        showMatchResult(resultMap);
        System.out.println(new StringBuilder("총 수익률은 ")
                .append(df.format(earningRate))
                .append("%입니다."));
    }

    private void showMatchResult(Map<LottoPrizeStatus, Integer> resultMap) {
        DecimalFormat df = new DecimalFormat("#,###");
        resultMap.keySet()
                .stream()
                .sorted()
                .forEach(status -> {
                    System.out.printf("%s (%s원) - %d개\n", status.getMatchInformation(),
                            df.format(status.getPrizeMoney()), resultMap.get(status));
                });
    }
}
