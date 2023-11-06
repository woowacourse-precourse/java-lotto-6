package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoCollection {
    public List<Lotto> lottoCollection;
    private final int numberOfLotto;

    public LottoCollection(int numberOfLotto) {
        this.numberOfLotto = numberOfLotto;
        this.lottoCollection = new ArrayList<>();
        generateLottoNumbers(numberOfLotto);
    }

    private void generateLottoNumbers(int numberOfLotto) {
        for (int i = 0; i < numberOfLotto; i++) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            lottoCollection.add(lotto);
        }
    }

    public void printLottoNumbers() {
        System.out.println(numberOfLotto + "개를 구매했습니다.");
        for (Lotto lotto : lottoCollection) {
            lotto.printLottoNumbers();
        }
    }

    public void matchLottoNumbers(LottoResult result) {
        int matchingCount = 0;
        boolean matchingBonusCount = false;
        for (Lotto lotto : lottoCollection) {
            matchingCount = lotto.countMatchingLottoNumbers(result);
            matchingBonusCount = lotto.hasBonusNumber(result);
        }
    }
}
