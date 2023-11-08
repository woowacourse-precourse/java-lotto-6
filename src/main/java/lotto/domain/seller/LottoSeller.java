package lotto.domain.seller;

import lotto.config.Config;
import lotto.constant.MyConstant;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoEnvelop;

public class LottoSeller {
    private static final Integer PRICE_LOTTO = 1000;
    private LottoEnvelop lottoEnvelop;

    public LottoSeller() {
        this.lottoEnvelop = Config.lottoEnvelop();
    }

    public LottoEnvelop sell(Integer money) {
        makeLottoEnvelope(money);

        return lottoEnvelop;
    }

    public void makeLottoEnvelope(Integer money) {
        Integer sizeLottoEnvelop = getSizeLottoEnvelop(money);
        Lotto lotto = null;

        for (int index = 0; index < sizeLottoEnvelop; index++) {
            lotto = createLotto();
            addLottoEnvelop(lotto);
        }
    }

    public String tellNumberLotto() {
        Integer lottoEnvelopSize = lottoEnvelop.size();
        return MyConstant.MSG_SIZE_LOTTO_ENVELOP(lottoEnvelopSize);
    }

    private Lotto createLotto() {
        return Config.lotto();
    }

    private void addLottoEnvelop(Lotto lotto) {
        lottoEnvelop.add(lotto);
    }

    private int getSizeLottoEnvelop(Integer money) {
        return money / PRICE_LOTTO;
    }
}
