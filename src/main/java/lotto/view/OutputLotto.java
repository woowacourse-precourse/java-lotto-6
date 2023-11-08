package lotto.view;

import lotto.model.Lotto;
import java.util.List;

public class OutputLotto {

    public static void printLottoList(List<Lotto> lottoList) {
        System.out.println("\n" + lottoList.size() + "개를 구매했습니다.");

        for (Lotto lotto : lottoList) {
            printLotto(lotto);
        }

    }

    //[8, 21, 23, 41, 42, 43] 형식으로 출력
    public static void printLotto(Lotto lotto) {
        System.out.println(lotto.getNumbers());
    }

}
