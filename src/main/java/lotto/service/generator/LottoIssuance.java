package lotto.service.generator;

import java.util.ArrayList;
import java.util.List;
import lotto.Controller.PrintScreen;
import lotto.Controller.Request;
import lotto.Lotto;
import lotto.vo.buy.LottoBuy;
import lotto.vo.issuanced.LottosNumber;

public class LottoIssuance {
    Request request = new Request();
    PrintScreen print = new PrintScreen();

    public void Issuance() {
        request.RequestBuyMoney();
        LottosNumber.SetLottos(LottosGenerator(LottoBuy.GetLottoIssuanceNumber()));
        print.PrintLottoIssuanceNumber();
    }

    private List<Lotto> LottosGenerator(long issuancenumber) {
        List<Lotto> lottos = new ArrayList<>();
        for (long i = 0; i < issuancenumber; i++) {
            lottos.add(new Lotto(LottoGenerator.LottoNumberGenerator()));
        }
        return lottos;
    }
}
