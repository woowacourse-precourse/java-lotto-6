package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.domain.Price;
import lotto.domain.WinningLotto;
import lotto.util.LottoGenerator;
import lotto.util.LottoUtil;

public class InputView {

    public static Price getPurchasePrice() {
        int purchasePrice = 0;
        boolean isValidInput = false;

        while (!isValidInput) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                String input = Console.readLine();
                purchasePrice = LottoUtil.parseInteger(input);
                isValidInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return new Price(purchasePrice);
    }

    public static WinningLotto getWinningLottoNumbers() {
        Lotto winningLotto = getValidatedWinningNumbers();
        int bonusNumber = getValidatedBonusNumber(winningLotto);

        return new WinningLotto(winningLotto, bonusNumber);
    }

    private static Lotto getValidatedWinningNumbers() {
        while (true) {
            try {
                System.out.println("당첨번호를 입력해주세요.");
                String winningNumbersInput = Console.readLine();
                return LottoGenerator.generateWinningLottoNumbers(winningNumbersInput);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static int getValidatedBonusNumber(Lotto winningLotto) {
        while (true) {
            try {
                System.out.println("\n보너스번호를 입력해주세요.");
                String bonusNumberInput = Console.readLine();
                return LottoUtil.parseLottoBonusNumber(bonusNumberInput, winningLotto);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
