package lotto.view;

import java.util.EnumMap;
import lotto.dto.LottoDto;
import lotto.dto.LottoResultDto;
import lotto.dto.LottoTicketsDto;
import lotto.model.Rank;

public class Output {
    private static final String LOTTO_COUNT_FORMAT = "%d개를 구매했습니다.";
    private static final String LOTTO_RESULT_FORMAT = "%d개 일치%s (%,d원) - %d개";
    private static final String BONUS_NUMBER_FORMAT = ", 보너스 볼 일치";
    private static final String LOTTO_RATE_FORMAT = "총 수익률은 %.1f%%입니다.";

    private Output() {}

    public static void print(String message) {
        System.out.println(message);
    }

    public static void printLottoTickets(LottoTicketsDto lottoTicketsDto, int lottoCount) {
        print(String.format(LOTTO_COUNT_FORMAT, lottoCount));
        lottoTicketsDto.getLottoTickets()
                .stream()
                .map(LottoDto::getNumbers)
                .forEach(numbers -> print(numbers.toString()));
        print("");
    }

    public static void printLottoResult(LottoResultDto lottoResultDto) {
        print("당첨 통계");
        print("---");
        EnumMap<Rank, Integer> lottoResult = lottoResultDto.getLottoResult();
        for (Rank rank : lottoResult.keySet()) {
            if (rank != Rank.NO_MATCH) {
                print(getLottoResult(rank, lottoResult));
            }
        }
    }

    private static String getLottoResult(Rank rank, EnumMap<Rank, Integer> lottoResult) {
        int matchCount = rank.getMatchCount();
        long reward = rank.getReward();
        int actualMatchCount = lottoResult.get(rank);

        String bonusNumberPart = "";
        if (rank.hasBonusNumber()) {
            bonusNumberPart = BONUS_NUMBER_FORMAT;
        }

        return String.format(LOTTO_RESULT_FORMAT, matchCount, bonusNumberPart, reward, actualMatchCount);
    }

    public static void printLottoRate(double lottoRate) {
        print(String.format(LOTTO_RATE_FORMAT, lottoRate));
    }
}
