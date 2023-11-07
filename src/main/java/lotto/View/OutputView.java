package lotto.View;

import java.util.Map;
import lotto.Domain.PlayerPrice;
import lotto.Enum.LottoRankingInfo;

public class OutputView {
    private static void println(String message) {
        System.out.println(message);
    }

    public static void requestBuyingPayPrompt() {
        println("구입금액을 입력해 주세요.");
    }

    public void printIssuedLottoTickets(PlayerPrice playerPrice) {
        println("\n" + countLottoTickets(playerPrice) + "개를 구매했습니다.");
    }

    public void printIssuedLottoNumbers(PlayerPrice playerPrice) {
        playerPrice.getLottoTickets().stream().forEach(playerNumber -> {
            System.out.println(playerNumber.getNumbers());
        });
    }

    // 기능목록 5번 문구 출력
    public void requestWinningNumbersForDrawer() {
        println("\n당첨 번호를 입력해 주세요.");
    }

    public void requestBonusNumbersForDrawer() {
        println("\n보너스 번호를 입력해 주세요.");
    }

    public void printWinningResult(Map<LottoRankingInfo, Integer> countWinngNumbers) { // 기능목록 10번 출력
        println("\n당첨 통계");
        println("---");
        println("3개 일치 (5,000원) - " + countWinngNumbers.getOrDefault(LottoRankingInfo.THREE_MATCH, 0) + "개");
        println("4개 일치 (50,000원) - " + countWinngNumbers.getOrDefault(LottoRankingInfo.FOUR_MATCH, 0) + "개");
        println("5개 일치 (1,500,000원) - " + countWinngNumbers.getOrDefault(LottoRankingInfo.FIVE_MATCH, 0) + "개");
        println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + countWinngNumbers.getOrDefault(LottoRankingInfo.FIVE_AND_BONUS, 0)
                + "개");
        println("6개 일치 (2,000,000,000원) - " + countWinngNumbers.getOrDefault(LottoRankingInfo.SIX_MATCH, 0) + "개");
    }

    public void printROI(String printROI) {
        println("총 수익률은 " + printROI + "%입니다.");
    }

    public int countLottoTickets(PlayerPrice playerPrice) {
        return playerPrice.getBuyingPay() / 1000;
    }
}
