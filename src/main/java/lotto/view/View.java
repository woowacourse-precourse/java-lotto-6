package lotto.view;

import java.util.List;
import lotto.constant.ErrorMessage;
import lotto.constant.LottoConstant;
import lotto.model.Lotto;
import lotto.util.IntegerParser;

public class View {
    private InputView inputView;
    private OutputView outputView;

    public View() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public int getMoney() {
        while (true) {
            try {
                String inputMoney = inputView.getInputMoney();
                int money = IntegerParser.parse(inputMoney);
                validateMoney(money);
                return money;
            } catch (NumberFormatException e) {
                outputView.printErrorMessage(ErrorMessage.NOT_INTEGER_ERROR);
            } catch (IllegalArgumentException e) {
            }
        }
    }

    public void printLottosInfo(List<Lotto> lottos) {
        outputView.printLottoCountMessage(lottos.size());
        lottos.forEach(lotto -> outputView.printLottoNumber(lotto));
    }

    private void validateMoney(int money) {
        verifySufficientMoney(money);
        verifyDiviededByPrice(money);
    }

    private void verifySufficientMoney(int money) {
        if (money < LottoConstant.LOTTO_PRICE) {
            outputView.printErrorMessage(ErrorMessage.INSUFFICIENT_MONEY_ERROR);
            throw new IllegalArgumentException();
        }
    }

    private void verifyDiviededByPrice(int money) {
        if (money % LottoConstant.LOTTO_PRICE != 0) {
            outputView.printErrorMessage(ErrorMessage.INAPPROPRIATE_MONEY_ERROR);
            throw new IllegalArgumentException();
        }
    }
}
