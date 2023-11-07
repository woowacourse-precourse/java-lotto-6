package lotto.broadcaster;

import camp.nextstep.edu.missionutils.Console;

public class Broardcaster {
    public String[] pickLotteryNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String inputLotteryNumbers = Console.readLine();
        return inputLotteryNumbers.split(",");
    }
}
