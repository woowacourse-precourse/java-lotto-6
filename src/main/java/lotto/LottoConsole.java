package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoConsole {

    private static final int LOTTO_PRICE = 1000;

    public static void start() {
        int number = numberOfPurchases();

        List<Lotto> lottos = new ArrayList<>(number);

        for (int i = 0; i < number; i++) {
            lottos.add(Lotto.buy());
        }
        printOf(lottos);

        Lotto win = getWinningNumber();
        int bonus = getBonusNumber();

        
    }

    public static int getBonusNumber() {
        int number = 0;
        while (number < 1) {
            System.out.println("\n보너스 번호를 입력해 주세요.");
            number = numberOf(Console.readLine());
        }
        return number;
    }

    public static void printOf(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public static int numberOfPurchases() {
        System.out.println("구입금액을 입력해 주세요.");
        int number = 0;
        while (number == 0) {
            try {
                number = purchase(numberOf(Console.readLine()));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return number;
    }

    public static int purchase(int money) {
        if (money % LOTTO_PRICE != 0 || money < 1) {
            throw new IllegalArgumentException("[ERROR] 로또는 " + LOTTO_PRICE + "원 단위로 구매 가능합니다.");
        }
        return money / LOTTO_PRICE;
    }

    public static int numberOf(String word) {
        int number;
        try {
            number = Integer.parseInt(word);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }
        return number;
    }

    public static Lotto getWinningNumber() {
        Lotto lotto = null;
        while (lotto == null) {
            try {
                System.out.println("\n당첨 번호를 입력해 주세요.");
                lotto = winningLotto(Console.readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return lotto;
    }

    public static Lotto winningLotto(String line) {
        List<Integer> numbers = Arrays.stream(line.split(","))
                .map(LottoConsole::numberOf)
                .collect(Collectors.toList());
        return new Lotto(numbers);
    }

}
