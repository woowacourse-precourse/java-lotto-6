package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.message.Result;
import lotto.ui.InputHandler;
import lotto.ui.OutputHandler;

import java.util.*;

public class LottoGame {

    private final static int LOTTO_START_NUMBER_INCLUSIVE = 1;
    private final static int LOTTO_END_NUMBER_INCLUSIVE = 45;
    private final static int LOTTO_TOTAL_NUMBERS = 6;

    private final OutputHandler outputHandler = new OutputHandler();
    private final InputHandler inputHandler = new InputHandler(this.outputHandler);
    private final LottoService lottoService = new LottoService();

    public void run () {
        // 유저로 부터 구입 금액을 입력 받는다
        int purchaseAmount = getPurchaseAmount();

        // 로또 구매
        List<Lotto> lottoBundle = buyLottoBundle(purchaseAmount);

        // 구매 결과를 출력
        printPurchaseHistory(lottoBundle);

        // 당첨 번호와 보너스 번호 입력
        WinningNumbers winnerNumbers = getWinningNumbers();

        // 당첨 결과를 계산
        Map<LottoRank, Integer> winningResults = lottoService.getWinningResults(lottoBundle, winnerNumbers);
        long totalPrize = lottoService.calculateTotalPrize(winningResults);
        double profitRate = lottoService.calculateProfitRate(totalPrize, purchaseAmount);

        // 당첨 결과를 출력
        printResults(winningResults, profitRate);

    }

    private WinningNumbers getWinningNumbers() {
        List<Integer> numbers = getNumbers();
        int bonusNumber = inputHandler.getBonusNumberFromUser();

        return new WinningNumbers(numbers, bonusNumber);
    }

    private List<Integer> getNumbers() {
        try {
            String userInput = inputHandler.getWinningNumbersFromUser();
            return Arrays.stream(userInput.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .sorted()
                    .toList();
        } catch (IllegalArgumentException e) {
            return getNumbers();
        }
    }

    public void printPurchaseHistory(List<Lotto> lottoBundle) {
        System.out.println(lottoBundle.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottoBundle) {
            System.out.println(lotto.toString());
        }
    }

    private void printResults(Map<LottoRank, Integer> winningResults, double profitRate) {
        System.out.printf(Result.FIFTH_PLACE.getMessage() + "%n", winningResults.get(LottoRank.FIFTH_PLACE));
        System.out.printf(Result.FOURTH_PLACE.getMessage() + "%n", winningResults.get(LottoRank.FOURTH_PLACE));
        System.out.printf(Result.THIRD_PLACE.getMessage() + "%n", winningResults.get(LottoRank.THIRD_PLACE));
        System.out.printf(Result.SECOND_PLACE.getMessage() + "%n", winningResults.get(LottoRank.SECOND_PLACE));
        System.out.printf(Result.FIRST_PLACE.getMessage() + "%n", winningResults.get(LottoRank.FIRST_PLACE));
        System.out.printf(Result.TOTAL_PROFIT_RATE.getMessage() + "%n", profitRate);
    }

    private List<Lotto> buyLottoBundle(int purchaseAmount) {
        List<Lotto> lottoBundle = new ArrayList<>();
        int lottoCount = lottoService.calculateLottoCount(purchaseAmount);

        for (int i = 0; i < lottoCount; i++) {
            List<Integer> numbers = new ArrayList<>(generateNumbers());
            Collections.sort(numbers);
            lottoBundle.add(new Lotto(numbers));
        }
        return lottoBundle;
    }

    private List<Integer> generateNumbers() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_START_NUMBER_INCLUSIVE, LOTTO_END_NUMBER_INCLUSIVE, LOTTO_TOTAL_NUMBERS);
    }

    private int getPurchaseAmount() {
        try {
            return inputHandler.getValidPurchaseAmountFromUser();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getPurchaseAmount();
        }
    }
}
