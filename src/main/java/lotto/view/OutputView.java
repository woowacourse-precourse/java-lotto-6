package lotto.view;

import lotto.Lotto;

public class OutputView {

    public static void showBayLottoCount(int lottoCount) {
        System.out.println(String.valueOf(lottoCount) + "개를 구매했습니다.");
    }


    public static void showBayLottoNumber(Lotto lotto) {
        System.out.println(lotto.getNumbers().toString());
    }
}