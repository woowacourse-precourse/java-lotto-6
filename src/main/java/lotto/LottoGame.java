package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;

public class LottoGame {

    public static void run() {
        int purchaseAmount = getValidPurchaseAmount();
        System.out.println();
        List<Lotto> lottos = generateLottos(purchaseAmount);
        showLottos(lottos);
        System.out.println();
        List<Integer> winningNumbers = getValidWinningNumbers();
        System.out.println();
        int bonusNumber = getValidBonusNumber(winningNumbers);
    }

    private static int getValidPurchaseAmount() {
        int purchaseAmount = 0;

        do {
            int inputAmount = 0;
            try {
                inputAmount = getPurchaseAmountFromUser();
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 유효한 숫자를 입력해야 합니다.");
                continue; // Restart the loop if there's an exception
            }

            if (inputAmount % 1000 != 0) {
                System.out.println("[ERROR] 1,000원 단위로 입력해야 합니다.");
            } else if (inputAmount == 0) {
                System.out.println("[ERROR] 숫자를 입력해야 합니다.");
            } else {
                purchaseAmount = inputAmount;
            }
        } while (purchaseAmount == 0);

        return purchaseAmount;
    }
    private static int getPurchaseAmountFromUser() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }

    private static List<Lotto> generateLottos(int purchaseAmount) {
        int numberOfLottos = purchaseAmount / 1000;
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < numberOfLottos; i++) {
            List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(numbers);
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }
    private static void showLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        lottos.forEach(lotto -> System.out.println(lotto));
    }

    private static List<Integer> getWinningNumbersFromUser() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        String[] numbers = input.split(",");
        return Arrays.stream(numbers)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
    private static List<Integer> getValidWinningNumbers() {
        while (true) {
            List<Integer> winningNumbers = getWinningNumbersFromUser();
            try {
                validateWinningNumbers(winningNumbers);
                return winningNumbers;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    private static void validateWinningNumbers(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자를 입력해야 합니다.");
        }
        for (int num : winningNumbers) {
            if (num < 1 || num > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
        if (winningNumbers.size() != winningNumbers.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 중복되지 않는 숫자 6개여야 합니다.");
        }
        if (winningNumbers.contains(0)) {
            throw new IllegalArgumentException("[ERROR] 0은 유효한 로또 번호가 아닙니다.");
        }
    }

    private static int getBonusNumberFromUser() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }
    private static void validateBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복되면 안 됩니다.");
        }
    }
    private static int getValidBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            int bonusNumber = getBonusNumberFromUser();
            try {
                validateBonusNumber(bonusNumber, winningNumbers);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
