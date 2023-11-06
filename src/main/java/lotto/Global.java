package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Global {
    private List<Lotto> issuedLottos;

    public Global() {
        this.issuedLottos = new ArrayList<>();
    }

    public int getLottoCount(int money) {
        return money / 1000;
    }

    public List<Lotto> getIssuedLottos(int lottoCount) {
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

    public void printIssuedLottoCountAndNumbers() {
        int lottoCount = issuedLottos.size();
        System.out.println("\n" + lottoCount + "개를 구매했습니다.");

        for (Lotto lotto : issuedLottos) {
            lotto.printLottoNumbers();
        }
    }
}
