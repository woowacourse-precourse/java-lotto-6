package lotto;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoAmountGenerator;
import lotto.domain.LottoGenerator;

public class Application {
    static int amount;
    static List<Lotto> lottos;


    public static void main(String[] args) {
        amount = LottoAmountGenerator.generateLottoAmount();
        lottos = LottoGenerator.issueLotto(amount);
    }
}
