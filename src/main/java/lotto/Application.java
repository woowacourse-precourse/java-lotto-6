package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        int PRICE_LOTTO = 1000;

        int purchaseAmount = getPurchaseAmount();
        int numberOfLottos = purchaseAmount / PRICE_LOTTO;

        List<Lotto> lottos = buyLottos(numberOfLottos);
        printLottos(lottos);

        List<Integer> winningNumbers = getWinningNumbers();
        int bonusNumber = getBonusNumber();

        calculateAndPrintResult(lottos, winningNumbers, bonusNumber);
    }

    private static int getPurchaseAmount() {
        while (true) {
            try {
                System.out.println("구입 금액을 입력해 주세요.");
                int purchaseAmount = Integer.parseInt(Console.readLine());
                if (purchaseAmount % 1000 != 0) {
                    throw new IllegalArgumentException("구입 금액은 1000의 배수여야 합니다.");
                }
                return purchaseAmount;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자를 입력해 주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

    private static List<Lotto> buyLottos(int numberOfLottos) {
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

    private static List<Integer> getWinningNumbers() {
        while (true) {
            try {
                System.out.println();
                System.out.println("당첨 번호를 입력해 주세요.");
                List<Integer> winningNumbers = parseNumbers(Console.readLine());
                if (winningNumbers.size() != 6 || winningNumbers.size() > 6) {
                    throw new IllegalArgumentException("당첨 번호는 6개를 입력해야 합니다.");
                }
                return winningNumbers;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자를 입력해 주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

    private static List<Integer> parseNumbers(String input) {
        String[] inputNumbers = input.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String number : inputNumbers) {
            int num = Integer.parseInt(number);
            if (num > 45) {
                throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
            numbers.add(num);
        }
        return numbers;
    }

    private static int getBonusNumber() {
        while (true) {
            try {
                System.out.println();
                System.out.println("보너스 번호를 입력해 주세요.");
                return Integer.parseInt(Console.readLine());
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자를 입력해 주세요.");
            }
        }
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
