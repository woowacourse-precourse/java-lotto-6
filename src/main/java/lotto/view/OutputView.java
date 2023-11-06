package lotto.view;

import java.util.List;
import lotto.domain.Lotto;

public class OutputView {
    public final String OUTPUT_LOTTO_NUMBERS = "\n%d개를 구매했습니다.\n";
    public final String OUTPUT_START_NUMBERS = "[";
    public final String OUTPUT_FINISH_NUMBERS = "]";
    public final String OUTPUT_SPLIT_STRING= ", ";


    public void printLottoNumbers(List<Lotto> lottos) {
        System.out.printf(OUTPUT_LOTTO_NUMBERS, lottos.size());
        for (Lotto lotto : lottos) {
            printNumbers(lotto.getNumbers());
        }
    }

    public void printNumbers(List<Integer> numbers) {
        System.out.print(OUTPUT_START_NUMBERS + numbers.get(0));
        for (int i = 1; i < 6; i++) {
            System.out.println(OUTPUT_SPLIT_STRING + numbers.get(i));
        }
        System.out.println(OUTPUT_FINISH_NUMBERS);
    }
}
