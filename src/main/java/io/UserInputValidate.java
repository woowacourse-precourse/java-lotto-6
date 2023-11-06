package io;

import java.util.*;

import static io.UserInput.*;

public class UserInputValidate {
    static final int minLotteryNum = 1;
    static final int maxLotteryNum = 45;
    static final int lotteryCost = 1000;

    static int userMoneyAmount(String userMoney) {
        int userMoneyAmount;
        try {
            userMoneyAmount = Integer.parseInt(userMoney);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("[ERROR] 입력 금액은 정수여야 합니다.");
        }
        if (userMoneyAmount < 0)
            throw new IllegalArgumentException("[ERROR] 입력 금액은 자연수여야 합니다.");
        if (userMoneyAmount % lotteryCost != 0)
            throw new IllegalArgumentException("[ERROR] 입력 금액은 1000의 배수여야 합니다.");

        return userMoneyAmount;
    }

}
