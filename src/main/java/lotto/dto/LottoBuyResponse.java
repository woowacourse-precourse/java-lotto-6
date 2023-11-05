package lotto.dto;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

public class LottoBuyResponse {
    private List<List<Integer>> buyLottoNumbers;

    public LottoBuyResponse(List<List<Integer>> buyLottoNumbers) {
        this.buyLottoNumbers = buyLottoNumbers;
    }

    public int getCount() {
        return buyLottoNumbers.size();
    }

    public List<List<Integer>> getBuyLottoNumbers() {
        return buyLottoNumbers;
    }

    public static LottoBuyResponse fromLottoNumbers(List<Lotto> buyLottos) {
        return new LottoBuyResponse(
                buyLottos.stream()
                        .map(lotto ->
                                lotto.getNumbers()
                                        .stream()
                                        .map(LottoNumber::getNumber)
                                        .collect(Collectors.toList())
                        ).collect(Collectors.toList())
        );
    }
}
