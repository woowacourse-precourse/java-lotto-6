package lotto.dto.response;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;

public class LottoBuyResponse {
    private List<LottoResponse> buyLottoNumbers;

    public LottoBuyResponse(List<LottoResponse> buyLottoNumbers) {
        this.buyLottoNumbers = buyLottoNumbers;
    }

    public int getCount() {
        return buyLottoNumbers.size();
    }

    public List<LottoResponse> getBuyLottoNumbers() {
        return buyLottoNumbers;
    }

    public static LottoBuyResponse fromLottoNumbers(List<Lotto> buyLottos) {
        List<LottoResponse> lottoResponses = buyLottos.stream()
                .map(LottoResponse::from)
                .collect(Collectors.toList());

        return new LottoBuyResponse(lottoResponses);
    }
}
