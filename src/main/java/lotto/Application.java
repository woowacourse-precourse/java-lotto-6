package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {

    public static void main(String[] args) {
        System.out.println(InputMessage.purchaseAmount);
        int result = inputPurchaseAmount();

        List<Lotto> lottos = createLottos(result);

        printPurchaseCount();
        printLottos(lottos);

        System.out.println(InputMessage.WINNING_NUMBER);
        Lotto winningNumber = createWinningNumber(inputWinningNumber());

        System.out.println(InputMessage.BONUS_NUMBER);
        validateBonusNumber((Console.readLine());
    }

    private static void validateBonusNumber(String input) {
        checkNull(input);
        checkEmpty(input);
    }

    private static String inputWinningNumber() {
        String result = validateWinningNumber(Console.readLine());
        if (result == null) {
            inputWinningNumber();
        }
        return result;
    }

    private static String validateWinningNumber(String winningNumber) {
        try {
            checkNull(winningNumber);
            checkEmpty(winningNumber);
            checkDelimiter(winningNumber);
            return winningNumber;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static int inputPurchaseAmount() {
        int result = validate(Console.readLine());
        if (result == -1) {
            inputPurchaseAmount();
        }
        return result;
    }

    public static int validate(String input) {
        try {
            checkNull(input);
            checkEmpty(input);
            int number = checkNumber(input);
            checkZero(number);
            checkUnit(number);
            return number;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    public static void checkEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.REQUIRED_VALUE);
        }
    }

    public static int checkNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.IS_NOT_NUMBER);
        }
    }

    public static void checkUnit(int purchaseAmount) {
        if (purchaseAmount % LottoNumbers.PURCHASE_AMOUNT_UNIT != 0) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_UNIT);
        }
    }

    public static void checkZero(int purchaseAmount) {
        if (purchaseAmount < LottoNumbers.PURCHASE_AMOUNT_MIN) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_ZERO);
        }
    }

    public static void checkNull(String input) {
        if (input == null) {
            throw new IllegalArgumentException(ErrorMessage.NULL);
        }
    }

    public static Lotto createLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(LottoNumbers.START_LOTTO_NUMBER,
                LottoNumbers.END_LOTT0_NUMBER, LottoNumbers.COUNT));
    }

    public static List<Lotto> createLottos(int purchaseAmount) {
        List<Lotto> lottos = new ArrayList<>();
        User.purchaseCount = purchaseAmount / LottoNumbers.PURCHASE_AMOUNT_UNIT;

        for (int i = 0; i < User.purchaseCount; i++) {
            lottos.add(createLotto());
        }

        return lottos;
    }

    public static void  printPurchaseCount() {
        System.out.println(OuputMessage.purchaseCount);
    }

    public static void printLottos(List<Lotto> lottos) {
        lottos.stream()
                .forEach((lotto -> System.out.println(lotto)));
    }

    public static void checkDelimiter(String input) {
        String regex = "[^0-9,]";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBER_FORMAT);
        }
    }

    public static Lotto createWinningNumber(String input) {
        List<Integer> winningNum = splitAndtoList(input);

        try {
            return new Lotto(winningNum);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return createWinningNumber(inputWinningNumber());
        }
    }

    private static List<Integer> splitAndtoList(String input) {
        List<Integer> winningNum = Arrays.stream(input.split(","))
                .map((str) -> Integer.parseInt(str))
                .toList();
        return winningNum;
    }
}
