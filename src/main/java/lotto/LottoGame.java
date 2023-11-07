package lotto;

import java.util.*;

public class LottoGame {
    private static final InputResolver inputResolver = new InputResolver();
    private static final LottoGenerator lottoGenerator = new LottoGenerator();
    private static List<Lotto> lottoList = new ArrayList<>();
    private static List<Integer> winningNumber = new ArrayList<>();
    private static Map<LottoWinningSpec, Integer> winningResult = new HashMap<>();
    public static void play() {
        lottoList = lottoGenerator.buyLotto(inputResolver.inputLottoBuy());
        winningNumber = inputResolver.inputWinningNumber();
        checkLottoResult(lottoList);
        System.out.println(winningResult);
    }

    private static void checkLottoResult(List<Lotto> lottoList) {
        for (Lotto lotto: lottoList) {
            Optional<LottoWinningSpec> optionalWinNumber = checkWinningNumber(lotto);
            if (optionalWinNumber.isPresent()) {
                LottoWinningSpec winningSpec = optionalWinNumber.get();
                setInitLottoResult(winningSpec);
                int winCount = winningResult.get(winningSpec);
                winningResult.put(winningSpec, ++winCount);
            }
        }
    }

    private static void setInitLottoResult(LottoWinningSpec winningSpec) {
        if (Optional.ofNullable(winningResult.get(winningSpec)).isEmpty()) {
            winningResult.put(winningSpec, 0);
        }
    }

    private static Optional<LottoWinningSpec> checkWinningNumber(Lotto lotto) {
        int count = 0;
        for (Integer winNumber : lotto.getNumbers()) {
            if (winningNumber.contains(winNumber)) {
                count++;
            }
        }
        return LottoWinningSpec.getRankByMatchingCount(count);
    }
}
