package lotto.view;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import lotto.Model.LottoPrizeCalculator;

public class LottoOutput {

    public String requestAmountMessage() {
        return "구매금액을 입력해 주세요.";
    }

    public String printNumberOfTicketsMessage(int count) {
        return count + "개를 구매했습니다.";
    }

    public String getLottoNumbersMessage(List<Integer> lottoNumbers) {
        return lottoNumbers.toString();
    }

    public String getErrorMessage(String message) {
        return message;
    }

    public String requestWinningNumber() {
        return "당첨 번호를 입력해 주세요.";
    }

    public String requestBonusNumber() {
        return "보너스 번호를 입력해 주세요.";
    }

    public void printPrizeStatistics(Map<Integer, Integer> prizeCountMap) {

        System.out.println("당첨 통계");
        System.out.println("---");

        Map<Integer, Integer> sortedPrizeCountMap = new TreeMap<>(prizeCountMap);

        for (Map.Entry<Integer, Integer> entry : sortedPrizeCountMap.entrySet()) {
            int prize = entry.getKey();
            int count = entry.getValue();
            String prizeDescription = LottoPrizeCalculator.getPrizeDescription(prize); // 상금 설명을 가져오는 메서드 호출
            if (prizeDescription != null) {
                System.out.printf("%s - %d개\n", prizeDescription, count);
            }
        }
    }

    public void printEarningsRate(double earningsRate) {
        DecimalFormat df = new DecimalFormat("0.0%");
        String formattedEarningsRate = df.format(earningsRate / 100);
        System.out.println("총 수익률은 " + formattedEarningsRate + "입니다.");
    }

}
