package lotto;

import camp.nextstep.edu.missionutils.Console;

public class LottoGame {

    private LottoController lc;

    public void start(){
        lc = new LottoController();
        System.out.println("구입금액을 입력해 주세요.");
        boolean isValidated = lc.validatePrice(Console.readLine());
        if(isValidated) lc.buyLotto();
    }

    public void viewMyNumber(){

    }

    public void pickWinningNumber(){

    }

    public void end(){
        Console.close();
    }

}
