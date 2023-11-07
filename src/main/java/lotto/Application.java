package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final int LOTTO_PRICE = 1_000;
    private static final int LOTTO_SIZE = 6;
    private static int purchasedPrice;

    public static void main(String[] args) {

        readPurchasedPrice();
        List<Lotto> lottos = createLottos(purchasedPrice);
        printLottoNumbers(lottos);


    }

    public static void readPurchasedPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        purchasedPrice = Integer.parseInt(Console.readLine());
    }

    public static int getPurchasedPrice() {
        return purchasedPrice;
    }

    private static List<Lotto> createLottos(int purchasedPrice) {
        int lottoCount = purchasedPrice / LOTTO_PRICE;
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, LOTTO_SIZE);
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }

    private static void printLottoNumbers(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }
}
