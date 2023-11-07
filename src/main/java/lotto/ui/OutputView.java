package lotto.ui;

import java.text.DecimalFormat;
import java.util.Map;
import java.util.stream.Collectors;

import lotto.domain.LottoPrize;
import lotto.domain.Lottos;
import lotto.domain.ResultStatics;

public class OutputView {

    public void enterYourAmount() {
        System.out.println("\n구입금액을 입력해주세요.");
    }

    public void showLottosNumber(Lottos lottos) {
        int issueCount = lottos.issuedSize();
        System.out.printf("%d개를 구매했습니다.\n", issueCount);
        for (int ordinal = 0; ordinal < issueCount; ordinal++) {
            String lottoNumber = lottos.getOrdinalLotto(ordinal)
                    .getNumbers()
                    .stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", ", "[", "]"));
            System.out.println(lottoNumber);
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
        Map<LottoPrize, Integer> resultMap = resultStatics.getPrizeResult();
        double earningRate = resultStatics.getEarningRate();
        System.out.println("당첨 통계\n---");
        DecimalFormat df = new DecimalFormat("#,###.0");
        showMatchResult(resultMap);
        System.out.println(new StringBuilder("총 수익률은 ")
                .append(df.format(earningRate))
                .append("%입니다."));
    }

    private void showMatchResult(Map<LottoPrize, Integer> resultMap) {
        DecimalFormat df = new DecimalFormat("#,###");
        resultMap.keySet()
                .stream()
                .sorted()
                .forEach(status -> {
                    System.out.printf("%s (%s원) - %d개\n", status.getPrizeStatement(),
                            df.format(status.getPrizeMoney()), resultMap.get(status));
                });
    }
}
