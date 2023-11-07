package lotto.broadcaster;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.Validator;

public class Broardcaster {
    public String[] pickLotteryNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String inputLotteryNumbers = Console.readLine();
        Console.close();
        if (!Validator.validateNumberAndSize(inputLotteryNumbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        String[] result = inputLotteryNumbers.split(",");
        if (Validator.isDuplicate(result)) {
            throw new IllegalArgumentException("[ERROR] 중복된 로또 번호가 존재합니다.");
        }

        return result;
    }
}
