package lotto.domain;



import java.util.ArrayList;
import java.util.List;
import lotto.generator.LottoMaker;

public class Lottos {



    public static List<Lotto> generateLotto()  {
            List<Lotto> lottos = new ArrayList<>();
            Lotto lotto = new Lotto(LottoMaker.generateNumber());
            lottos.add(lotto);

            return lottos;
        }


}
