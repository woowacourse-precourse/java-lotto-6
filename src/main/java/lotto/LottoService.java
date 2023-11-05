package lotto;

import camp.nextstep.edu.missionutils.Console;

public class LottoService {

    public Integer moneyInput() {
        System.out.print("구입금액을 입력해 주세요 : ");
        return Integer.parseInt(Console.readLine());
    }

    public int lottoCount(int moneyInput) {
        int lottoCount = moneyInput / 1000;
        System.out.printf("%d개를 구입했습니다.\n", lottoCount);
        return lottoCount;
    }




}
