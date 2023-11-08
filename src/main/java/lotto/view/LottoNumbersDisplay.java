package lotto.view;

import lotto.domain.Lotto;
import java.util.List;

/* 유저가 구매한 로또들의 목록을 출력 */
public class LottoNumbersDisplay {
    public static void displayAllLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            displayLotto(lotto.getLottoNumbers());
        }
        System.out.print("\n");
    }
    public static void displayLotto(List<Integer> numbers) {
        String string = "[";
        for (int i = 0; i < numbers.size(); ++i) {
            string += numbers.get(i);
            if (i != numbers.size() - 1) {
                string += ",";
            }
        }
        string += "]";
        System.out.println(string);
    }
}
