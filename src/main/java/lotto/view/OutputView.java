package lotto.view;

import java.util.List;
import lotto.domain.Lotto;
import lotto.repository.LottoRepository;

public class OutputView {
    public static void printLottos() {
        StringBuilder sb = new StringBuilder();
        List<Lotto> lottos = LottoRepository.getLottos();

        sb.append('\n').append(lottos.size() + "개를 구매했습니다.\n");
        for (int i = 0; i < lottos.size(); i++) {
            Lotto lotto = lottos.get(i);
            sb.append(lotto).append('\n');
        }
        System.out.print(sb);
    }

}
