package View;

import java.util.List;
import lotto.Lotto;
import lotto.Lottos;

public class OuputView {
    public void printUserLottoNumbers(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        lottos.forEach(lotto -> System.out.println(lotto.getSortedNumbers()));
    }
}
