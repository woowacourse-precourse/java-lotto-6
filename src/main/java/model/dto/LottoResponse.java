package model.dto;

import static consts.Mark.OUTPUT_JOINER;

import java.util.List;
import model.Lotto;
import model.LottoNumber;
import model.LottoWithBonus;

public record LottoResponse(List<String> lottoResponse) {

    public static LottoResponse from(final LottoWithBonus lottoWithBonus) {
        Lotto lotto = lottoWithBonus.getLotto();
        List<String> lottoNumbers = lotto.getNumbers()
            .stream()
            .map(LottoNumber::getNumber)
            .sorted()
            .map(String::valueOf)
            .toList();

        return new LottoResponse(lottoNumbers);
    }

    public String getJoinedNumbers() {
        return String.join(OUTPUT_JOINER.mark(), lottoResponse);
    }
}
