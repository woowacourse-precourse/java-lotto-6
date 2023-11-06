package game;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;

public class GameService {

    public void play() {

        System.out.println("구입금액을 입력해 주세요.");
        int price = getPrice();

        List<Lotto> lottos = createLottoByPrice(price);
        getLottoByPrice(lottos);


    }

    public int getPrice() {
        int price = 0;
        while (price == 0) {
            try {
                String priceInput = Console.readLine();
                if (Integer.parseInt(priceInput) % 1000 == 0) {
                    price = Integer.parseInt(priceInput);
                    return price;
                }
                throw new IllegalArgumentException("Price must be a multiple of 1000");
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e);
            }
        }
        return price;
    }

    public List<Lotto> createLottoByPrice(int price) {
        List<Lotto> lottos = new ArrayList<>();
        int createLottoNumber = price / 1000;
        System.out.println(createLottoNumber + "개를 구매했습니다.");

        for (int i = 0; i < createLottoNumber; i++) {
            List<Integer> newLotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(newLotto));
        }

        return lottos;
    }

    public void getLottoByPrice(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getLotto());
        }
    }

}
