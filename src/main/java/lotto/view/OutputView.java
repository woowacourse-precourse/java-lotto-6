package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.constant.LottoInfo;
import lotto.constant.LottoRank;
import lotto.dto.LottoDto;
import lotto.vo.TicketQuantity;

public class OutputView {

    public void printRequestInputPurchaseAmountMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printTicketQuantityMessage(final Integer quantity) {
        System.out.println();
        String message = String.format("%s개를 구매했습니다.", quantity);
        System.out.println(message);
    }

    public void printRequestInputWinningNumberMessage() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void printRequestInputBonusNumberMessage() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void printMessage(final String message) {
        System.out.println(message);
    }

    public void printPlayerNumbers(final List<LottoDto> playerLotteries) {
        playerLotteries.stream().forEach(lottoDto -> {
            System.out.println(lottoDto.getNumbers());
        });
        System.out.println();
    }

    public void printStatistics(final Map<LottoRank, Integer> result) {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        System.out.println(String.format("3개 일치 (5,000원) - %s개",
                result.getOrDefault(LottoRank.FIFTH_RANK, 0)));
        System.out.println(String.format("4개 일치 (50,000원) - %s개",
                result.getOrDefault(LottoRank.FOURTH_RANK, 0)));
        System.out.println(String.format("5개 일치 (1,500,000원) - %s개",
                result.getOrDefault(LottoRank.THIRD_RANK, 0)));
        System.out.println(String.format("5개 일치, 보너스 볼 일치 (30,000,000원) - %s개",
                result.getOrDefault(LottoRank.SECOND_RANK, 0)));
        System.out.println(String.format("6개 일치 (2,000,000,000원) - %s개",
                result.getOrDefault(LottoRank.FIRST_RANK, 0)));
    }

    public void printRateOfProfit(final Map<LottoRank, Integer> result, TicketQuantity ticketQuantity) {
        double reward = 0;

        for (LottoRank lottoRank : result.keySet()) {
            reward += lottoRank.getPrizeMoney() * result.get(lottoRank);
        }

        double m = (double) ticketQuantity.quantity() * LottoInfo.ONE_LOTTO_PRICE.getValue();

        System.out.println(String.format("총 수익률은 %,.1f%%입니다.", (reward / m) * 100));
    }
}
