package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import static lotto.util.Parser.*;

public class InputView {

    public int requestMoney() throws IllegalArgumentException{
        System.out.println("구입금액을 입력해 주세요");
        return stringToInt(Console.readLine());
    }

    public List<Integer> requestWinningNumbers() throws IllegalArgumentException{
        System.out.println("당첨 번호를 입력해 주세요.");
        return stringToList(Console.readLine());
    }

    public int requestBonusNumber() throws IllegalArgumentException{
        System.out.println("보너스 번호를 입력해 주세요.");
        return stringToInt(Console.readLine());
    }
}
