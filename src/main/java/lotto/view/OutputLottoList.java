package lotto.view;

import lotto.domain.LottoGroup;

public class OutputLottoList {
    public static void printLottoList(LottoGroup lottoGroup) {
        lottoGroup.getLottoGroup().forEach(System.out::println);
        System.out.println();
    }
}
