package lotto.view;

import lotto.model.BonusNumber;
import lotto.CalculateLotto;
import lotto.InputViewHandler;
import lotto.model.Money;

public class InputView {

    private final InputViewHandler inputViewHandler;

    public InputView(){
        inputViewHandler = new InputViewHandler();
    }

    public Money inputLottoPrice(){
        System.out.println("구입금액을 입력해 주세요.");
        Money money = inputViewHandler.inputMoney();
        return money;
    }

    public CalculateLotto inputWinningNumber(){
        System.out.println("\n당첨 번호를 입력해 주세요.");
        CalculateLotto winninglotto = inputViewHandler.inputAnswerLotto();
        return winninglotto;
    }

    public BonusNumber inputBonusNumber(){
        System.out.println("\n보너스 번호를 입력해 주세요.");
        BonusNumber bonusNumber = inputViewHandler.inputBonusNumber();
        return bonusNumber;
    }
}
