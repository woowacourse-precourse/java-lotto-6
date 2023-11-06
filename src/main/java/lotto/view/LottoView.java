package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Lottos;

public class LottoView {
    private static final String PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String NOT_NUMBER_ERROR_MESSAGE = "[ERROR] 구입 금액은 숫자를 입력해야 합니다.";

    public LottoView() {}

    public int inputMoney() {
        int money; // 여기도 그냥 문자열로 입력 받고 예외처리는 컨트롤러에서?
        System.out.println(PURCHASE_AMOUNT);

        while(true) {
            try {
                money = Integer.parseInt(Console.readLine());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(NOT_NUMBER_ERROR_MESSAGE);
            }
        }

        return money;
    }

    public void printLottoNumbers(Lottos lottos) {
        System.out.println(lottos.getSize() + "개를 구매했습니다.");
        System.out.println(lottos);
    }

    public String inputWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }
}
