package lotto.service;

import java.util.List;
import lotto.domain.Generator;
import lotto.domain.Lotto;

public class LottoService {

    public static void run() {
        Integer tryNum = InteractService.purchasePhase();

        List<Lotto> generateLotto = InteractService.lottoGeneratePhase(tryNum);

        List<Integer> winningNum = InteractService.winningNumPhase();

        Integer bonusNum = InteractService.bonusNumPhase(winningNum);

        List<Integer> result = Generator.generateResult(generateLotto, winningNum, bonusNum);

        InteractService.resultPhase(result, tryNum);

    }
}
