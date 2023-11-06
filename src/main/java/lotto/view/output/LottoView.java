package lotto.view.output;

import java.util.List;
import lotto.domain.Lotto;
import lotto.util.constants.OutputConstants;

public class LottoView implements Output {

    private final List<Lotto> lottoTicket;

    public LottoView (List<Lotto> lottoTicket) {
        this.lottoTicket = lottoTicket;
    }

    @Override
    public void getOutput() {
        readLottoTicket(lottoTicket);
    }

    public void readLottoTicket(List<Lotto> lottoTicket) {
        System.out.println(lottoTicket.size() + OutputConstants.LOTTO_COUNT_MESSAGE.getOutputMessage());
        for (Lotto lotto : lottoTicket){
            readLotto(lotto);
        }
    }

    public void readLotto(Lotto lotto) {
        System.out.println(lotto.getNumbers());
    }
}
