package lotto;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.WinLotto;
import lotto.util.GenerationUtil;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            List<Lotto> generatedLottos = GenerationUtil.generateLottos(InputView.getGeneratedLottoCount());

            WinLotto winLotto = new WinLotto(InputView.getWinLottoNumbers(), InputView.getWinBonusNumber());

            OutputView.showStatistics(generatedLottos, winLotto);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
