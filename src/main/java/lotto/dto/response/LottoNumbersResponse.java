package lotto.dto.response;

import java.util.List;

public class LottoNumbersResponse {

    private final List<Integer> lottoNumber;

    public LottoNumbersResponse(List<Integer> numbers) {
        this.lottoNumber = numbers;
    }

    public List<Integer> getLottoNumber() {
        return lottoNumber;
    }
}
