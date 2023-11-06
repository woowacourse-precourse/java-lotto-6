package lotto.io;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Checker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IOOperation {
    public static Integer getPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        Integer price;

        while (true) {
            try {
                price = Integer.parseInt(Console.readLine());
                Checker.priceCorrect(price);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }

            break;
        }

        return price;
    }

    public static List<Integer> getWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> winningNumbers = new ArrayList<>();

        while (true) {
            try {
                String input = Console.readLine();
                Arrays.asList(input.split(","))
                        .forEach((value) -> {
                            winningNumbers.add(Integer.parseInt(value));
                        });

                Checker.winningSix(winningNumbers);
                Checker.winningInRange(winningNumbers);
                Checker.winningNotDuplicated(winningNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());

                continue;
            }
            break;
        }
        return winningNumbers;
    }
}
