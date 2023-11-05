package lotto.service;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class LottoService {

    private static final int startNumber = 1;
    private static final int endNumber = 45;
    private static final int lottoNumberCount = 6;

    private List<Lotto> purchaseLotto = new ArrayList<>();
    private Lotto winLotto;

    public void repeatPurchase(int lottoCount) {
        for (int count = 0; count < lottoCount; count++) {
            generateLotto();
        }
    }

    public List<Lotto> getPurchaseLotto() {
        return this.purchaseLotto;
    }

    private void generateLotto() {

        Lotto lotto = new Lotto(pickUniqueNumbersInRange(startNumber, endNumber, lottoNumberCount));

        purchaseLotto.add(lotto);
    }

    public void setWinLotto(List<Integer> winLottoNumbers) {

        winLotto = new Lotto(winLottoNumbers);

    }
}
