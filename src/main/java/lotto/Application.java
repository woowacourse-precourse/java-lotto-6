package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        int money = 0;
        int lottoTickets = 0;

        do {
            System.out.println("구입금액을 입력해 주세요.");
            money = checkMoneyValidate(Console.readLine());
        } while (money == 0);
        System.out.println();

        lottoTickets = money / 1000;
        System.out.println(lottoTickets + "개를 구매했습니다.");

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoTickets; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }

        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
        System.out.println();

        Lotto winning;
        do {
            System.out.println("당첨 번호를 입력해 주세요.");
            winning = winningNumbersValidate(Console.readLine());
        } while (winning == null);
        System.out.println();
    }


    public static int checkMoneyValidate(String input) {
        int money = 0;
        try {
            money = isOnlyNumber(input);
            isDivisibleBy1000(money);
        } catch (IllegalArgumentException e) {
            money = 0;
            System.out.println(e.getMessage());
        }
        return money;
    }

    private static int isOnlyNumber(String input) {
        int number = 0;
        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자로 입력해야 합니다.");
        }
        return number;
    }

    private static void isDivisibleBy1000(int input) {
        if ((input % 1000) != 0 || input <= 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.");
        }
    }

    public static Lotto winningNumbersValidate(String input) {
        Lotto winningNumbers = null;
        try {
            winningNumbers = new Lotto(checkInteger(input));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return winningNumbers;
    }

    private static List<Integer> checkInteger(String input) {
        List<Integer> parseNumbers = new ArrayList<>();
        try {
            for (String number : List.of(input.split(","))) {
                int n = Integer.parseInt(number.trim());
                parseNumbers.add(n);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 숫자로 입력해 주세요.");
        }
        return parseNumbers;
    }
}
