package lotto.UI;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Input {
    public int inputPrice(){
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }

    public String[] inputLottoNumbers(){
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine().split(",");
    }

    public String inputBonusNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }
}
