package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.LottoConstants;
import lotto.domain.Lotto;
import lotto.validator.InputValidator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputController {
    private final InputValidator inputValidator;

    public InputController(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
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
        try {
            inputValidator.validateLottoNumberRange(lottoNumbers);
            inputValidator.validateLength(lottoNumbers);
            inputValidator.validateLottoDuplication(lottoNumbers);
        } catch (IllegalArgumentException e) {
            inputLottoNumber();
        }
        return new Lotto(lottoNumbers);
    }

    public int inputLottoBonusNumber() {
        String input = Console.readLine();
        try {
            inputValidator.validateInputType(input);
            List<Integer> inputBonus = Arrays.asList(Integer.parseInt(input));
            inputValidator.validateLottoNumberRange(inputBonus);
        } catch (IllegalArgumentException e) {
            inputLottoBonusNumber();
        }
        return Integer.parseInt(input);
    }
}
