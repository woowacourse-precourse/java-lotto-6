package lotto.View;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class InputView {

    private final static String INPUT_LOTTO_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private final static String INVALID_TYPE_MESSAGE = "숫자로 이루어진 값을 입력해주세요";
    private final static String INVALID_NUMBER_MESSAGE = "올바른 금액을 입력해주세요";
    private final static String INPUT_LOTTO_NUMBER_MESSAGE="당첨 번호를 입력해 주세요."
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    public static int inputLottoPurchaseAmount() {
        System.out.println(INPUT_LOTTO_PURCHASE_AMOUNT_MESSAGE);
        String input = Console.readLine();

        validateIsNumeric(input);
        validateFitPurchaseAmountCondition(input);

        return Integer.parseInt(input);

    }

    public static void validateIsNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_TYPE_MESSAGE);
        }
    }

    public static void validateFitPurchaseAmountCondition(String input) {
        int purchaseAmount = Integer.parseInt(input);
        if (purchaseAmount <= 0 || purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException(INVALID_NUMBER_MESSAGE);
        }
    }

    public static Set<Integer> inputLottoNumbers() {
        Set<Integer> lottoNumbers = new HashSet<>();

        System.out.println(INPUT_LOTTO_NUMBER_MESSAGE);
        String input = Console.readLine();

        lottoNumbers = parseLottoNumbers(input);

        return lottoNumbers;
    }

    private static Set<Integer> parseLottoNumbers(String input) {
        Set<Integer> lottoNumbers = new HashSet<>();
        String[] eachLottoNumbers = input.split(",");

        for (String token : eachLottoNumbers) {
            int lottoNumber = Integer.parseInt(token);
            lottoNumbers.add(lottoNumber);
        }

        return lottoNumbers;
    }
}
