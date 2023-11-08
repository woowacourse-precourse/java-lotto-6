package lotto.input;

import java.util.ArrayList;
import java.util.List;
import lotto.LottoConstants;
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

        // 로또 가격으로 나누어 떨어지는 지 검증
        validate.validateDivideNumber(money, LottoConstants.PRICE_FOR_ONE_LOTTO);

        return money;
    }


    public List<Integer> inputWinningNumber() {
        List<Integer> winningNumber = new ArrayList<>();
        for (String inputNumber : inputGenerator.readLine().split(",", -1)) {
            // Integer 자료형 인지 검증
            validate.validateInteger(inputNumber);

            // 양의 값인지 검증
            int number = Integer.parseInt(inputNumber);
            validate.validatePositiveNumber(number);

            // 1 ~ 45 사이의 숫자인지 검증
            validate.validateNumberInRange(number, LottoConstants.MIN_LOTTO_NUMBER, LottoConstants.MAX_LOTTO_NUMBER);

            winningNumber.add(number);
        }

        // 리스트에 중복된 값이 있는지 검증
        validate.validateDuplicatedOfList(winningNumber);

        return winningNumber;
    }

    public int bonusNumber() {
        String input = inputGenerator.readLine();

        // Integer 자료형 인지 검증
        validate.validateInteger(input);

        // 양의 값인지 검증
        int bonusNumber = Integer.parseInt(input);
        validate.validatePositiveNumber(bonusNumber);

        // 1 ~ 45 사이의 숫자인지 검증
        validate.validateNumberInRange(bonusNumber, LottoConstants.MIN_LOTTO_NUMBER, LottoConstants.MAX_LOTTO_NUMBER);

        return bonusNumber;
    }
}
