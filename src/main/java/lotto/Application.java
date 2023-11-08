package lotto;

import camp.nextstep.edu.missionutils.Console;
import inputprocess.Lotto;
import inputprocess.LottoNumberMaker;
import inputprocess.MoneyInput;

public class Application {
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");

        MoneyInput inputMoney = new MoneyInput();
        System.out.println();
        System.out.printf("%d개를 구매했습니다.",MoneyInput.money / 1000);
        System.out.println();
        LottoNumberMaker lotto = new LottoNumberMaker();
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
        String Number = Console.readLine();
        Lotto matchLotto = new Lotto(Number);









    }
}
