package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class LottoInput {
    public int getLottoPrice(){
        PrintInput printInput = new PrintInput();
        printInput.printLottoMoney();
        String s = Console.readLine();
        return Integer.parseInt(s);
    }
}
