package lotto.view.Output;

import lotto.domain.LottoList;

public class OutputLottoListView {
  public static void printLottoList(LottoList lottoList) {
    lottoList.getLottolist().forEach(System.out::println);
    System.out.println();
  }
}