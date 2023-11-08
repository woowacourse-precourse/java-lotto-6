package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.Exception.ShouldNotCreatedClassException;

public class InputView {
    private InputView() {
        throw new ShouldNotCreatedClassException();
    }

    public static String inputPrice() {
        System.out.println("구입 금액을 입력해주세요.");
        return Console.readLine().trim();
    }

    public static String inputWinningLottoNumber() {
        System.out.println("당첨 번호를 입력해주세요.");
        return Console.readLine().trim();
    }

    public static String inputWinningBonusNumber() {
        System.out.println("보너스 번호를 입력해주세요.");
        return Console.readLine().trim();
    }
}
