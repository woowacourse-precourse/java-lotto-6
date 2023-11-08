package lotto.view;

import lotto.LottoList;

public class OutputLottoList {
    public static void printLottoList(LottoList lottoList) {
        lottoList.getLottoList().forEach(System.out::println);
        System.out.println();
    }
}
