package lotto.view.inputView;
import camp.nextstep.edu.missionutils.Console;
import lotto.model.validator.FirstInputValidator;

public class LottoPurchaseInput {

    public int requestPurchaseAmount() {
        System.out.println("로또 구매 금액을 입력해주세요");
        String input = Console.readLine();
        return FirstInputValidator.validatePurchaseAmount(input);
    }
}
