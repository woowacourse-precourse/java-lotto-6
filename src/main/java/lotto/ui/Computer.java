package lotto.ui;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.Lotto;

public class Computer {

    public String getInput() {
        return Console.readLine();
    }




    // 2. 로또 수량 계산 로직
    public Integer calculateLotto(Integer money) {
        Integer lottoCount = money / 1000;
        System.out.println(lottoCount + "개를 구매했습니다.");
        return lottoCount;
    }

    public Lotto calculateLottoNumber() {

        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));

    }


}
