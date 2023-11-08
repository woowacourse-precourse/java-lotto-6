package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Application {
    private static final int LOTTO_PRICE = 1000;
    private static final String MESSAGE_FOR_PURCHASE_AMOUNT_INPUT = "구입금액을 입력해 주세요.";
    private static final String MESSAGE_FOR_WINNING_NUMBERS_INPUT = "당첨 번호를 입력해 주세요.";
    private static final String MESSAGE_FOR_BONUS_NUMBERS_INPUT = "보너스 번호를 입력해 주세요.";

    private static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";
    private static final String ERROR_MESSAGE_FOR_PURCHASE_AMOUNT_TYPE = "구앱금액은 숫자여야 합니다.";
    private static final String ERROR_MESSAGE_FOR_PURCHASE_AMOUNT_VALUE = "구앱금액은 1000원 단위여야 합니다.";
    private static final String ERROR_MESSAGE_FOR_WINNING_NUMBER_TYPE = "로또 번호는 숫자여야 합니다.";
    private static final String ERROR_MESSAGE_FOR_WINNING_NUMBER_RANGE = "로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String ERROR_MESSAGE_FOR_WINNING_NUMBER_COUNT = "로또 번호는 6개 숫자여야 합니다.";
    private static final String ERROR_MESSAGE_FOR_WINNING_NUMBER_DUPLICATE = "로또 번호는 중복되지 않은 숫자여야 합니다.";
    private static final String ERROR_MESSAGE_FOR_BONUS_NUMBER_TYPE = "보너스 번호는 숫자여야 합니다.";
    private static final String ERROR_MESSAGE_FOR_BONUS_NUMBER_RANGE = "보너스 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String ERROR_MESSAGE_FOR_BONUS_NUMBER_DUPLICATE = "보너스 번호는 로또 번호와 중복되지 않아야 합니다.";

    private static int purchaseAmount;
    private static int bonusNumber;
    private static List<Integer> winningNumbers;
    private static List<Lotto> lottos;

    public static void main(String[] args) {
        purchaseAmount = getPurchaseAmountWithInput();
        lottos = purchaseLottos(purchaseAmount);
        printPurchasedLottos();
        winningNumbers = getWinningNumbersWithInput();
        bonusNumber = getBonusNumberWithInput();

        LottoJudger judger = new LottoJudger(winningNumbers, bonusNumber, purchaseAmount);
        judger.judge(lottos);
        judger.printStatisticOfResult();
    }

    private static int getPurchaseAmountWithInput() {
        System.out.println(MESSAGE_FOR_PURCHASE_AMOUNT_INPUT);
        while (true) {
            String purchaseAmountInput = Console.readLine();
            try {
                validatePurchaseAmountInput(purchaseAmountInput);
            } catch (IllegalArgumentException e) {
                continue;
            }
            return Integer.parseInt(purchaseAmountInput);
        }
    }

    private static void validatePurchaseAmountInput(String purchaseAmountInput) {
        validatePurchaseAmountType(purchaseAmountInput);
        int purchaseAmount = Integer.parseInt(purchaseAmountInput);
        validatePurchaseAmountMod1000IsZero(purchaseAmount);
    }

    private static void validatePurchaseAmountType(String purchaseAmountInput) {
        try {
            Integer.parseInt(purchaseAmountInput);
        } catch (NumberFormatException e) {
            printErrorMessage(ERROR_MESSAGE_FOR_PURCHASE_AMOUNT_TYPE);
            throw new IllegalArgumentException();
        }
    }

    private static void validatePurchaseAmountMod1000IsZero (int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            printErrorMessage(ERROR_MESSAGE_FOR_PURCHASE_AMOUNT_VALUE);
            throw new IllegalArgumentException();
        }
    }

    private static List<Lotto> purchaseLottos(int purchaseAmount) {
        List<Lotto> purchasedLottos = new ArrayList<>();
        while (purchaseAmount > 0) {
            Lotto lotto;
            try {
                lotto = purchaseLotto();
            } catch (IllegalArgumentException e) {
                continue;
            }
            purchasedLottos.add(lotto);
            purchaseAmount -= LOTTO_PRICE;
        }
        return purchasedLottos;
    }

    private static Lotto purchaseLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }

    private static void printPurchasedLottos() {
        System.out.println("\n" + lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            lotto.printLottoNumbers();
        }
        System.out.println();
    }

    private static List<Integer> getWinningNumbersWithInput() {
        System.out.println(MESSAGE_FOR_WINNING_NUMBERS_INPUT);
        while (true) {
            String winningNumbersInput = Console.readLine();
            try {
                validateWinningNumbersInput(winningNumbersInput);
            } catch (IllegalArgumentException e) {
                continue;
            }
            return Arrays.stream(winningNumbersInput.split(",")).map(Integer::parseInt).toList();
        }
    }

    private static void validateWinningNumbersInput(String winningNumbersInput) {
        List<String> winningNumbersStrings = Arrays.stream(winningNumbersInput.split(",")).toList();
        validateWinningNumbersType(winningNumbersStrings);

        List<Integer> winningNumbers = winningNumbersStrings.stream().map(Integer::parseInt).toList();
        validateWinningNumbersSizeIs6(winningNumbers);
        validateWinningNumbersRangeIn1To45(winningNumbers);
        validateWinningNumbersNotDuplicate(winningNumbers);
    }

    private static void validateWinningNumbersType(List<String> winningNumbersString) {
        for (String numberString: winningNumbersString) {
            try {
                int number = Integer.parseInt(numberString);
            } catch (NumberFormatException e) {
                printErrorMessage(ERROR_MESSAGE_FOR_WINNING_NUMBER_TYPE);
                throw new IllegalArgumentException();
            }
        }
    }

    private static void validateWinningNumbersSizeIs6(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            printErrorMessage(ERROR_MESSAGE_FOR_WINNING_NUMBER_COUNT);
            throw new IllegalArgumentException();
        }
    }

    private static void validateWinningNumbersRangeIn1To45(List<Integer> winningNumbers) {
        for (int number: winningNumbers) {
            if (number < 1 || number > 45) {
                printErrorMessage(ERROR_MESSAGE_FOR_WINNING_NUMBER_RANGE);
                throw new IllegalArgumentException();
            }
        }
    }

    private static void validateWinningNumbersNotDuplicate(List<Integer> winningNumbers) {
        Set<Integer> winningNumberSet = Set.copyOf(winningNumbers);
        if (winningNumberSet.size() != 6) {
            printErrorMessage(ERROR_MESSAGE_FOR_WINNING_NUMBER_DUPLICATE);
            throw new IllegalArgumentException();
        }
    }

    private static int getBonusNumberWithInput() {
        System.out.println(MESSAGE_FOR_BONUS_NUMBERS_INPUT);
        while (true) {
            String bonusNumberInput = Console.readLine();
            try {
                validateBonusNumberInput(bonusNumberInput);
            } catch (IllegalArgumentException e) {
                continue;
            }
            return Integer.parseInt(bonusNumberInput);
        }
    }

    private static void validateBonusNumberInput(String bonusNumberInput) {
        int bonusNumber;
        try {
            bonusNumber = Integer.parseInt(bonusNumberInput);
        } catch (NumberFormatException e) {
            printErrorMessage(ERROR_MESSAGE_FOR_BONUS_NUMBER_TYPE);
            throw new IllegalArgumentException();
        }

        if (bonusNumber < 1 || bonusNumber > 45) {
            printErrorMessage(ERROR_MESSAGE_FOR_BONUS_NUMBER_RANGE);
            throw new IllegalArgumentException();
        }

        if (winningNumbers.contains(bonusNumber)) {
            printErrorMessage(ERROR_MESSAGE_FOR_BONUS_NUMBER_DUPLICATE);
            throw new IllegalArgumentException();
        }
    }

    private static void printErrorMessage(String errorMessage) {
        System.out.println(ERROR_MESSAGE_PREFIX + errorMessage);
    }
}
