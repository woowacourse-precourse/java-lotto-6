package lotto;

import camp.nextstep.edu.missionutils.Console;

public class SettingLotto {
    private int lottoCount;
    public void buy() {
        System.out.println("구입 금액을 입력 해 주세요.");
        String m = Console.readLine();
        int money = Integer.parseInt(m);
        lottoCount =  money / 1000;

        System.out.println();
        System.out.println(lottoCount + "개를 구매 했습니다.");
    }
}
