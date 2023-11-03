package lotto.View;

import camp.nextstep.edu.missionutils.Console;
import lotto.Model.Price;
import lotto.Model.PriceValidator;

public class InputView {

    public static Price inputPriceForLotto() {
        System.out.println("구입금액을 입력해 주세요.");
        try {
            PriceValidator priceValidator = new PriceValidator(Console.readLine());
            return new Price(priceValidator.getInputPrice());
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 1000원 단위로 1000원~20억원 사이에서 입력해주세요.");
            return inputPriceForLotto();
        }
    }

}
