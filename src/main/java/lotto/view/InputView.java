package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Price;
import lotto.domain.WinningLotto;
import lotto.util.LottoGenerator;
import lotto.util.LottoUtil;

import java.util.List;

public class InputView {

    public static Price getPurchasePrice() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        int purchasePrice = LottoUtil.parseInteger(input);
        return new Price(purchasePrice);
    }

    public static WinningLotto getWinningLottoNumbers() {
        System.out.println("당첨번호를 입력해주세요.");
        String winningNumbersInput = Console.readLine();
        List<Integer> winningLottoNumbers = LottoGenerator.generateWinningLottoNumbers(winningNumbersInput);

        System.out.println("\n보너스번호를 입력해주세요.");
        String bonusNumberInput = Console.readLine();
        int bonusNumber = LottoUtil.parseLottoNumber(bonusNumberInput);

        return new WinningLotto(winningLottoNumbers, bonusNumber);
    }

}
