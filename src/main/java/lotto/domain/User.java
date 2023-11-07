package lotto.domain;

import lotto.function.Parser;
import lotto.function.UIFunction;

import java.util.List;

public class User {
    public User() {}

    public List<Lotto> buyLotto() {
        try {
            String inputPayment = UIFunction.requestInput("구입 금액을 입력해 주세요.");
            int payment = Parser.toInteger(inputPayment);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return buyLotto();
        }
    }
}