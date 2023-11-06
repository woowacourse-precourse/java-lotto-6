package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.dto.Lotto;
import lotto.message.ErrorMessage;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static lotto.message.InputGuideMessage.*;

public class Application {
    static ResultCalculationSystem resultCalculationSystem = new ResultCalculationSystem();
    static final String REGEX_FOR_INPUT_LOTTO_PAYMENT = "^[0-9]+$";
    static final String REGEX_FOR_LOTTO_NUMBER_RANGE = "^[1-9]{1}$|^[1-3]{1}[0-9]{1}$|^[4]{1}[0-5]{1}$";

    static List<Lotto> lottos = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(PLEASE_ENTER_LOTTO_PAYMENT_MESSAGE.getMessage());
        int desiredPurchaseAmount = validateEnteredLottoPayment();
        int numberOfLotto = desiredPurchaseAmount / 1000;

        System.out.println(PLEASE_ENTER_WINNING_NUMBERS_MESSAGE.getMessage());
        List<Integer> lottoWinningNumbers = validateEnteredLottoNumbers();

        System.out.println(PLEASE_ENTER_BONUS_NUMBER_MESSAGE.getMessage());
        int bonusNumber = validateEnteredBonusNumber(lottoWinningNumbers);

        createNewLottos(numberOfLotto);

        System.out.printf(INFORM_HOW_MANY_LOTTOS_WERE_PURCHASED_MESSAGE.getMessage(), numberOfLotto);
        printLottos();

        resultCalculationSystem.makeWinningResult(lottos, lottoWinningNumbers, bonusNumber);
        resultCalculationSystem.calculateRateOfReturn(desiredPurchaseAmount);

        resultCalculationSystem.printWinningResult();
    }

    private static void createNewLottos(int numberOfLotto) {
        for (int i = 0; i < numberOfLotto; i++) {
            List<Integer> lottoNumbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            lottoNumbers.sort(Comparator.naturalOrder());
            try {
                lottos.add(new Lotto(lottoNumbers));
            } catch (IllegalArgumentException e) {
                System.out.println(ErrorMessage.INVALID_LOTTO_NUMBERS_COUNT_ERROR.getMessage());
                i--;
            }
        }
    }

    private static void printLottos() {
        for (Lotto lotto : lottos)
            lotto.printNumber();
    }

    private static int validateEnteredLottoPayment() {
        while (true) {
            String input = Console.readLine();
            try {
                if (Pattern.matches(REGEX_FOR_INPUT_LOTTO_PAYMENT, input) &&
                        input.length() >= 4 &&
                        input.endsWith("000")) {
                    return Integer.parseInt(input);
                }
                throw new IllegalArgumentException();
            } catch (IllegalArgumentException e) {
                System.out.println(ErrorMessage.INVALID_AMOUNT_ERROR.getMessage());
            }
        }
    }

    private static List<Integer> validateEnteredLottoNumbers() {
        while (true) {
            String input = Console.readLine();
            try {
                List<Integer> numbers = new ArrayList<>();
                Stream.of(input.split(","))
                        .iterator()
                        .forEachRemaining(number -> {
                            if (!Pattern.matches(REGEX_FOR_LOTTO_NUMBER_RANGE, number.trim()))
                                throw new IllegalArgumentException();
                            numbers.add(Integer.parseInt(number.trim()));
                        });
                return numbers;
            } catch (IllegalArgumentException e) {
                System.out.println(ErrorMessage.INVALID_WINNING_NUMBERS_ERROR.getMessage());
            }
        }
    }

    private static int validateEnteredBonusNumber(List<Integer> lottoWinningNumbers) {
        while (true) {
            String input = Console.readLine();
            try {
                if (Pattern.matches(REGEX_FOR_LOTTO_NUMBER_RANGE, input.trim()) &&
                !lottoWinningNumbers.contains(Integer.parseInt(input.trim()))) {
                    return Integer.parseInt(input.trim());
                }
                throw new IllegalArgumentException();
            } catch (IllegalArgumentException e) {
                System.out.println(ErrorMessage.INVALID_BONUS_NUMBER_ERROR.getMessage());
            }
        }
    }


}
