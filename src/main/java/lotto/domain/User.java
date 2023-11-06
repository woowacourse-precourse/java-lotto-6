package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static lotto.messages.Constant.AMOUNT_UNIT;
import static lotto.validation.NumberCheckValidator.validateBonusNumber;
import static lotto.validation.PurchaseAmountCheckValidator.validatePurchaseAmount;

public class User {
    private static User user;

    List<Integer> lottoNumbers = new ArrayList<>();

    private User() {
    }

    public static User getInstance() {
        if (user == null) {
            return user = new User();
        }
        return user;
    }

    public int inputPurchaseAmount() {
        String stringPurchaseAmount = Console.readLine();
        return validatePurchaseAmount(stringPurchaseAmount);
    }

    public int injectCount(int purchaseAmount) {
        return purchaseAmount / AMOUNT_UNIT;
    }

    public Lotto inputLottoNumbers() {
        lottoNumbers.clear();
        Arrays.stream(Console.readLine().split(",")).toList()
                .forEach(s -> lottoNumbers.add(Integer.valueOf(s)));

        return new Lotto(lottoNumbers);
    }

    public int inputBonusNumber() {
        int bonusNumber = Integer.parseInt(Console.readLine());
        validateBonusNumber(lottoNumbers, bonusNumber);
        return bonusNumber;
    }
}