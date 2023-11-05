package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.LongUnaryOperator;
import java.util.stream.Collectors;

public class LottoGame {
    private List<Integer> winningNumbers;
    private int bonusNumber;

    public LottoGame() {

    }

    public void startGame() {
        int purchaseAmount = getPurchaseAmount();
        this.winningNumbers = inputWinningNumbers();
        this.bonusNumber = inputBonusNumber();

        ArrayList<Lotto> lottos = LottoMachine.buyLotto(purchaseAmount);
        System.out.println(lottos.size() + "개를 구매했습니다.");

        lottos.forEach(Lotto::printNumbers);

    }

    public int getPurchaseAmount() {
        System.out.println("구매 금액을 입력해 주세요.");
        int purchaseAmount = Integer.parseInt(Console.readLine());
        validateAmount(purchaseAmount);

        return purchaseAmount;
    }

    private void validateAmount(int purchaseAmount) {

        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1,000원 단위로 입력해 주세요.");
        }
    }

    public List<Integer> inputWinningNumbers() {
        List<Integer> winningNumbers;
        System.out.println("당첨 번호를 입력해 주세요.");
        winningNumbers = Arrays.stream(Console.readLine().split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        validateWinningNumbers(winningNumbers);

        return winningNumbers;
    }

    private void validateWinningNumbers(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자를 입력해 주세요.");
        }

        boolean areNumbersInRange = winningNumbers.stream()
                .anyMatch(number -> 1 <= number && 45 >= number);
        if (!areNumbersInRange) {
            throw new IllegalArgumentException("[ERROR] 1~45 사이의 숫자만 입력이 가능합니다.");
        }

        boolean areNumbersUnique = winningNumbers.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .values()
                .stream()
                .anyMatch(count -> count <= 1);
        if (!areNumbersUnique) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호에 중복된 숫자가 있습니다.");
        }
    }

    public int inputBonusNumber() {
        int bonusNumber;
        System.out.println("보너스 번호를 입력해 주세요.");
        bonusNumber = Integer.parseInt(Console.readLine());
        validateBonusNumber(bonusNumber);
        return bonusNumber;
    }

    private void validateBonusNumber(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 1~45 사이의 숫자만 입력이 가능합니다.");
        }

        this.winningNumbers.forEach((winningNumber) -> {
            if (winningNumber == bonusNumber) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호에 중복된 숫자가 있습니다.");
            }
        });

    }

}
