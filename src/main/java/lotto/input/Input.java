package lotto.input;

import java.util.ArrayList;
import java.util.List;
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
        
        // 양의 값인지 검증
        int money = Integer.parseInt(input);
        validate.validatePositiveNumber(money);

        return money;
    }

    public List<Integer> inputWinningNumber() {
        List<Integer> winningNumber = new ArrayList<>();
        for(String number: inputGenerator.readLine().split(",", -1)) {

            // 1 ~ 45 사이의 숫자인지 검증
            
            // 리스트에 중복된 값이 있는지 검증

            winningNumber.add(Integer.parseInt(number));
        }

        return winningNumber;
    }
}
