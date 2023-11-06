package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String askPaymentAmount() {
        return Console.readLine();
    }

    public String askAnswerLottoNumbers() {
        return Console.readLine();
    }

    public String askBonusNumber() {
        System.out.println("보너스 번호를 입력해주세요.");
        return Console.readLine();
    }
}
