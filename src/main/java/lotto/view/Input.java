package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Input {
    public int money() {
        System.out.println("구입금액을 입력해 주세요.");
        return Converter.stringToInt(Console.readLine());
    }

    public List<Integer> winLottoNumbers() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
        return Converter.stringToListInteger(Console.readLine());
    }

    public int bonusNumber() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        return Converter.stringToInt(Console.readLine());
    }
}
