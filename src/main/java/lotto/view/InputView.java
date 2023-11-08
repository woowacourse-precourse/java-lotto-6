package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.BonusNumber;
import lotto.domain.LottoPrice;
import lotto.domain.WinningNumber;

public class InputView {
    public static LottoPrice getLottoPrice() {
        try {
            System.out.println("구입금액을 입력해 주세요.");
            String input = Console.readLine();
            return new LottoPrice(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getLottoPrice();
        }
    }

    public static WinningNumber getWinningNumber() {
        try {
            System.out.println("당첨 번호를 입력해 주세요.");
            String input = Console.readLine();
            return new WinningNumber(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getWinningNumber();
        }
    }

    public static BonusNumber getBonusNumber(WinningNumber winningNumber) {
        try {
            System.out.println("보너스 번호를 입력해 주세요.");
            String input = Console.readLine();
            return new BonusNumber(input, winningNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getBonusNumber(winningNumber);
        }
    }
}
