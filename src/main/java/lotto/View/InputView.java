package lotto.View;

import camp.nextstep.edu.missionutils.Console;
import lotto.Exception.PlayerBuyingPayException;
import lotto.Util.InputNumberParser;

public class InputView {
    private final PlayerBuyingPayException playerBuyingPayException = new PlayerBuyingPayException();

    public int buyingPayConsole() {
        try {
            String buyingPrice = Console.readLine();
            if (buyingPrice.isEmpty()) {
                throw new IllegalArgumentException("[ERROR] 구입 금액을 입력해주세요.");
            }

            playerBuyingPayException.checkPlayerBuyingPay(buyingPrice);
            return InputNumberParser.StringToInt(buyingPrice);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위의 숫자로 입력해야 합니다.");
        }
    }

    public String playerLottoNumbersConsole() {
        String lottoNumbers = Console.readLine();
        return lottoNumbers;
    }

    public String playerBonusNumberConsole() {
        String bonusNumber = Console.readLine();
        return bonusNumber;
    }
}
