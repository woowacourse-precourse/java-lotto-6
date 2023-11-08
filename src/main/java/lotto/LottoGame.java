package lotto;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import lib.constant.LottoConstants;

public class LottoGame {
    PrintStream printStream = System.out;
    private List<Lotto> lottos;

    public LottoGame() {
        this.lottos = new ArrayList<Lotto>();
    }
    public List<Lotto> getLottos() {
        return this.lottos;
    }

    private Lotto createLotto() {
        while(true) {
            try {
                List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(LottoConstants.LOTTO_START_RANGE, LottoConstants.LOTTO_END_RANGE, LottoConstants.LOTTO_SIZE);
    
                return new Lotto(lottoNumbers);
            } catch (IllegalArgumentException e) {
                continue;
            }
        }
    }

    public void createLottos() {
        int count = this.price / LottoConstants.LOTTO_PRICE;

        for (int i = 0; i < count; ++i) {
            this.lottos.add(this.createLotto());
        }
    }
}
