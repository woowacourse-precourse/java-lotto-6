package lotto.View;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;

import java.util.List;

public class OutputView {

    public static void PrintUserLottoTickets(List<Lotto> lottoList) {
        lottoList.forEach(i -> System.out.println(i.getSortLottoNumber()));
    }

}
