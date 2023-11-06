package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputService {

    public static final int AMOUNT_UNIT = 1000;

    public static int getUserInputForPurchaseAmount() {
        System.out.println("구입 금액을 입력해 주세요.");
        int purchaseAmount = validateInputConvert(readLine());
        validateAmountUnit(purchaseAmount);
        return purchaseAmount;
    }

    public static Lotto getUserInputForLottoNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String numbers = readLine();
        return validateLottoNumbersFormat(numbers);
    }

    public static int getUserInputForBonusNumber(Lotto lotto) {
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = validateInputConvert(readLine());
        validateBonusNumber(lotto, bonusNumber);
        return bonusNumber;
    }

    private static void validateBonusNumber(Lotto lotto, int bonusNumber) {
        Lotto.checkRangeOfLottoNumber(bonusNumber);
        checkDuplication(lotto, bonusNumber);
    }

    private static void checkDuplication(Lotto lotto, int bonusNumber) {
        List<Integer> lottoIncludeBonusNumber = lotto.getLottoIncludeBonusNumber(lotto, bonusNumber);
        Set<Integer> set = new HashSet<>(lottoIncludeBonusNumber);
        if (set.size() == Lotto.LOTTO_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATION_ERROR);
        }
    }

    private static Lotto validateLottoNumbersFormat(String numbers) {
        try {
            List<Integer> lotto = Stream.of(numbers.trim().split("\\s*, \\s*"))
                    .mapToInt(Integer::parseInt).boxed()
                    .collect(Collectors.toList());
            return new Lotto(lotto);
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.CONVERT_ERROR);
        }
    }

    private static int validateInputConvert(String number) {
        try {
            return Integer.parseInt(number);
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.CONVERT_ERROR);
        }
    }

    private static void validateAmountUnit(int purchaseAmount) {
        checkAmountIsSufficient(purchaseAmount);
        checkAmountUnitIsCorrect(purchaseAmount);
    }

    private static void checkAmountUnitIsCorrect(int purchaseAmount) {
        if (purchaseAmount % AMOUNT_UNIT != 0) {
            throw new IllegalArgumentException(ErrorMessage.INCORRECT_AMOUNT_ERROR);
        }
    }

    private static void checkAmountIsSufficient(int purchaseAmount) {
        if (purchaseAmount < AMOUNT_UNIT) {
            throw new IllegalArgumentException(ErrorMessage.INSUFFICIENT_AMOUNT_ERROR);
        }
    }


}