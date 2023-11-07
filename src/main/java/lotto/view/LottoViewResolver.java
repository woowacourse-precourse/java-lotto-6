package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoRanking;
import lotto.dto.LottoDto;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoViewResolver {

    private static final String WON_FORMAT_PATTERN = "#,###";

    public String parseLottosDetail(LottoDto.Information lottos) {
        StringBuilder stringBuilder = new StringBuilder();

        for (Lotto lotto : lottos.getLottos()) {
            stringBuilder.append(lotto.getInformation());
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }

    public String parseLottoResult(LottoDto.Result lottoResult) {
        Map<LottoRanking, Integer> result = lottoResult.result();
        DecimalFormat decimalFormat = new DecimalFormat(WON_FORMAT_PATTERN);

        return Arrays.stream(LottoRanking.values())
                .map(lottoRanking -> {
                    if (lottoRanking.equals(LottoRanking.NO_LUCK)) {
                        return "";
                    }
                    StringBuilder stringBuilder = new StringBuilder()
                            .append(lottoRanking.getCorrectNumberCount())
                            .append("개 일치");
                    if (lottoRanking.equals(LottoRanking.SECOND)) {
                        stringBuilder.append(", 보너스 볼 일치");
                    }
                    stringBuilder.append(" (")
                            .append(decimalFormat.format(lottoRanking.getPrize()))
                            .append("원) - ")
                            .append(result.getOrDefault(lottoRanking, 0))
                            .append("개\n");
                    return stringBuilder.toString();
                })
                .collect(Collectors.joining(""));
    }

    public String parseProfit(double calculateProfit) {
        return new StringBuilder()
                .append("총 수익률은 ")
                .append(calculateProfit)
                .append("%입니다.")
                .toString();
    }

    public String parsePaidLottoLog(int size) {
        return size + LottoGuideMessage.BOUGHT_LOG.getMessage();
    }
}
