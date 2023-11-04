package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoCollection {
    public List<Lotto> lottoCollection;

    public LottoCollection(int numberOfLotto) {
        this.lottoCollection = new ArrayList<>();
        generateLottoNumbers(numberOfLotto);
    }

    private void generateLottoNumbers(int numberOfLotto) {
        for (int i = 0; i < numberOfLotto; i++) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            lottoCollection.add(lotto);
        }
    }
}
