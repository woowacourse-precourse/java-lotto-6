package lotto.domain;

import static lotto.domain.Lottos.generateLottos;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class LottoGame {
    LottoResult lottoResult;

    public LottoGame() {
        lottoResult = new LottoResult();

        start();
    }

    private void start() {
        long userLottoPrice = readLottoPrice();
        long lottoCount = lottoResult.lottoNumbersPurchased(userLottoPrice);
        System.out.println(lottoCount + "개를 구매했습니다.");

        Lottos purchasedLottos = generateLottos(lottoCount);
    }

    private static int readLottoPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        int price = Integer.parseInt(Console.readLine());

        if(price % 1000 !=0) {
            throw new IllegalArgumentException("[ERROR] 1,000원 단위로 입력해주세요.");
        }
        return price;
    }

}
