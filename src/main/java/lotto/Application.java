package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final int PRICE_LOTTO = 1000;

    public static void main(String[] args) {
        int purchaseAmount = getValidatedPurchaseAmount();
        List<Lotto> lottos = buyLottos(purchaseAmount);
        printLottos(lottos);

        List<Integer> winningNumbers = getValidatedWinningNumbers();
        int bonusNumber = getValidatedBonusNumber();

        calculateAndPrintResult(lottos, winningNumbers, bonusNumber);
    }

    private static int getValidatedPurchaseAmount() {
        while (true) {
            try {
                System.out.println("구입 금액을 입력해 주세요.");
                int purchaseAmount = Integer.parseInt(Console.readLine());
                validatePurchaseAmount(purchaseAmount);
                return purchaseAmount;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자를 입력해 주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

    private static void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount % PRICE_LOTTO != 0) {
            throw new IllegalArgumentException("구입 금액은 1000의 배수여야 합니다.");
        }
    }

    private static List<Lotto> buyLottos(int purchaseAmount) {
        int numberOfLottos = purchaseAmount / PRICE_LOTTO;
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < numberOfLottos; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }
        return lottos;
    }

    private static void printLottos(List<Lotto> lottos) {
        System.out.println();
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    private static List<Integer> getValidatedWinningNumbers() {
        while (true) {
            try {
                System.out.println();
                System.out.println("당첨 번호를 입력해 주세요.");
                List<Integer> winningNumbers = parseNumbers(Console.readLine());
                validateWinningNumbers(winningNumbers);
                return winningNumbers;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자를 입력해 주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

    private static void validateWinningNumbers(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("당첨 번호는 6개를 입력해야 합니다.");
        }
    }

    private static List<Integer> parseNumbers(String input) {
        String[] inputNumbers = input.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String number : inputNumbers) {
            int num = Integer.parseInt(number);
            validateLottoNumber(num);
            numbers.add(num);
        }
        return numbers;
    }

    private static void validateLottoNumber(int num) {
        if (num < 1 || num > 45) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자만 입력해야 합니다.");
        }
    }

    private static int getValidatedBonusNumber() {
        while (true) {
            try {
                System.out.println();
                System.out.println("보너스 번호를 입력해 주세요.");
                int bonusNumber = Integer.parseInt(Console.readLine());
                validateBonusNumber(bonusNumber);
                return bonusNumber;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자를 입력해 주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

    private static void validateBonusNumber(int bonusNumber) {
        validateLottoNumber(bonusNumber);
    }

    private static void calculateAndPrintResult(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        Result result = new Result();
        for (Lotto lotto : lottos) {
            int matched = lotto.matchNumbers(winningNumbers);
            boolean hasBonusNumber = lotto.containsBonusNumber(bonusNumber);

            result.add(matched, hasBonusNumber);
        }
        result.printResult();
    }
}