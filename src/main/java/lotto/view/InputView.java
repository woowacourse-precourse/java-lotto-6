package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    public String inputAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return readLine();
    }

    public String inputLottoNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return readLine();
    }

    public String inputLottoNumberBonus() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return readLine();
    }
}