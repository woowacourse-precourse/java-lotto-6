package lotto.dto.response;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

public class LottoResponse {
    private List<Integer> lotto;

    public LottoResponse(List<Integer> lotto) {
        this.lotto = lotto;
    }

    public List<Integer> getLotto() {
        return lotto;
    }

    public static LottoResponse from(Lotto lotto) {
        return new LottoResponse(
                lotto.getNumbers()
                        .stream()
                        .map(LottoNumber::getNumber)
                        .collect(Collectors.toList())
        );
    }
}
