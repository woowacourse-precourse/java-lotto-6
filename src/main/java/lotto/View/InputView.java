package lotto.View;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.Domain.BonusNumberValidator;
import lotto.Domain.LottoPurchaseAmountValidator;

public class InputView {

    private final static String INPUT_LOTTO_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private final static String INPUT_LOTTO_NUMBER_MESSAGE="당첨 번호를 입력해 주세요.";
    private final static String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public static int inputLottoPurchaseAmount() {
        System.out.println(INPUT_LOTTO_PURCHASE_AMOUNT_MESSAGE);
        String input = Console.readLine();

        LottoPurchaseAmountValidator.validateIsNumeric(input);
        LottoPurchaseAmountValidator.validateFitPurchaseAmountCondition(input);

        return Integer.parseInt(input);

    }

    public static List<Integer> inputLottoNumbers() {
        List<Integer> lottoNumbers = new ArrayList<>();

        System.out.println(INPUT_LOTTO_NUMBER_MESSAGE);
        String input = Console.readLine();

        lottoNumbers = parseLottoNumbers(input);

        return lottoNumbers;
    }

    private static List<Integer> parseLottoNumbers(String input) {
        List<Integer> lottoNumbers = new ArrayList<>();
        String[] eachLottoNumbers = input.split(",");

        for (String token : eachLottoNumbers) {
            int lottoNumber = Integer.parseInt(token);
            lottoNumbers.add(lottoNumber);
        }

        return lottoNumbers;
    }

    public static int inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
        String input = Console.readLine();

        BonusNumberValidator.validateIsNumeric(input);
        int bonusNumber = Integer.parseInt(input);

        BonusNumberValidator.validateIsNumberInRange(bonusNumber);

        return Integer.parseInt(input);

    }
}
