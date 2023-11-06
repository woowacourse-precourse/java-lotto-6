package lotto.io;

import camp.nextstep.edu.missionutils.Console;

public class LottoInputReader {

    public LottoInputReader(){}
    public String readerLottoPrice(){
        System.out.println("구매할 로또 금액을 입력하세요(1000원 단위)");
        return Console.readLine();
    }
    public String readerLottoMasterNumbers(){
        System.out.println("당첨 번호를 입력 하세요. 번호는 쉼표(,)를 기준으로 구분.");
        return Console.readLine();
    }
    public String readerChoiceLottoBonusNumber(){
        System.out.println("보너스 번호를 입력하세요.");
        return Console.readLine();
    }

}
