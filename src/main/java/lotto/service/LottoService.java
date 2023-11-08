package lotto.service;

import java.util.Collections;
import java.util.List;
import lotto.domain.Generator;
import lotto.domain.Lotto;

public class LottoService {

    public static void run() {
        Integer tryNum = InteractService.purchasePhase();

        List<Lotto> generateLotto = InteractService.lottoGeneratePhase(tryNum);

        List<Integer> winningNum = InteractService.winningNumPhase();

        Integer bonusNum = InteractService.bonusNumPhase(winningNum);

        List<Integer> result = getResult(generateLotto, winningNum, bonusNum);

        InteractService.resultPhase(result, tryNum);

    }

    private static List<Integer> getResult(List<Lotto> generateLotto, List<Integer> winningNum, Integer bonusNum) {
        List<Integer> result = Generator.generateResult(generateLotto, winningNum, bonusNum);

        return formattingResult(result);
    }

    private static List<Integer> formattingResult(List<Integer> result) {
        result.subList(5, 9);
        Collections.reverse(result);
        return result;
    }
}
