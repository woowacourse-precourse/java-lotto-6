package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Application {
    private static final Integer lottoPrice = 1000;
    private static String errorMessage;

    public static void main(String[] args) {
        String[] inputNumberString;
        System.out.println("구입금액을 입력해 주세요.");
        Integer inputMoney = InputMoney();
        Integer n = inputMoney / lottoPrice;
        Lotto lottoArray[] = new Lotto[n];
        System.out.println("\n" + n + "개를 구매했습니다.");
        for (int i = 0; i < n; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottoArray[i] = new Lotto(numbers);
            Sort(lottoArray[i]);
            System.out.println(lottoArray[i].getNumbers());
        }
        System.out.println("\n당첨 번호를 입력해 주세요.");
        inputNumberString = InputNumber();
        Integer[] inputNumber = new Integer[inputNumberString.length];
        for (int i = 0; i < inputNumberString.length; i++) {
            inputNumber[i] = Integer.valueOf(inputNumberString[i]);
        }
        System.out.println("\n보너스 번호를 입력해 주세요.");
        Integer bonusNumber = Integer.valueOf(InputBonusNumber(inputNumber));


    }

    private static Integer InputMoney() {
        Integer inputMoney = Integer.valueOf(Console.readLine());
        Integer money;
        try {
            if (inputMoney % lottoPrice != 0) {
                throw new IllegalArgumentException("[ERROR] 입력 단위는 1,000원 단위여야 합니다.");
            }
            money = inputMoney;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            money = InputMoney();
        }
        return money;
    }

    private static void Sort(Lotto lotto) {
        for (int i = 0; i < 5; i++) {
            Sorting(lotto, i);
        }
    }

    private static void Sorting(Lotto lotto, int index) {
        Integer minIndex = index;
        for (int i = index + 1; i < 6; i++) {
            if (lotto.getNumberIndex(minIndex) > lotto.getNumberIndex(i)) {
                minIndex = i;
            }
        }
        Integer tmp = lotto.getNumberIndex(minIndex);
        lotto.setNumberIndex(minIndex, lotto.getNumberIndex(index));
        lotto.setNumberIndex(index, tmp);
    }

    private static String[] InputNumber() {
        String[] inputNumberString = Console.readLine().split(",");
        try {
            if (IsValid(inputNumberString)) {
                throw new IllegalArgumentException(errorMessage);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            inputNumberString = InputNumber();
        }
        return inputNumberString;
    }

    private static boolean IsValid(String[] input) {
        if (CheckLength(input)) {
            return true;
        }
        if (IsNumber(input)) {
            return true;
        }
        for (int i = 0; i < input.length - 1; i++) {
            if (IsUnique(input, i)) {
                return true;
            }
        }
        return false;
    }

    private static boolean CheckLength(String[] input) {
        if (input.length < 6) {
            errorMessage = "[ERROR] 로또 번호는 6개의 숫자를 입력해야 합니다.";
            return true;
        }
        return false;
    }

    private static boolean IsNumber(String[] input) {
        for (int i = 0; i < input.length; i++) {
            if (Integer.valueOf(input[i]) < 1 || Integer.valueOf(input[i]) > 45) {
                errorMessage = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
                return true;
            }
        }
        return false;
    }

    private static boolean IsUnique(String[] input, int i) {
        for (int j = i + 1; j < input.length; j++) {
            if (Integer.valueOf(input[i]) == Integer.valueOf(input[j])) {
                errorMessage = "[ERROR] 로또 번호는 중복되지 않은 숫자여야 합니다.";
                return true;
            }
        }
        return false;
    }

    private static String InputBonusNumber(Integer[] inputNumber) {
        String bonusNumber = Console.readLine();
        try {
            if (IsNumber(bonusNumber)) {
                throw new IllegalArgumentException(errorMessage);
            }
            if (IsUnique(inputNumber, bonusNumber)) {
                throw new IllegalArgumentException(errorMessage);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            bonusNumber = InputBonusNumber(inputNumber);
        }
        return bonusNumber;
    }

    private static boolean IsUnique(Integer[] inputNumber, String bonusNumber) {
        for (int i = 0; i < inputNumber.length; i++) {
            if (inputNumber[i] == Integer.valueOf(bonusNumber)) {
                errorMessage = "[ERROR] 보너스 번호는 로또 번호와 중복되지 않은 숫자여야 합니다.";
                return true;
            }
        }
        return false;
    }

    private static boolean IsNumber(String bonusNumber) {
        if (Integer.valueOf(bonusNumber) < 1 || Integer.valueOf(bonusNumber) > 45) {
            errorMessage = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
            return true;
        }
        return false;
    }
}