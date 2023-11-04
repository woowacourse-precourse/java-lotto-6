package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.domain.LottoMoney;
import lotto.exception.InputNumberException;

import java.util.List;

public class InputView {
    public static LottoMoney showMoney() {
        while (true) {
            System.out.println("구입금액을 입력해 주세요.");
            String read = Console.readLine();
            try {
                int num = Integer.parseInt(read);
                validateNum(num);
                int count = num / 1000;
                LottoMoney lottoMoney = new LottoMoney(num, count);
                return lottoMoney;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 잘못된 금액을 입력하셨습니다.");
                continue;
            }
        }
    }

    public static void validateNum(int num) {
        if (num % 1000 != 0) {
            throw new InputNumberException();
        }
    }

    public static void viewNumber(LottoMoney lottoMoney) {
        System.out.println();
        for (List<Integer> number : lottoMoney.getNumbers()) {
            System.out.println(number);
        }
        System.out.println();
    }
}
