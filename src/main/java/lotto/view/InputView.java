package lotto.view;


import camp.nextstep.edu.missionutils.Console;
import lotto.Validator;

public class InputView {

    private static InputView inputView = new InputView();

    private InputView() {

    }

    public static InputView getInstance() {
        return inputView;
    }

    public static String inputPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    public String inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public String inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }
}
