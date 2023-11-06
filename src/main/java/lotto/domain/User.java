package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static lotto.validation.PurchaseAmountCheckValidator.*;
import static lotto.validation.NumberCheckValidator.*;

public class User {
    private static User user;

    List<Integer> winningNumbers = new ArrayList<>();

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
        return purchaseAmount / 1_000;
    }

    public Lotto inputWinningNumbers() {
        winningNumbers.clear();
        Arrays.stream(Console.readLine().split(",")).toList()
                .forEach(s -> winningNumbers.add(Integer.valueOf(s)));

        return new Lotto(winningNumbers);
    }

    public int inputBonusNumber() {
        int bonusNumber = Integer.parseInt(Console.readLine());
        validateBonusNumber(winningNumbers, bonusNumber);
        return bonusNumber;
    }
}