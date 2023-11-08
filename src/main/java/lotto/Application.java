package lotto;

import java.util.List;

import static lotto.Lotto.inputCoin;
import static lotto.Lotto.toChangeLotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int coin = inputCoin();
        List<Lotto> lottoList = toChangeLotto(coin);    //구매금액 입력
    }
}
