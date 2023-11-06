package lotto;

import camp.nextstep.edu.missionutils.Console;

public class LottoSetting {
    private int lottoCount;

    public void buy() {
        System.out.println("구입 금액을 입력 해 주세요.");
        String m = Console.readLine();

        try {
            moneyValidate(m);
            lottoCount = Integer.parseInt(m) / 1000;
            System.out.println();
            System.out.println(lottoCount + "개를 구매 했습니다.");
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            buy();
        }
    }

    public void moneyValidate(String money) {
        if (!money.matches("\\d+")) {
            throw new IllegalArgumentException("[Error] 숫자만 입력 가능합니다.");
        }

        int buy = Integer.parseInt(money);
        if (buy % 1000 != 0) {
            throw new IllegalArgumentException("[Error] 로또는 1000원 단위로 구매 할 수 있습니다.");
        }
    }
}
