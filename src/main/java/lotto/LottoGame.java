package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private static final InputResolver inputResolver = new InputResolver();
    private static final LottoGenerator lottoGenerator = new LottoGenerator();
    private static List<Lotto> lottoList = new ArrayList<>();
    private static List<Integer> winningNumber = new ArrayList<>();
    public static void play() {
        lottoList = lottoGenerator.buyLotto(inputResolver.inputLottoBuy());
        winningNumber = inputResolver.inputWinningNumber();
    }
}
