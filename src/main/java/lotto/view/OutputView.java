package lotto.view;

import java.util.List;
import lotto.Lotto;

public class OutputView {
    public void printAllLottoNumbers(List<Lotto> lottos) {
        for(Lotto lotto : lottos) {
            List<Integer> numbers = lotto.getNumbers();
            System.out.println(numbers);
        }
    }
}
