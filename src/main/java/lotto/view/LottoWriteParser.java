package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoRanking;
import lotto.dto.LottoDto;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import static lotto.view.LottoWriteMessage.*;

public class LottoWriteParser {

    private static final DecimalFormat wonDecimalFormat = new DecimalFormat("#,###");

    public String parseLottosDetail(LottoDto.Information lottos) {
        StringBuilder stringBuilder = new StringBuilder();

        for (Lotto lotto : lottos.getLottos()) {
            stringBuilder.append(lotto.getInformation());
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }

    public String parseLottoResult(LottoDto.Result lottoResult) {
        Map<LottoRanking, Integer> result = lottoResult.getResult();
        return Arrays.stream(LottoRanking.values())
                .map(lottoRanking -> {
                    if (lottoRanking.equals(LottoRanking.NO_LUCK)) {
                        return BLANK.getMessage();
                    }
                    StringBuilder stringBuilder = new StringBuilder(
                            String.format(WINNING_NUMBER_MATCH_FORMAT.getMessage(), lottoRanking.getCorrectNumberCount())
                    );
                    if (lottoRanking.equals(LottoRanking.SECOND)) {
                        stringBuilder.append(BONUS_NUMBER_MATCH_FORMAT);
                    }
                    stringBuilder.append(String.format(
                            RESULT_FORMAT.getMessage(),
                            wonDecimalFormat.format(lottoRanking.getPrize()),
                            result.getOrDefault(lottoRanking, 0)
                    ));
                    return stringBuilder.toString();
                })
                .collect(Collectors.joining(LINE_BREAK.getMessage()));
    }

    public String parseProfit(double calculateProfit) {
        return String.format(TOTAL_PROFIT_FORMAT.getMessage(), calculateProfit);
    }

    public String parsePaidLottoLog(int size) {
        return String.format(BUY_HISTORY.getMessage(), size);
    }
}
