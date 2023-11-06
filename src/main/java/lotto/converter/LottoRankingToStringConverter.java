package lotto.converter;

import lotto.domain.LottoRanking;

import java.util.List;

public class LottoRankingToStringConverter implements Converter<List<LottoRanking>, List<String>> {

    @Override
    public List<String> convert(List<LottoRanking> lottoRankings) {
        return lottoRankings.stream()
                .map(Enum::name)
                .toList();
    }
}
