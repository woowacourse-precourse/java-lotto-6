package lotto.global;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Publish {
    public int getLottoCount(int money) {
        return money / 1000;
    }

    public List<Lotto> getIssuedLottos(int lottoCount) {
        List<Lotto> issuedLottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> lottoNumbers = getRandomNumber();
            Collections.sort(lottoNumbers);
            Lotto lotto = new Lotto(lottoNumbers);
            issuedLottos.add(lotto);
        }
        return issuedLottos;
    }

    private List<Integer> getRandomNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public void printIssuedLottoCountAndNumbers(List<Lotto> issuedLottos) {
        int lottoCount = issuedLottos.size();
        System.out.println("\n" + lottoCount + "개를 구매했습니다.");

        for (Lotto lotto : issuedLottos) {
            lotto.printLottoNumbers();
        }
    }
}
