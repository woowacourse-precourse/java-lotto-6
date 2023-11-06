package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

public class InputManager {
    public String inputLottoDrawNumber(){
        System.out.print("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }
    public String inputLottoDrawBonusNumber(){
        System.out.print("보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }


}
