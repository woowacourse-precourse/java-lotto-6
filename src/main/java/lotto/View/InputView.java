package lotto.View;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashSet;
import java.util.Set;
import lotto.Validator.LottoPurchaseAmountValidator;

public class InputView {

    private final static String INPUT_LOTTO_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private final static String INPUT_LOTTO_NUMBER_MESSAGE="당첨 번호를 입력해 주세요.";
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    public static int inputLottoPurchaseAmount() {
        System.out.println(INPUT_LOTTO_PURCHASE_AMOUNT_MESSAGE);
        String input = Console.readLine();

        LottoPurchaseAmountValidator.validateIsNumeric(input);
        LottoPurchaseAmountValidator.validateFitPurchaseAmountCondition(input);

        return Integer.parseInt(input);

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
