package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class LottoView {
    public int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요");
        return Integer.parseInt(Console.readLine());
    }

    public void printPurchasedLottoNumbers(int number, Lotto[] lottos) {
        System.out.println(number + "개를 구매했습니다");
        for (int i = 0; i < number; i++) {
            lottos[i].getNumbers();
        }
    }

    public String inputWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public Integer inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요");
        return Integer.parseInt(Console.readLine());
    }




}
