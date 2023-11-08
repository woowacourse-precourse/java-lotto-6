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
        outputHandler.printPurchaseHistory(lottoBundle);

        // 당첨 번호와 보너스 번호 입력
        WinningNumbers winnerNumbers = getWinningNumbers();

        // 당첨 결과를 계산
        Map<LottoRank, Integer> winningResults = lottoService.getWinningResults(lottoBundle, winnerNumbers);
        long totalPrize = lottoService.calculateTotalPrize(winningResults);
        double profitRate = lottoService.calculateProfitRate(totalPrize, purchaseAmount);

        // 당첨 결과를 출력
        outputHandler.printResults(winningResults, profitRate);
    }

    private List<Integer> getNumbers() {
        List<Integer> winningNumbers = new ArrayList<>();
        boolean isValid = false;

        while (!isValid) {
            try {
                String userInput = inputHandler.getWinningNumbersFromUser();
                winningNumbers = getWinningNumbers(userInput);
                isValid = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return winningNumbers;
    }

    private List<Integer> getWinningNumbers(String userInput) {
        return Arrays.stream(userInput.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .sorted()
                .toList();
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

    private WinningNumbers getWinningNumbers() {
        boolean isValid = false;
        WinningNumbers winningNumbers = null;

        while (!isValid) {
            List<Integer> numbers = getNumbers();
            int bonusNumber = inputHandler.getBonusNumberFromUser();
            try {
                winningNumbers = new WinningNumbers(numbers, bonusNumber);
                isValid = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return winningNumbers;
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
