package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoSetting;
import lotto.domain.WinningResult;
import lotto.domain.WinningType;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Objects;

public class OutputView {
    public void printPurchasedLottos(List<Lotto> lottos) {
        printPurchasedLottosQuantity(lottos);
        for (Lotto lotto : lottos) {
            printLottoNumber(lotto);
        }
    }

    private void printPurchasedLottosQuantity(List<Lotto> lottos) {
        if (Objects.isNull(lottos)) {
            return;
        }
        int quantity = lottos.size();
        System.out.println(quantity + "개를 구매했습니다.");
    }

    private void printLottoNumber(Lotto lotto) {
        if (Objects.isNull(lotto)) {
            return;
        }
        List<Integer> numbers = lotto.getNumbers();
        StringBuilder sb = new StringBuilder();

        sb.append("[");
        sb.append(numbers.get(0));
        for (int i = 1; i < numbers.size(); i++) {
            sb.append(", ");
            sb.append(numbers.get(i));
        }
        sb.append("]");
        System.out.println(sb);
    }

    public void printWinningResult(WinningResult winningResult) {
        System.out.println("당첨 통계");
        System.out.println("---");
        printNumberOfWins(winningResult);
        printEarningRate(winningResult);
    }

    private void printEarningRate(WinningResult winningResult) {
        long earnings = winningResult.getTotalPrice();
        long paid = (long) winningResult.getLottoCount()
                * LottoSetting.PRICE.getValue();
        double earningRate = (double) earnings / paid * 100;
        System.out.println(String.format("총 수익률은 %.1f%%입니다.", earningRate));
    }

    private void printNumberOfWins(WinningResult winningResult) {
        printWinningType(WinningType.valueOf("FIFTH"), winningResult);
        printWinningType(WinningType.valueOf("FOURTH"), winningResult);
        printWinningType(WinningType.valueOf("THIRD"), winningResult);
        printWinningType(WinningType.valueOf("SECOND"), winningResult);
        printWinningType(WinningType.valueOf("FIRST"), winningResult);
    }

    private void printWinningType(WinningType type, WinningResult winningResult) {
        int matchingCount = type.getMatchingCount();
        int winningCount = winningResult.getWinningCountOfType(type);
        String money = getDecimalFormetString(type.getPrice());
        String output = String.format("%d개 일치", matchingCount);
        if (type.getBonusMatching()) {
            output += ", 보너스 볼 일치";
        }
        output += String.format(" (%s원) - %d개", money, winningCount);
        System.out.println(output);
    }

    private String getDecimalFormetString(long amount) {
        DecimalFormat df = new DecimalFormat("###,###");
        return df.format(amount);
    }

}
