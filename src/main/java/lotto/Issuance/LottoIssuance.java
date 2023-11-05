package lotto.Issuance;

import java.util.List;
import java.util.ArrayList;
import lotto.Lotto;
import lotto.buy.Buy;
import lotto.generator.LottoGenerator;
import lotto.util.io.output.viewer.UserScreen;
import lotto.util.io.output.viewer.Viewer;

public class LottoIssuance {
    private List<Lotto> lottos;
    Viewer output = new UserScreen();
    Buy buy = new Buy(0,0);

    public void Issuance(){
        buy.RequestBuyMoney();
        lottos = LottosGenerator(buy.GetLottoIssuanceNumber());
        buy.PrintLottoIssuanceNumber();
        PrintLottoIssuance();
    }

    private List<Lotto> LottosGenerator(long issuancenumber){
        List<Lotto> lottos = new ArrayList<>();
        for(long i = 0; i<issuancenumber; i++) {
            lottos.add(new Lotto(LottoGenerator.LottoNumberGenerator()));
        }
        return lottos;
    }

    public void PrintLottoIssuance() {
        for(Lotto lotto :lottos) {
            output.ViewPrint(lotto.GetLotto());
        }
        output.ViewPrint();
    }

    public List<Lotto> GetLottos(){
        return lottos;
    }
}
