package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        int PRICE_LOTTO = 1000;
        Console console = new Console();

        int purchaseAmount = getPurchaseAmount(console);
        int numberOfLottos = purchaseAmount / PRICE_LOTTO;

        List<Lotto> lottos = buyLottos(numberOfLottos);
        printLottos(lottos);


    }

    private static int getPurchaseAmount(Console console) {
        int purchaseAmount;
        while (true) {
            try {
                System.out.println("구입 금액을 입력해 주세요.");
                purchaseAmount = Integer.parseInt(console.readLine());
                if (purchaseAmount % 1000 != 0) {
                    throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1,000원 단위여야 합니다.");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자를 입력해 주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return purchaseAmount;
    }

    private static List<Lotto> buyLottos(int numberOfLottos) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < numberOfLottos; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }
        return lottos;
    }

    private static void printLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }
}
