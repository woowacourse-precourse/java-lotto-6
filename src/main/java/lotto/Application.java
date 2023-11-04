package lotto;

import lotto.domain.LottoIssuer;

public class Application {
    public static void main(String[] args) {
        LottoIssuer lottoIssuer = new LottoIssuer();

        lottoIssuer.buy(10000);
    }
}
