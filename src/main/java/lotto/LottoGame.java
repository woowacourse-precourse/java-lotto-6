package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

import static lotto.Constant.*;
import static lotto.Message.*;

public class LottoGame {
    private Integer purchaseAmount;
    private Integer lottoCount;
    private final ArrayList<Lotto> lotteries = new ArrayList<>();
    private final List<Integer> winningNums = new ArrayList<>();
    private Integer bonusNum;
    private Double profitPercentage;
    private Long profit = 0L;
    private final ArrayList<Integer> prizes = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0));


    public void play() {
        getPurchaseInput();
        showPurchasedLottoCount();

        issueLotteries();
        printLotteries();

        getWinningNumberInput();
        getBonusNumberInput();

    }

    private void getPurchaseInput() {
        System.out.println(PURCHASE_INPUT_PROMPT);
        String input = Console.readLine();
        try {
            validateMoney(input);
            purchaseAmount = Integer.parseInt(input);
            System.out.println();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            getPurchaseInput();
        }
    }

    private void showPurchasedLottoCount() {
        lottoCount = purchaseAmount / PRICE;
        System.out.println(lottoCount + PURCHASE_CONFIRMATION_MESSAGE);
    }

    private void issueLotteries() {
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> numbers = new ArrayList<>(
                    Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, NUMBER_COUNT)
            );
            try {
                Collections.sort(numbers);
                Lotto lotto = new Lotto(numbers);
                lotteries.add(lotto);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                issueLotteries();
            }
        }
    }

    private void printLotteries() {
        for (Lotto lotto : lotteries) {
            lotto.printNumbers();
        }
        System.out.println();
    }

    private void validateMoney(String input) {
        if (!input.matches(regExp)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "구입 금액은 양의 정수로 입력 가능합니다.");
        }
        Integer inputPrice = Integer.parseInt(input);
        if (input.length() > 9 || inputPrice > MAX_MONEY) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "구입 금액은 " + MAX_MONEY + "원을 초과할 수 없습니다.");
        }
        if (inputPrice % PRICE != 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "구입 금액은 " + PRICE + "원 단위여야 합니다.");
        }
    }

    private void getWinningNumberInput() {
        System.out.println(WINNING_NUMBER_INPUT_PROMPT);
        String input = Console.readLine();
        try {
            validateWinningNumber(input);
            ArrayList<String> tempWinningNumbers = new ArrayList<>(Arrays.asList(input.split(",")));
            for (String number : tempWinningNumbers) {
                winningNums.add(Integer.parseInt(number));
            }
            System.out.println();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            getWinningNumberInput();
        }
    }

    private void getBonusNumberInput() {
        System.out.println(BONUS_NUMBER_INPUT_PROMPT);
        String input = Console.readLine();
        try {
            validateBonusNumber(input);
            bonusNum = Integer.parseInt(input);
            System.out.println(bonusNum);
            System.out.println();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            getBonusNumberInput();
        }
    }

    private void validateWinningNumber(String input) {
        String WINNING_NUMBER_COUNT_ERROR = "당첨 번호는 " + NUMBER_COUNT + "개 정수입니다.";
        String WINNING_NUMBER_DUPLICATE_ERROR = "당첨 번호는 중복될 수 없습니다.";
        ArrayList<String> winningNumbers = new ArrayList<>(Arrays.asList(input.split(",")));
        if (winningNumbers.size() != NUMBER_COUNT) {
            throw new IllegalArgumentException(ERROR_MESSAGE + WINNING_NUMBER_COUNT_ERROR);
        }
        for (String winningNumber : winningNumbers) {
            validateWinningNumberRange(winningNumber);
        }
        HashSet<String> numbers = new HashSet<>(winningNumbers);
        if (numbers.size() < winningNumbers.size()) {
            throw new IllegalArgumentException(ERROR_MESSAGE + WINNING_NUMBER_DUPLICATE_ERROR);
        }
    }

    private static void validateWinningNumberRange(String winningNumber) {
        String WINNING_NUMBER_RANGE_ERROR = "당첨 번호는 " + MIN_NUMBER + "부터" + MAX_NUMBER + "까지의 정수여야 합니다.";
        if (winningNumber.length() > 9) {
            throw new IllegalArgumentException(ERROR_MESSAGE + WINNING_NUMBER_RANGE_ERROR);
        }
        if (!winningNumber.matches(regExp)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + WINNING_NUMBER_RANGE_ERROR);
        }
        int number = Integer.parseInt(winningNumber);
        if ((number < MIN_NUMBER || number > MAX_NUMBER)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + WINNING_NUMBER_RANGE_ERROR);
        }
    }

    private void validateBonusNumber(String input) {
        String BONUS_NUMBER_RANGE_ERROR = "보너스 번호는 " + MIN_NUMBER + "부터" + MAX_NUMBER + "까지의 정수여야 합니다.";
        String BONUS_NUMBER_DUPLICATE_ERROR = "보너스 번호는 당첨 번호와 중복될 수 없습니다.";
        if (input.length() > 9) {
            throw new IllegalArgumentException(ERROR_MESSAGE + BONUS_NUMBER_RANGE_ERROR);
        }
        if (!input.matches(regExp)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + BONUS_NUMBER_RANGE_ERROR);
        }
        int number = Integer.parseInt(input);
        if ((number < MIN_NUMBER || number > MAX_NUMBER)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + BONUS_NUMBER_RANGE_ERROR);
        }
        if (winningNums.contains(number)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + BONUS_NUMBER_DUPLICATE_ERROR);
        }
    }
}
