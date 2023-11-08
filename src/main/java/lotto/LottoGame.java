package lotto;

import java.util.*;

public class LottoGame {
    private static int buyMoney;
    private static final InputResolver inputResolver = new InputResolver();
    private static final LottoGenerator lottoGenerator = new LottoGenerator();
    private static List<Lotto> lottoList = new ArrayList<>();
    private static LottoWinningNumber lottoWinningNumber;
    private static Map<LottoWinningSpec, Integer> winningResult = new HashMap<>();
    public static void play() {
        buyMoney = inputResolver.inputLottoBuy();
        lottoList = lottoGenerator.buyLotto(buyMoney);
        List<Integer> winningNumber = inputResolver.inputWinningNumber();
        lottoWinningNumber = new LottoWinningNumber(winningNumber, inputResolver.inputBonusNumber(winningNumber));
        checkLottoResult(lottoList);
        printResult();
    }

    private static void checkLottoResult(List<Lotto> lottoList) {
        setInitLottoResult();
        for (Lotto lotto: lottoList) {
            Optional<LottoWinningSpec> optionalWinNumber = checkWinningNumber(lotto);
            if (optionalWinNumber.isPresent()) {
                LottoWinningSpec winningSpec = optionalWinNumber.get();
                int winCount = winningResult.get(winningSpec);
                winningResult.put(winningSpec, ++winCount);
            }
        }
    }

    private static void setInitLottoResult() {
        for (LottoWinningSpec prize: LottoWinningSpec.values()) {
            if (Optional.ofNullable(winningResult.get(prize)).isEmpty()) {
                winningResult.put(prize, 0);
            }
        }
    }

    private static Optional<LottoWinningSpec> checkWinningNumber(Lotto lotto) {
        int count = 0;
        boolean isBonus = false;
        for (Integer winNumber : lotto.getNumbers()) {
            if (lottoWinningNumber.getWinningNumber().contains(winNumber)) {
                count++;
            }
            if (lottoWinningNumber.getBonusNumber() == winNumber) {
                isBonus = true;
            }
        }
        if (count == 5 && isBonus) {
            return Optional.of(LottoWinningSpec.SECOND_PRIZE);
        }
        return LottoWinningSpec.getRankByMatchingCount(count);
    }

    private static void printResult() {
        int sum = 0;
        System.out.println("당첨통계 \n---");
        for (LottoWinningSpec prize :LottoWinningSpec.values()) {
            System.out.println(prize.getWinInformation() + " - " + winningResult.get(prize) + "개");
            sum += prize.getPrizeMoney() * winningResult.get(prize);
        }
        System.out.println("총 수익률은 " + String.format("%.2f", (double)sum / buyMoney * 100) + "%입니다.");
    }
}
