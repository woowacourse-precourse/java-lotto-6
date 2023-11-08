package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;
import util.StringParser;

public class LottoGame {
    private final LottoVendor lottoVendor = new LottoVendor(LottoEnum.PRICE.getValue());
    private Integer money;

    public List<Lotto> purchaseLotto() {
        System.out.println("구입금액을 입력해 주세요.");
        while (true) {
            try {
                money = getMoney();
                return lottoVendor.purchaseAll(money);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Integer getMoney() {
        while (true) {
            try {
                return StringParser.toInteger(readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
