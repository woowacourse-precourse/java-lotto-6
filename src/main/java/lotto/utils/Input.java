package lotto.utils;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Input {
    public static int readPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String userInput = readLine();
        return Validate.purchaseAmount(userInput) / 1000;
    }

    public static Lotto readLottery() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String userInput = readLine();
        String regex = ",";
        String[] numberStrings = userInput.split(regex);
        List<Integer> numbers = new ArrayList<>();

        for (String numberString : numberStrings) {
            int number = Validate.lotteryNumber(numberString);
            numbers.add(number);
        }

        return new Lotto(numbers);
    }

    public static int readBonusNumber(Lotto winningLottery) {
        System.out.println("보너스 번호를 입력해 주세요.");
        String userInput = readLine();
        return Validate.bonusNumber(winningLottery, userInput);
    }

}
