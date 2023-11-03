package lotto.input;

import lotto.generator.InputGenerator;
import lotto.validate.Validate;

public class Input {
    private InputGenerator inputGenerator;
    private Validate validate;

    public Input(InputGenerator inputGenerator, Validate validate) {
        this.inputGenerator = inputGenerator;
        this.validate = validate;
    }

    // 로또 구입 금액을 입력
    public int inputLottoMoney() {
        String input = inputGenerator.readLine();

        // Integer 자료형 인지 검증
        validate.validateInteger(input);
        int money = Integer.parseInt(input);

        return money;
    }
}
