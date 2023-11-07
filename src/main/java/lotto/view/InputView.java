package lotto.view;

import lotto.validation.InputValidator;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.domain.LottoConstant.LOTTO_NUMBER_SEPARATOR;

public class InputView {

    private static final String REQUEST_PURCHASE_PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String REQUEST_LOTTO_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String REQUEST_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    private final InputValidator inputValidator;

    public InputView(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    public int inputLottoPrice() {
        System.out.println(REQUEST_PURCHASE_PRICE_MESSAGE);
        String userInput = readLine();

        inputValidator.validateUserLottoPriceInput(userInput);
        inputValidator.validateLottoSheets(userInput);

        return Integer.parseInt(userInput);
    }

    public List<Integer> inputLottoNumbers() {
        System.out.println(REQUEST_LOTTO_NUMBER_MESSAGE);
        String userInput = readLine();

        inputValidator.validateLottoNumbericInput(userInput);
        inputValidator.validateLottoNumberSize(userInput);
        inputValidator.validateLottoNumberOfRange(userInput);
        inputValidator.validateDuplicateLottoNumber(userInput);

        return separateNumber(userInput);
    }

    public int inputLottoBonusNumber(List<Integer> lottoNumbers) {
        System.out.println(REQUEST_BONUS_NUMBER_MESSAGE);
        String userInput = readLine();

        inputValidator.validateBonusNumberic(userInput);
        inputValidator.validateBonusNumberOfRange(userInput);
        inputValidator.validateDuplicateNumber(lottoNumbers, userInput);

        return Integer.parseInt(userInput);
    }

    private List<Integer> separateNumber(String inputLottoNumbers) {
        return Arrays.stream(inputLottoNumbers.split(LOTTO_NUMBER_SEPARATOR))
                .map(Integer::parseInt)
                .toList();
    }
}
