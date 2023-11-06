package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private static final Player player = new Player();
    private static final List<Lotto> lottos = new ArrayList<>();

    public static void play() {
        inputLottoPurchaseAmount();
        issueLottos();
        printLottos();
    }

    private static void inputLottoPurchaseAmount() {
        while (true) {
            System.out.println("구매금액을 입력해 주세요.");
            String input = Console.readLine();

            try {
                player.setPurchaseAmount(input);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 로또 구매 금액은 1,000원 단위의 숫자여야 합니다.");
            }
        }
    }

    private static void issueLottos() {
        int lottoCount = player.getPurchaseLottoCount();

        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto(getRandomNumbers()));
        }
    }

    private static List<Integer> getRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(Lotto.MINIMUM_NUMBER, Lotto.MAXIMUM_NUMBER, Lotto.NUMBERS_SIZE);
    }

    private static void printLottos() {
        System.out.println("\n" + lottos.size() + "개를 구매했습니다.");

        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }
}
