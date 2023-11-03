package lotto.View;

import java.util.Arrays;
import java.util.List;
import lotto.Model.Lotto;
import lotto.Model.RandomLotto;

public class OutputView {

    public static void printLottoPurChaseMessage(RandomLotto randomLotto) {
        System.out.println();
        System.out.println(randomLotto.getCount() + "개를 구매했습니다.");
    }

    public static void printRandomLottoNumbers(Lotto lotto) {
        System.out.println(lotto.toString());
    }
}





