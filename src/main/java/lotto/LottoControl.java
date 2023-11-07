package lotto;

import static java.lang.Integer.parseInt;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class LottoControl {
    public static int inputLottoPrice() {
        LottoView.signalInputLottoPrice();
        String boughtLottoPrice = Console.readLine();
        while (isLottoPriceError(boughtLottoPrice)) {
            boughtLottoPrice = Console.readLine();
        }
        return parseInt(boughtLottoPrice);
    }

    public static boolean isLottoPriceError(String boughtLottoPrice) {
        try {
            checkLottoPriceError(boughtLottoPrice);
            return false;
        } catch (IllegalArgumentException e) {
            return true;
        }
    }

    private static void checkLottoPriceError(String boughtLottoPrice) {
        if (!boughtLottoPrice.chars().allMatch(Character::isDigit)) {
            System.out.println("[ERROR] 구입한 값은 정수여야 합니다.");
            throw new IllegalArgumentException("[ERROR] 구입한 값은 정수여야 합니다.");
        } else if (parseInt(boughtLottoPrice) < 1) {
            System.out.println("[ERROR] 구입한 값은 0 초과의 정수여야 합니다.");
            throw new IllegalArgumentException("[ERROR] 구입한 값은 0 초과의 정수여야 합니다.");
        } else if (parseInt(boughtLottoPrice) % 1000 != 0) {
            System.out.println("[ERROR] 구입한 값은 1000의 배수인 정수여야 합니다.");
            throw new IllegalArgumentException("[ERROR] 구입한 값은 1000의 배수인 정수여야 합니다.");
        }
    }

    public static Lotto inputWinningNumbers() {
        LottoView.signalInputWinningNumbers();
        String[] winningNumbers = Console.readLine().split(",");

        while (isWinningNumbersError(winningNumbers)) {
            winningNumbers = Console.readLine().split(",");
        }
        return setWinningNumbers(winningNumbers);
    }

    private static boolean isWinningNumbersError(String[] winningNumbers) {
        try {
            checkWinningNumberError(winningNumbers);
            return false;
        } catch (IllegalArgumentException e) {
            return true;
        }
    }

    private static void checkWinningNumberError(String[] winningNumbers) {
        for (String winningNumber : winningNumbers) {
            if (!winningNumber.chars().allMatch(Character::isDigit)) {
                System.out.println("[ERROR] 당첨 번호는 정수여야 합니다. (공백 불허)");
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 정수여야 합니다. (공백 불허)");
            }
        }
        setWinningNumbers(winningNumbers);
    }

    private static Lotto setWinningNumbers(String[] winningNumbers) {
        List<Integer> numbers = new ArrayList<>();

        for (String winningNumber : winningNumbers) {
            numbers.add(parseInt(winningNumber));
        }

        return new Lotto(numbers);
    }

    public static int inputBonusNumber(Lotto winningNumbers) {
        LottoView.signalInputBonusNumber();
        String bonusNumber = Console.readLine();
        while (isBonusNumberError(bonusNumber, winningNumbers)) {
            bonusNumber = Console.readLine();
        }

        return parseInt(bonusNumber);
    }

    private static boolean isBonusNumberError(String bonusNumber, Lotto winningNumberss) {
        try {
            checkBonusNumberError(bonusNumber, winningNumberss);
            return false;
        } catch (IllegalArgumentException e) {
            return true;
        }
    }

    private static void checkBonusNumberError(String bonusNumber, Lotto winningNumbers) {
        if (!bonusNumber.chars().allMatch(Character::isDigit)) {
            System.out.println("[ERROR] 보너스 번호는 정수여야 합니다.");
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 정수여야 합니다.");
        } else if (parseInt(bonusNumber) < 1 || parseInt(bonusNumber) > 45) {
            System.out.println("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        } else if (winningNumbers.getNumbers().contains(parseInt(bonusNumber))) {
            System.out.println("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }
}
