package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.BonusNumber;
import lotto.model.LottoPrice;
import lotto.model.WinningNumber;
import lotto.util.exception.CustomException;


public class InputView {
    public LottoPrice getLottoPrice() {
        String input;
        do {
            input = Console.readLine();
        } while (!isValidLottoPrice(input));
        return new LottoPrice(input);

    }

    private boolean isValidLottoPrice(String input) {
        try {
            new LottoPrice(input);
            return true;
        } catch (CustomException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public WinningNumber getWinningNumbers() {
        String input;
        do{
            input = Console.readLine();
        } while (!isValidWinningNumbers(input));
        return new WinningNumber(input);
    }

    private boolean isValidWinningNumbers(String input) {
        try {
            new WinningNumber(input);
            return true;
        } catch (CustomException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public BonusNumber getBonusNumber() {
        String input;
        do {
            input = Console.readLine();
        } while (!isValidBonusNumber(input));
        return new BonusNumber(input);
    }

    private boolean isValidBonusNumber(String input) {
        try {
            new BonusNumber(input);
            return true;
        } catch (CustomException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
