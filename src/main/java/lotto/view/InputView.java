package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String askPaymentAmount() {
        System.out.println("1,000원 단위의 로또 구매 금액을 입력해주세요.");
        return Console.readLine();
    }

    public String askAnswerLottoNumbers() {
        System.out.println("쉼표(,)를 구분자로 6자리 당첨 번호를 입력해주세요.");
        return Console.readLine();
    }

    public String askBonusNumber() {
        System.out.println("보너스 번호 1자리를 입력해주세요.");
        return Console.readLine();
    }
}
