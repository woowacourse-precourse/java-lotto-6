package lotto.model;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.LottoConstants;
import lotto.domain.Lotto;
import lotto.validator.InputValidator;
import lotto.validator.NumberValidator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Input {
    private final InputValidator inputValidator;
    private final NumberValidator numberValidator;

    public Input(InputValidator inputValidator, NumberValidator numberValidator) {
        this.inputValidator = inputValidator;
        this.numberValidator = numberValidator;
    }

    // Input : 1090 / Result : [ERROR] 출력 이후 다시 데이터 받음
    public int inputAmountType() {
        String input = Console.readLine();
        int amount = 0;
        try {
            inputValidator.validateInputType(input);
            amount = Integer.parseInt(input);
            inputValidator.validateInputData(amount);
        } catch (IllegalArgumentException e) {
            inputAmountType();
        }
        return amount / LottoConstants.UNIT;
    }

    public Lotto inputLottoNumber() {
        String input = Console.readLine();
        List<Integer> lottoNumbers = Arrays.stream(input.split(","))
                .map(s -> Integer.parseInt(s)).collect(Collectors.toList());
        Lotto lotto = null;
        try {
            lotto = new Lotto(lottoNumbers);
        } catch (IllegalArgumentException e) {
            inputLottoNumber();
        }
        return lotto;
    }

    public int inputLottoBonusNumber() {
        String input = Console.readLine();
        try {
            inputValidator.validateInputType(input);
            List<Integer> inputBonus = Arrays.asList(Integer.parseInt(input));
            numberValidator.validateLottoNumberRange(inputBonus);
        } catch (IllegalArgumentException e) {
            inputLottoBonusNumber();
        }
        return Integer.parseInt(input);
    }
}
