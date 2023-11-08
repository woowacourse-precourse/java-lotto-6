package lotto.domain;



import java.util.ArrayList;
import java.util.List;
import lotto.util.LottoMaker;
import lotto.view.Output;

public class Lottos {

    public static List<Lotto> generateLotto(Money count)  {
            List<Lotto> lottos = new ArrayList<>();
            while(count.checkCount()) {
                Lotto lotto = new Lotto(LottoMaker.generateNumber());
                lottos.add(lotto);
                Output.consoleLine(lotto.toString());
                count.minusCount();
            }
            return lottos;
        }
}
