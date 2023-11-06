package io;

import java.util.*;

import static io.UserInput.*;

public class UserInputValidate {
    static final int minLotteryNum = 1;
    static final int maxLotteryNum = 45;
    static final int lotteryCost = 1000;
    static final int lotteryNumLength = 6;

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

    static List<String> winLotteryDuplicateAndLength(String winningLotteryInput) {
        List<String> winningLottery = Arrays.asList(winningLotteryInput.split(","));
        Set<String> removeDuplicatedNum = new HashSet<>(winningLottery);

        if(winningLottery.size() != removeDuplicatedNum.size())
            throw new IllegalArgumentException("[ERROR] 당첨 숫자에는 중복된 수가 없어야 합니다.");
        if (winningLottery.size() != lotteryNumLength)
            throw new IllegalArgumentException("[ERROR] 당첨 숫자는 6개 입니다.");

        winLotteryRange(winningLotteryInput);
        return winningLottery;
    }

    static List<String> winLotteryRange(String winningLotteryInput) {
        List<String> winningLottery = Arrays.asList(winningLotteryInput.split(","));

        int lotteryNum;
        for (String lottery : winningLottery) {
            try {
                lotteryNum = Integer.parseInt(lottery);
            } catch (NumberFormatException exception) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자여야 합니다");
            }
            if (lotteryNum < minLotteryNum || lotteryNum > maxLotteryNum)
                throw new IllegalArgumentException("[ERROR] 당첨 번호의 범위는 1부터 45까지입니다.");
        }

        return winningLottery;
    }

    static List<Integer> makeWinningLottery(List<String> winningLottery) {
        List<Integer> winningLotteryNumber = new ArrayList<Integer>();

        for (String num: winningLottery) {
            winningLotteryNumber.add(Integer.parseInt(num));
        }

        return winningLotteryNumber;
    }


    static int bonusNumCheck(String bonusInput, List<Integer> winningLotteryNum) {
        int bonusNumber;
        try {
            bonusNumber = Integer.parseInt(bonusInput);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 정수여야 합니다.");
        }
        for (int lotteryNum:winningLotteryNum) {
            if (lotteryNum == bonusNumber)
                throw new IllegalArgumentException("[ERROR] 보너스 번호와 당첨 로또 번호는 중복되면 안됩니다.");
        }
        if (bonusNumber < minLotteryNum || bonusNumber > maxLotteryNum)
            throw new IllegalArgumentException("[ERROR] 보너스 번호의 범위는 1부터 45까지입니다.");

        return bonusNumber;
    }

}
