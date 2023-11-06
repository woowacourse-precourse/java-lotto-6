package lotto.output;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.Lotto;

public class GeneratedLottoOutput {
    private final List<Lotto> lottos;

    private final Integer lottoNumber;

    public GeneratedLottoOutput(List<Lotto> lottos) {
        this.lottos = lottos;
        this.lottoNumber = lottos.size();
    }

    public void printGeneratedLottos() {
        printPhrasedLotto(lottoNumber);
        for (Lotto lotto : lottos) {
            List<Integer> numbers = new ArrayList<>(lotto.getNumbers());
            Collections.sort(numbers);
            System.out.println(numbers);
        }
    }

    public static void printPhrasedLotto(Integer count) {
        System.out.println(count + "개를 구매했습니다.");
    }
}
