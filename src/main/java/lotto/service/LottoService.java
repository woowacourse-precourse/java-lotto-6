package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.util.Converter;

public class LottoService {
    private final List<Lotto> lottos = new ArrayList<>();
    private int purchaseAmount;

    public void buyLotto(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
        int numberOfLottos = purchaseAmount/1000;
        generateLotto(numberOfLottos);
    }

    private void generateLotto(int numberOfLottos) {
        List<Integer> lottoNumbers;
        for (int i = 0; i < numberOfLottos; i++) {
            lottoNumbers = createLottoNumbers();
            lottos.add(new Lotto(lottoNumbers));
        }
    }

    private List<Integer> createLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
