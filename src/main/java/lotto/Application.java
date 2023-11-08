package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        //로또 구입 금액 입력
        String money = Console.readLine();
        //로또 구수
        LottoManage bought_lotto=new LottoManage(money);
    }
}
