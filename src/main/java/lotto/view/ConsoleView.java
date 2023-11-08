package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import lotto.domain.LottoWinning;
import lotto.domain.PurchasedLottoStatistics;
import lotto.domain.PurchasedLottoTickets;
import lotto.domain.ViewContract;

public class ConsoleView implements ViewContract {

    @Override
    public String requestPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    @Override
    public void showPurchaseLottoTickets(PurchasedLottoTickets purchasedLottoTickets) {
        System.out.println(purchasedLottoTickets.size() + "개를 구매했습니다.");
        System.out.println(purchasedLottoTickets);
    }

    @Override
    public void showErrorMessage(String message) {
        System.out.println("[ERROR] " + message);
    }

    @Override
    public List<Integer> requestWinningLottoNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        try {
            return Arrays.stream(Console.readLine().split(","))
                    .mapToInt(Integer::parseInt)
                    .boxed()
                    .sorted()
                    .toList();
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("입력 받은 숫자가 유효하지 않습니다.");
        }
    }

    @Override
    public int requestBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("입력 받은 숫자가 유효하지 않습니다.");
        }
    }

    @Override
    public void showStatistics(PurchasedLottoStatistics statistics) {
        System.out.println("당첨 통계");
        System.out.println("---");
        Arrays.stream(LottoWinning.values()).sorted(Comparator.reverseOrder())
                .forEach(lottoWinning -> showStatisticOf(lottoWinning, statistics.countWinningLotto(lottoWinning)));
        System.out.println("총 수익률은 " + statistics.calculateRevenueRatio() + "%입니다.");
    }

    private void showStatisticOf(LottoWinning lottoWinning, long count) {
        if (lottoWinning == LottoWinning.LOSE) {
            return;
        }
        System.out.println(formatWinningCondition(lottoWinning, count));
    }

    private String formatWinningCondition(LottoWinning lottoWinning, long count) {
        return String.format(
                "%d개 일치%s (%s원) - %d개",
                lottoWinning.ruleOfMatchedCount,
                formatBonusNumberCondition(lottoWinning.hasBonusMatch),
                formatPrice(lottoWinning.prize),
                count
        );
    }

    private String formatBonusNumberCondition(Boolean isBonusMatched) {
        if (isBonusMatched) {
            return ", 보너스 볼 일치";
        }
        return "";
    }

    private String formatPrice(Long price) {
        DecimalFormat formatter = new DecimalFormat("###,###");
        return formatter.format(price);
    }
}
