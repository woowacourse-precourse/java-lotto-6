package lotto.domain;


import java.util.ArrayList;
import java.util.List;

public class BuyLotto {
    private static List<LottoNumber> lottoNumbers;

    public BuyLotto() {
        lottoNumbers = new ArrayList<>();
    }

    public LottoNumbers lotto(Money money) {
        for (int i = 0; i < money.availableCount(); i++) {
            LottoNumber lottoNumber =  new LottoNumber(GenerateLottoNumber.generate());
            lottoNumbers.add(lottoNumber);
        }
        return new LottoNumbers(lottoNumbers);
    }
}
