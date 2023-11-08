package lotto;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        Purchase purchase;
        Lotto lotto;
        Winning winning;

        try {
            while (true) {
                try {
                    System.out.println("구입금액을 입력해 주세요.");
                    purchase = new Purchase(Integer.parseInt(readLine()));
                    break;
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("[ERROR] " + e.getMessage());
                }
            }

            System.out.println("\n당첨 번호를 입력해 주세요.");
            // todo
            String[] input = readLine().split(",");

            List<Integer> numbers = new ArrayList<>();
            for (String str : input) {
                numbers.add(Integer.parseInt(str));
            }
            ////////
            lotto = new Lotto(numbers);

            System.out.println("\n보너스 번호를 입력해 주세요.");
            int bonus = Integer.parseInt(readLine());

            System.out.println("\n당첨 통계");
            System.out.println("---");
            winning = new Winning(purchase, lotto, bonus);
            winning.print();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR]");
        }
    }
}
