package lotto.valid;

import java.util.List;

public class StringValidator extends Validator {

    public static int purchaseValidate(String purchaseMoney) throws IllegalArgumentException {
        int money = convertToInteger(purchaseMoney);
        validatePositive(money);
        validateMultipleOfThousand(money);
        return money;
    }

    private static void validateMultipleOfThousand(int purchaseMoney) throws IllegalArgumentException {
        if (purchaseMoney % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해주세요.");
        }
    }

    public static List<Integer> lottoValidate(String stringLottoNumbers) {
        List<String> stringLottoNumberList = List.of(stringLottoNumbers.split(","));
        return convertToInteger(stringLottoNumberList);
    }

    public static int bonusNumberValidate(String stringBonusNumber) {
        int bonusNumber = convertToInteger(stringBonusNumber);
        validatePositive(bonusNumber);
        return bonusNumber;
    }
}
