package lotto;

import java.util.List;

public class LottoGameController {

    public Lottos purchaseLotto(long buyCash){
        LottoService service=new LottoService();
        long buyAmount= service.getLottoAmount(buyCash);

        List<Lotto> lottos=LottoGenerator.INSTANCE.generate((int)buyAmount);

        return new Lottos(lottos);
    }
}
