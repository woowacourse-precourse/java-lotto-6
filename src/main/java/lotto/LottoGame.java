package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private static final InputResolver inputResolver = new InputResolver();
    private static final LottoGenerator lottoGenerator = new LottoGenerator();
    private static List<Lotto> lottoList = new ArrayList<>();
    WinningNumber winningNumber;
    public static void play() {
        lottoList = lottoGenerator.buyLotto(inputResolver.inputLottoBuy());
    }
}
