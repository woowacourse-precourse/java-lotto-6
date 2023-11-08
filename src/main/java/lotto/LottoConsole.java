package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class LottoConsole {

    private static final int LOTTO_PRICE = 1000;

    public static void start() {
        while (true) {
            try {
                int number = numberOfPurchases();
                System.out.println("\n" + number + "개를 구매했습니다.");

                List<Lotto> lottos = new ArrayList<>(number);
                for (int i = 0; i < number; i++) {
                    lottos.add(Lotto.buy());
                }

                LottoView.printOf(lottos);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static boolean isNotFit(int leftNumber, int rightNumber) {
        return leftNumber % rightNumber != 0;
    }

    public static int numberOfPurchases() {
        System.out.println("구입금액을 입력해 주세요.");
        int number = of(Console.readLine());
        if (isNotFit(number, LOTTO_PRICE)) {
            throw new IllegalArgumentException("[ERROR] 로또는 1000원 단위로 구매 가능합니다.");
        }
        return number / LOTTO_PRICE;
    }

    public static int of(String word) {
        int number;
        try {
            number = Integer.parseInt(word);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }
        return number;
    }

//    public static Lotto getWinningNumber() {
//        System.out.println("구입금액을 입력해 주세요.");
//
//    }

}
