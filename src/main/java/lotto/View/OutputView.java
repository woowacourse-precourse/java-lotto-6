package lotto.View;

import lotto.Model.RandomLotto;

public class OutputView {

    public static void printLottoPurChaseMessage(RandomLotto randomLotto) {
        System.out.println();
        System.out.println(randomLotto.getCount() + "개를 구매했습니다.");
    }

    public static void printRandomLottoNumbers(RandomLotto randomLotto) {
        randomLotto.getRandomLottos().forEach(System.out::println);
    }
}





