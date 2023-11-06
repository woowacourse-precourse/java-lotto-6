package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {

    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_TEST_PURCHASE = 10000;


    public static void main(String[] args) {
        int numberOfPurchasedLottos = LOTTO_TEST_PURCHASE/LOTTO_PRICE;

        List<Lotto> purchasedLottos = new ArrayList<>();

        for (int i = 0; i < numberOfPurchasedLottos; i++){
            Lotto lotto = Lotto.generate();
            List<Integer> numbers = lotto.getNumbers();
            purchasedLottos.add(lotto);
            System.out.println(numbers);
        }

        List<Integer> winningNumbers = new ArrayList<>();
        int bonusNumber = 0;
        boolean isValidInput = false;

        while (!isValidInput) {
            try {
                System.out.println("당첨 번호를 쉼표로 구분하여 입력하세요.");
                String winningLottoNumbersInput = Console.readLine();

                winningNumbers = Arrays.stream(winningLottoNumbersInput.split(","))
                        .map(String::trim)
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

                validateWinningNumbers(winningNumbers);
                isValidInput = true;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 입력값은 숫자로만 구성되어야 합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        isValidInput = false; // 보너스 번호에 대해 다시 false로 설정

        // 보너스 번호를 올바르게 입력할 때까지 반복
        while (!isValidInput) {
            try {
                System.out.println("보너스 번호를 입력하세요.");
                bonusNumber = Integer.parseInt(Console.readLine().trim());

                validateBonusNumber(bonusNumber, winningNumbers);
                isValidInput = true; // 유효성 검사 통과 시
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 입력값은 숫자로만 구성되어야 합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("입력된 당첨 번호: " + winningNumbers + " + 보너스 번호: " + bonusNumber);
        // 여기서 당첨 번호, 보너스 번호와 구매한 로또 번호들을 비교하는 로직을 구현할 수 있습니다.
    }

    private static void validateWinningNumbers(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }
        if (winningNumbers.stream().anyMatch(num -> num < 1 || num > 45)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        if (winningNumbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복될 수 없습니다.");
        }
    }
    private static void validateBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }
}