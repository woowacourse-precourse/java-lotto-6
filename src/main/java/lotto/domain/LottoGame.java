package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.message.Result;
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
        buyLottoBundle(purchaseAmount, lottoBundle);

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
        LottoService lottoService = new LottoService();
        lottoService.compareAll(lottoBundle, winnerNumbers, bonusNumber);
        long profit = lottoService.getProfit();
        double profitRate = profit / (double) purchaseAmount * 100;

        printResults(lottoService, profitRate);

    }

    private void printResults(LottoService lottoService, double profitRate) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.printf(Result.FIFTH_PLACE.getMessage() + "%n", lottoService.getNumOfFifthPlace());
        System.out.printf(Result.FOURTH_PLACE.getMessage() + "%n", lottoService.getNumOfFourthPlace());
        System.out.printf(Result.THIRD_PLACE.getMessage() + "%n", lottoService.getNumOfThirdPlace());
        System.out.printf(Result.SECOND_PLACE.getMessage() + "%n", lottoService.getNumOfSecondPlace());
        System.out.printf(Result.FIRST_PLACE.getMessage() + "%n", lottoService.getNumOfFirstPlace());
        System.out.printf(Result.TOTAL_PROFIT_RATE.getMessage() + "%n", profitRate);
    }

    private void buyLottoBundle(int purchaseAmount, List<Lotto> lottoBundle) {
        int temp = purchaseAmount;
        while (temp != 0) {
            temp -= 1000;
            List<Integer> numbers = new ArrayList<>(generateNumbers());
            Collections.sort(numbers);
            lottoBundle.add(new Lotto(numbers));
        }
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
