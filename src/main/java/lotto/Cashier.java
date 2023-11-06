package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Cashier {
    public void sellLotto() {
        System.out.println("구입금액을 입력해 주세요.");
        Integer money = Integer.valueOf(Console.readLine());

        LottoMachine lottoMachine = new LottoMachine();
        lottoMachine.createLottoEnvelope(calculateLottoPrice(money));

        System.out.println(calculateLottoPrice(money) + "개를 구매했습니다.");


    }
    public Integer calculateLottoPrice(Integer money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException();
        }
        return money / 1000;
    }

    public Integer getWinningNumbers(List<Integer> winningNumbers) {

    }

    public Integer getBonusNumber(Integer bonusNumber) {

    }
}
