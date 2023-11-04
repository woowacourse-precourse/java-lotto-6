package lotto;

import camp.nextstep.edu.missionutils.Console;

public class LottoGame {

    private LottoController lc;

    public void start(){
        lc = new LottoController();
        System.out.println("구입금액을 입력해 주세요.");
        lc.validatePrice(Console.readLine());
        lc.buyLotto();
    }

    public void pickNumber(){

    }

    public void end(){
        Console.close();
    }

}
