package model.dto;

import java.util.List;
import model.Lotto;
import model.LottoNumber;
import model.LottoWithBonus;

public class LottoResponse {

    private static final String DELIMITER = ", ";

    private final List<String> lottoResponse;

    private LottoResponse(final List<String> lotto) {
        this.lottoResponse = lotto;
    }

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
        return String.join(DELIMITER, lottoResponse);
    }
}
