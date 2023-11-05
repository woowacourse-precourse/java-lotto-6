package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Buyer {
    public int takeLottoPurchaseAmountFromBuyer() {
        String money = Console.readLine();
        return Integer.parseInt(money);
    }

    public boolean validatePurchaseAmount(int money) {
        return money % 1000 == 0;
    }

    public int getLottoPurchaseAmount() {
        int money = takeLottoPurchaseAmountFromBuyer();
        if (validatePurchaseAmount(money)) {
            return money;
        }
        throw new IllegalArgumentException("천원단위로 입력해주세요.");
    }

    public List<Integer> getLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public int getBonusNumber(List<Integer> LottoNumbers) {
        int bonusNumber;
        do {
            bonusNumber = Randoms.pickNumberInRange(1, 45);
        } while (LottoNumbers.contains(bonusNumber));
        return bonusNumber;
    }
}
