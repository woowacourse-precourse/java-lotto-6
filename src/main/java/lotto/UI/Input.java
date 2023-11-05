package lotto.UI;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public int inputPrice(){
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }
}
