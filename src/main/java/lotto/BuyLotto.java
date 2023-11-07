package lotto;


import java.util.ArrayList;
import java.util.List;
import lotto.domain.GenerateLottoNumber;

public class BuyLotto {
    private static List<List<Integer>> lottoNumbers;

    public BuyLotto() {
        lottoNumbers = new ArrayList<>();
    }

    public LottoNumbers lotto(Money money) {
        for (int i = 0; i < money.availableCount(); i++) {
            List<Integer> lottoNumber =  GenerateLottoNumber.generate();
            lottoNumbers.add(lottoNumber);
        }
        return new LottoNumbers(lottoNumbers);
    }
}
