package lotto;

import static lotto.resource.TextResourceProvider.LOTTERY_RANKING_RESULT_DEFAULT_HEADER_FORMAT;
import static lotto.resource.TextResourceProvider.LOTTERY_RANKING_RESULT_FORMAT;
import static lotto.resource.TextResourceProvider.LOTTERY_RANKING_RESULT_SECOND_HEADER_FORMAT;

import java.text.NumberFormat;
import java.util.List;
import lotto.service.dto.LotteryResultDto;

public class LotteryResultRenderer {
    private NumberFormat numberFormat;

    public LotteryResultRenderer(NumberFormat numberFormat) {
        this.numberFormat = numberFormat;
    }

    public String render(List<LotteryResultDto> results) {
        StringBuilder builder = new StringBuilder();
        for (LotteryResultDto result : results) {
            builder.append(renderLotteryResult(result));
        }
        return builder.toString();
    }

    private String renderLotteryResult(LotteryResultDto result) {
        if ("LAST_PLACE".equals(result.ranking())) {
            return "";
        }
        String counts = Integer.toString(result.counts());
        String matches = Integer.toString(result.rankingMatches());
        String amount = renderAmount(result.rankingAmount());
        if ("SECOND".equals(result.ranking())) {
            String header = LOTTERY_RANKING_RESULT_SECOND_HEADER_FORMAT.format(matches, amount);
            return LOTTERY_RANKING_RESULT_FORMAT.format(header, counts) + "\n";
        }
        String header = LOTTERY_RANKING_RESULT_DEFAULT_HEADER_FORMAT.format(matches, amount);
        return LOTTERY_RANKING_RESULT_FORMAT.format(header, counts) + "\n";
    }

    private String renderAmount(int amount) {
        return numberFormat.format(amount);
    }

}
