package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import static lotto.util.Parser.stringToInt;
import static lotto.util.Parser.stringToList;

public class InputView {

    public int requestMoney() {
        System.out.println("구입금액을 입력해 주세요");
        return stringToInt(Console.readLine());
    }

    public List<Integer> requestWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return stringToList(Console.readLine());
    }

    public int requestBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return stringToInt(Console.readLine());
    }
}
