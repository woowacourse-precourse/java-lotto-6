package lotto.domain;



import java.util.ArrayList;
import java.util.List;
import lotto.generator.LottoMaker;

public class Lottos {

    public static List<Lotto> generateLotto(Money count)  {
            List<Lotto> lottos = new ArrayList<>();
            while(count.checkCount()) {
                Lotto lotto = new Lotto(LottoMaker.generateNumber());
                lottos.add(lotto);
                count.minusCount();
            }
            return lottos;
        }
}
