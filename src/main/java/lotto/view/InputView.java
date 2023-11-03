package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningNumber;

public class InputView {

    public PurchaseAmount inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String purchaseAmount = Console.readLine();
        return new PurchaseAmount(Integer.parseInt(purchaseAmount));
    }

    public WinningNumber inputLottoWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNumbers = Console.readLine();
        return new WinningNumber(Integer.parseInt(winningNumbers));
    }
}