package lotto;

import domain.BonusNumber;
import domain.PrizeNumber;
import domain.PurchaseAmount;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class InputValidate {
    PurchaseAmount purchaseAmount = PurchaseAmount.getInstance();
    PrizeNumber prizeNumber = PrizeNumber.getInstance();
    BonusNumber bonusNumber = BonusNumber.getInstance();
    public void validatePurchaseAmount(String inputStr) {
        if (!inputStr.matches("^\\d+$")) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자로만 구성됩니다.");
        }

        int purchaseAmountTemp = Integer.parseInt(inputStr);

        if (purchaseAmountTemp < 1000) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 이상이어야 합니다.");
        }

        if (purchaseAmountTemp % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 입력 받습니다.");
        }

        purchaseAmount.setPurchaseAmount(purchaseAmountTemp);
    }

    public void validatePrizeNumber(String inputStr) {
        if (!inputStr.matches("^\\d+(,\\d+)*$")) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자로 구성되고 쉼표(,)로 구분됩니다.");
        }

        List<Integer> prizeNumberTemp = Arrays.stream(inputStr.split(","))
                .map(s -> {
                    int num = Integer.parseInt(s);
                    if (num > 45) {
                        throw new IllegalArgumentException("[ERROR] 당첨 번호는 45 이하의 숫자로 구성됩니다.");
                    }
                    return num;
                })
                .collect(Collectors.toList());

        if (prizeNumberTemp.size() != new HashSet<>(prizeNumberTemp).size()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복되면 안됩니다.");
        }

        if (prizeNumberTemp.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개의 숫자로 구성됩니다.");
        }

        prizeNumber.setPrizeNumber(prizeNumberTemp);
    }

    public void validateBonusNumber(String inputStr) {
        if (!inputStr.matches("^\\d+$")) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자로만 구성됩니다.");
        }

        int bonusNumberTemp = Integer.parseInt(inputStr);

        if (bonusNumberTemp > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 45 이하의 숫자로 구성됩니다.");
        }

        if (prizeNumber.getPrizeNumber().contains(bonusNumberTemp)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복되면 안됩니다.");
        }
        bonusNumber.setBonusNumber(bonusNumberTemp);
    }
}
