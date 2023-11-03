package lotto.dto;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;

public class IssuedLottoResponse {

    private List<Integer> lottoNumbers;

    private IssuedLottoResponse(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers.stream().toList();
    }

    public static List<IssuedLottoResponse> of(List<Lotto> lottos) {
        List<IssuedLottoResponse> lottoResponses = new ArrayList<>();
        lottos.forEach(lotto -> {
            lottoResponses.add(of(lotto));
        });
        return lottoResponses;
    }

    private static IssuedLottoResponse of(Lotto lotto) {
        return new IssuedLottoResponse(lotto.getNumbers());
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers.stream().sorted().toList();
    }
}
