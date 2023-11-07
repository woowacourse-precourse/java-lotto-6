package lotto.view;

import lotto.dto.LottoDto;
import lotto.dto.LottoResultDto;
import lotto.dto.LottoTicketsDto;
import lotto.model.Rank;

public class Output {
    private static final String MATCH_COUNT_FORMAT = "%d개 일치";
    private static final String BONUS_NUMBER_FORMAT = ", 보너스 볼 일치";
    private static final String REWARD_FORMAT = " (%,d원)";
    private static final String ACTUAL_MATCH_COUNT_FORMAT = " - %d개";
    private static final String LOTTO_RATE_FORMAT = "총 수익률은 %.1f%%입니다.";

    private Output() {}

    public static void printLottoTickets(LottoTicketsDto lottoTicketsDto) {
        for (LottoDto lottoDto : lottoTicketsDto.getLottoTickets()) {
            System.out.println(lottoDto.getNumbers());
        }
        System.out.println();
    }

    public static void printLottoResult(LottoResultDto lottoResultDto) {
        System.out.println("당첨 통계");
        System.out.println("---");

        for (Rank rank : lottoResultDto.getLottoResult().keySet()) {
            int matchCount = rank.getMatchCount();
            long reward = rank.getReward();
            int actualMatchCount = lottoResultDto.getLottoResult().get(rank);

            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(String.format(MATCH_COUNT_FORMAT, matchCount));
            if (rank.hasBonusNumber()) {
                stringBuilder.append(BONUS_NUMBER_FORMAT);
            }
            stringBuilder.append(String.format(REWARD_FORMAT, reward));
            stringBuilder.append(String.format(ACTUAL_MATCH_COUNT_FORMAT, actualMatchCount));
            System.out.println(stringBuilder.toString());
        }
    }

    public static void printLottoRate(double lottoRate) {
        System.out.println(String.format(LOTTO_RATE_FORMAT, lottoRate));
    }

    public static void printExceptionMessage(String exceptionMessage) {
        System.out.println(exceptionMessage);
    }
}
