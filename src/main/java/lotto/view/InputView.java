package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.BonusNumber;
import lotto.model.LottoPrice;
import lotto.model.WinningNumber;



public class InputView {
    public LottoPrice getLottoPrice() {
        String input = Console.readLine();
        return new LottoPrice(input);
    }

    public WinningNumber getWinningNumbers() {
        String line = Console.readLine();
        return new WinningNumber(line);
    }

    public BonusNumber getBonusNumber() {
        return new BonusNumber(Console.readLine());
    }
}
