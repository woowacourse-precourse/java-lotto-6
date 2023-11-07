package lotto.utils;

import lotto.domain.Lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Input {
    public static int readPurchaseAmount() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                String userInput = readLine();
                int amount = Validate.purchaseAmount(userInput);
                return amount / 1000;
            } catch (IllegalArgumentException e) {

            }
        }
    }

    public static Lotto readLottery() {
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                String userInput = readLine();
                String regex = ",";
                String[] numberStrings = userInput.split(regex);

                List<Integer> numbers = Arrays.stream(numberStrings)
                        .map(Validate::lotteryNumber)
                        .collect(Collectors.toList());

                return new Lotto(numbers);
            } catch (IllegalArgumentException e) {

            }
        }
    }

    public static int readBonusNumber(Lotto winningLottery) {
        while (true) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                String userInput = readLine();
                return Validate.bonusNumber(winningLottery, userInput);
            } catch (IllegalArgumentException e) {

            }
        }
    }

}
