package lotto.input;

import lotto.generator.InputGenerator;

public class Input {
    private InputGenerator inputGenerator;

    public Input(InputGenerator inputGenerator) {
        this.inputGenerator = inputGenerator;
    }

    // 로또 구입 금액을 입력받는다.
    public int inputLottoMoney() {
        int money = Integer.parseInt(inputGenerator.readLine());

        return money;
    }
}
