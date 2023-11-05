package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Comparator;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.ui.InputHandler;
import lotto.ui.OutputHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LottoGame {

    private final OutputHandler outputHandler = new OutputHandler();
    private final InputHandler inputHandler = new InputHandler(this.outputHandler);

    public void run () {
        int purchaseAmount = getPurchaseAmount();
        List<Lotto> lottoBundle = new ArrayList<>();
        int temp = purchaseAmount;
        while (temp != 0) {
            temp -= 1000;
            List<Integer> numbers = new ArrayList<>(generateNumbers());
            Collections.sort(numbers);
            lottoBundle.add(new Lotto(numbers));
        }
        System.out.println(lottoBundle.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottoBundle) {
            System.out.println(lotto.toString());
        }
        String userInput = inputHandler.getWinnerNumbers();
        List<Integer> winnerNumbers = Arrays.stream(userInput.split(","))
                .map(Integer::parseInt)
                .sorted() // 오름차순으로 정렬
                .toList(); // 리스트로 수집

        int bonusNumber = inputHandler.getBonusNumber();
        System.out.println("당첨 통계");
        System.out.println("---");
        Comparator comparator = new Comparator();
        comparator.compare(lottoBundle, winnerNumbers, bonusNumber);
        long profit = comparator.getProfit();
        double profitRate = profit / (double) purchaseAmount * 100;
        System.out.printf(LottoRank.FIFTH_PLACE.getRankFormat() + "%n", comparator.getNumOfFifthPlace());
        System.out.printf(LottoRank.FOURTH_PLACE.getRankFormat() + "%n", comparator.getNumOfFourthPlace());
        System.out.printf(LottoRank.THIRD_PLACE.getRankFormat() + "%n", comparator.getNumOfThirdPlace());
        System.out.printf(LottoRank.SECOND_PLACE.getRankFormat() + "%n", comparator.getNumOfSecondPlace());
        System.out.printf(LottoRank.FIRST_PLACE.getRankFormat() + "%n", comparator.getNumOfFirstPlace());
        System.out.printf(LottoRank.TOTAL.getRankFormat() + "%n", profitRate);

    }

    private List<Integer> generateNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    private int getPurchaseAmount() {
        try {
            return inputHandler.getValidPurchaseAmount();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getPurchaseAmount();
        }
    }
}
