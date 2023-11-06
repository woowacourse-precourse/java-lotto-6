package lotto.view;

import lotto.domain.Lottos;

public class OutputView {

    public static void showBayLottoCount(int lottoCount) {
        System.out.println(String.valueOf(lottoCount) + "개를 구매했습니다.");
    }


    public static void showBayLottoNumber(Lottos lottos) {
        lottos.getLottos().forEach(System.out::println);
    }
}