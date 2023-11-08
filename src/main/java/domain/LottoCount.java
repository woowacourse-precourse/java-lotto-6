package domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;

public class LottoCount {

    private int lottoCount;
    private List<Lotto> lotties;

    public LottoCount(int lottoCount) {
        this.lottoCount = lottoCount / 1000;
        setLotties();
    }

    public int getLottoCount() {
        return lottoCount;
    }

    public List<Lotto> getLotties() {
        return lotties;
    }

    private void setLotties() {
        this.lotties = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            this.lotties.add(new Lotto(numbers));
        }
    }

    public void printLottoCount() {
        System.out.println();
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public void printLotties() {
        lotties.stream().forEach(lotto -> {
            List<Integer> numbers = lotto.getNumbers();
            System.out.println(numbers);
        });
        System.out.println();
    }
}
