package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

import static lotto.Constant.*;

public class LottoController {

    private final LottoView lottoView;
    private final LottoService lottoService;

    public LottoController(LottoView lottoView, LottoService lottoService) {
        this.lottoView = lottoView;
        this.lottoService = lottoService;
    }

    public void start() {

        int purchaseAmount = getPurchaseAmount();
        List<Lotto> purchasedLottos = lottoService.generateLottos(purchaseAmount);
        lottoView.displayPurchasedLottos(purchasedLottos);
        List<Integer> winnerNums = getWinnerNums();
        int bonusNum = getBonusNum(winnerNums);

        List<Integer> results = lottoService.getResults(purchasedLottos, winnerNums, bonusNum);
        double earningRate = lottoService.calculateEarningRate(results, purchaseAmount);
        lottoView.printResult(results, earningRate);
    }

    private int getPurchaseAmount() {
        while(true) {
            try {
                lottoView.displayPurchaseAmountInputMessage();
                int purchaseAmount = Integer.parseInt(Console.readLine());
                validatePurchaseAmount(purchaseAmount);
                return purchaseAmount;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] = " + e);
            }
        }
    }

    private void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount <= 0) {
            throw new IllegalArgumentException("구매 금액은 0보다 큰 값을 입력해야 합니다.");
        }
    }

    private int getBonusNum(List<Integer> winnerNums) {
        while (true) {
            try {
                lottoView.displayBonusNumInputMessage();
                String inputBonusNum = Console.readLine();
                int bonusNum =  Integer.parseInt(inputBonusNum);
                validateBonusNum(bonusNum, winnerNums);
                return bonusNum;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] = " + e);
            }
        }
    }

    private void validateBonusNum(int bonusNum, List<Integer> winnerNums) {
        validateNumRange(bonusNum);
        if (winnerNums.stream().anyMatch(num -> num == bonusNum)) {
            throw new IllegalArgumentException("보너스 번호는 결과 번호와 같을 수 없습니다.");
        }
    }

    private List<Integer> getWinnerNums() {
        while (true) {
            try {
                lottoView.displayWinnerNumsInputMessage();
                String inputWinnerNums = Console.readLine();
                List<Integer> winnerNums = Arrays.stream(inputWinnerNums.split(",")).map(Integer::parseInt).toList();
                validateWinnerNums(winnerNums);
                return winnerNums;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] = " + e);
            }
        }
    }

    private void validateWinnerNums(List<Integer> winnerNums) {
        if (winnerNums.stream().distinct().toList().size() != LOTTO_NUM_COUNT) {
            throw new IllegalArgumentException("당첨 번호는 쉼표로 구분하여 6자리를 입력해야 합니다.");
        }
        for (Integer winnerNum : winnerNums) {
            validateNumRange(winnerNum);
        }
    }

    private void validateNumRange(int bonusNum) {
        if (bonusNum < MIN_NUM || bonusNum > MAX_NUM) {
            throw new IllegalArgumentException("로또 번호의 숫자 범위는 1~45 입니다.");
        }
    }
}
