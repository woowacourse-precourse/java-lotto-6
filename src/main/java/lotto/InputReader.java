package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputReader {
    public static int askPurchaseMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        while (true) {
            String purchaseMoney = Console.readLine();
            if (!isPurchaseMoneyInteger(purchaseMoney)) {
                continue;
            }
            if (!isPurchaseMoneyPositive(purchaseMoney)) {
                continue;
            }
            if (!isPurchaseMoneyThousands(purchaseMoney)) {
                continue;
            }
            return Integer.parseInt(purchaseMoney);
        }
    }

    public static Lotto askTargetLotto() {
        System.out.println("당첨 번호를 입력해 주세요.");
        while (true) {
            String input = Console.readLine();
            String[] inputArray = input.split(",");
            if (!validateTargetLotto(inputArray)) {
                continue;
            }
            return new Lotto(getTargetLotto(inputArray));
        }
    }

    public static boolean isPurchaseMoneyInteger(String purchaseMoney) {
        try {
            InputValidationTest.isItInteger(purchaseMoney);
        } catch (IllegalArgumentException ex) {
            System.out.println("[ERROR] 구입금액은 숫자로 입력해주세요.");
            return false;
        }
        return true;
    }

    public static boolean isPurchaseMoneyPositive(String purchaseMoney) {
        try {
            InputValidationTest.isItPositive(purchaseMoney);
        } catch (IllegalArgumentException ex) {
            System.out.println("[ERROR] 구입금액은 양수로 입력해주세요.");
            return false;
        }
        return true;
    }

    public static boolean isPurchaseMoneyThousands(String purchaseMoney) {
        try {
            InputValidationTest.isItThousands(purchaseMoney);
        } catch (IllegalArgumentException ex) {
            System.out.println("[ERROR] 구입금액은 1000의 배수로 입력해주세요.");
            return false;
        }
        return true;
    }

    public static boolean validateTargetLotto(String[] inputArray) {
        if (!isTargetLottoInteger(inputArray)) {
            return false;
        }
        List<Integer> targetLotto = getTargetLotto(inputArray);
        if (!validateTargetLottoSize(targetLotto)) {
            return false;
        }
        if (!validateTargetLottoRange(targetLotto)) {
            return false;
        }
        if (!validateTargetLottoDuplication(targetLotto)) {
            return false;
        }
        return true;
    }

    public static boolean isTargetLottoInteger(String[] inputArray) {
        for (String number : inputArray) {
            try {
                InputValidationTest.isItInteger(number);
            } catch (IllegalArgumentException ex) {
                System.out.println("[ERROR] 로또 번호는 숫자로 입력해주세요.");
                return false;
            }
        }
        return true;
    }

    private static boolean validateTargetLottoSize(List<Integer> numbers) {
        try {
            LottoValidationTest.testSize(numbers);
        } catch (IllegalArgumentException ex) {
            System.out.println("[ERROR] 로또 번호는 6개의 숫자입니다.");
            return false;
        }
        return true;
    }

    private static boolean validateTargetLottoRange(List<Integer> numbers) {
        try {
            LottoValidationTest.testRange(numbers);
        } catch (IllegalArgumentException ex) {
            System.out.println("[ERROR] 로또 번호는 1이상 45이하의 숫자로 구성됩니다.");
            return false;
        }
        return true;
    }

    private static boolean validateTargetLottoDuplication(List<Integer> numbers) {
        try {
            LottoValidationTest.testDuplication(numbers);
        } catch (IllegalArgumentException ex) {
            System.out.println("[ERROR] 로또 번호는 중복되는 숫자가 없어야 합니다.");
            return false;
        }
        return true;
    }

    public static List<Integer> getTargetLotto(String[] inputArray) {
        List<Integer> numbers = new ArrayList<>();
        for (String number : inputArray) {
            numbers.add(Integer.parseInt(number));
        }
        return numbers;
    }
}
