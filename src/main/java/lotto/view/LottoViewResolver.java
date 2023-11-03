package lotto.view;

import lotto.Lotto;
import lotto.LottoRanking;
import lotto.dto.LottoDto;

import java.util.Map;

public class LottoViewResolver {

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

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder
                .append("3개 일치 (5,000원) - ")
                .append(result.getOrDefault(LottoRanking.FIFTH, 0))
                .append("개\n")
                .append("4개 일치 (50,000원) - ")
                .append(result.getOrDefault(LottoRanking.FOURTH, 0))
                .append("개\n")
                .append("5개 일치 (1,500,000원) - ")
                .append(result.getOrDefault(LottoRanking.THIRD, 0))
                .append("개\n")
                .append("5개 일치, 보너스 볼 일치 (30,000,000원) - ")
                .append(result.getOrDefault(LottoRanking.SECOND, 0))
                .append("개\n")
                .append("6개 일치 (2,000,000,000원) - ")
                .append(result.getOrDefault(LottoRanking.FIRST, 0))
                .append("개\n");

        return stringBuilder.toString();
    }

    public String parseProfit(double calculateProfit) {
        return new StringBuilder()
                .append("총 수익률은 ")
                .append(calculateProfit)
                .append("%입니다.")
                .toString();
    }
}
