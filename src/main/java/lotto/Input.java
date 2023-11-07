package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Input {
    public static int getPrice() {
        int purchase = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.println("구입금액을 입력해 주세요.");
            try {
                purchase = Integer.parseInt(Console.readLine());
                validInput = true;
            } catch (NumberFormatException e) {
                new IllegalArgumentExceptionHandler("구입 금액은 정수만 가능합니다.");
            }
        }

        return purchase;
    }

    public static List<Integer> getLotteryNums() {
        List<Integer> lotteryList = new ArrayList<>();
        boolean validInput = false;

        while (!validInput) {
            try {
                String lotteryInput = Console.readLine();
                List<String> lotteryString = List.of(lotteryInput.split(","));
                lotteryString = lotteryString.stream().distinct().collect(Collectors.toList());

                lotteryList.clear();
                for (String number : lotteryString) {
                    lotteryList.add(Integer.parseInt(number));
                }

                validInput = Lotto.validate(lotteryList);
            } catch (NumberFormatException e) {
                new IllegalArgumentExceptionHandler("로또 번호는 정수여야 합니다.");
            }
        }
        return lotteryList;
    }
}
