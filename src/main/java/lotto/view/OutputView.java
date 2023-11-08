package lotto.view;

import java.util.Collections;
import java.util.List;
import lotto.domain.Lotto;

public class OutputView {
    public static void printLottoTickets(List<Lotto> lottoTickets) {
        System.out.println(lottoTickets.size() + "개를 구매했습니다.");
        lottoTickets.forEach(OutputView::printLotto);
    }

    public static void printLotto(Lotto lotto) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        Collections.sort(lottoNumbers);
        System.out.println(lottoNumbers);
    }
}
