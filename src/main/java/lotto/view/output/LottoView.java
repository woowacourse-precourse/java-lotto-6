package lotto.view.output;

import java.util.Collections;
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
        int lottoCount = lottoTicket.size();
        System.out.println(OutputConstants.LOTTO_COUNT_MESSAGE.format(lottoCount));
        for (Lotto lotto : lottoTicket){
            readLotto(lotto);

        }
    }

    public void readLotto(Lotto lotto) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        sortLottoNumbers(lottoNumbers);
        System.out.println(lottoNumbers);
    }

    private void sortLottoNumbers(List<Integer> lottoNumbers) {
        Collections.sort(lottoNumbers);
    }
}
