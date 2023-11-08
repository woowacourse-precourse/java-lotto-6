package lotto.global;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Publish {
    private final static int BASE_UNIT = 1000;
    private static final int LOTTO_COUNT = 6;
    private static final int LOTTO_RANGE_MIN = 1;
    private static final int LOTTO_RANGE_MAX = 45;

    public int getLottoCount(int money) {
        return money / BASE_UNIT;
    }

    public List<Lotto> getIssuedLottos(int lottoCount) {
        List<Lotto> issuedLottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> lottoNumbers = new ArrayList<>(
                    getRandomNumber()
            );
            Collections.sort(lottoNumbers);
            Lotto lotto = new Lotto(lottoNumbers);
            issuedLottos.add(lotto);
        }
        return issuedLottos;
    }

    private List<Integer> getRandomNumber() {
        return Randoms.pickUniqueNumbersInRange(
                LOTTO_RANGE_MIN, LOTTO_RANGE_MAX, LOTTO_COUNT
        );
    }

    public void printIssuedLottoCountAndNumbers(List<Lotto> issuedLottos) {
        int lottoCount = issuedLottos.size();
        System.out.println("\n" + lottoCount + "개를 구매했습니다.");

        for (Lotto lotto : issuedLottos) {
            lotto.printLottoNumbers();
        }
    }
}
