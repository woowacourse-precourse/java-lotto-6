package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class LottoGame {
    LottoResult lottoResult;

    public LottoGame() {
        start();
        lottoResult = new LottoResult();
    }

    private void start() {
        long userLottoPrice = readLottoPrice();
        long lottoPrice = lottoResult.lottoNumbersPurchased(userLottoPrice);
        System.out.println(lottoPrice + "개를 구매했습니다.");

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
