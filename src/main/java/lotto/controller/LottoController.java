package lotto.controller;

import static lotto.constant.ErrorMessage.BONUS_NUMBER_IS_NOT_NUMBER;
import static lotto.constant.ErrorMessage.PRICE_IS_NOT_NUMBER;
import static lotto.constant.ErrorMessage.WINNING_NUMBER_IS_NOT_NUMBER;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.Lotto;
import lotto.dto.LottoResult;
import lotto.model.LottoNumber;
import lotto.model.LottoNumberGenerator;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private static final String SEPARATOR = ",";

    private static LottoController lottoController;

    private final LottoNumberGenerator lottoNumberGenerator = LottoNumberGenerator.getInstance();
    private final LottoService lottoService = LottoService.getInstance();

    private LottoController() {
    }

    public static LottoController getInstance() {
        if (lottoController == null) {
            lottoController = new LottoController();
        }
        return lottoController;
    }

    public void doLotto() {
        List<LottoNumber> lottoNumbers;
        do {
            lottoNumbers = createLottoNumbers();
        } while (lottoNumbers == null);
        OutputView.printLottoNumbers(lottoNumbers);

        Lotto lotto;
        do {
            lotto = createLotto();
        } while (lotto == null);

        do {
            setLottoBonusNumber(lotto);
        } while (!lotto.hasBonusNumber());

        LottoResult lottoResult = lottoService.compare(lottoNumbers, lotto);
        OutputView.printLottoResult(lottoResult);
    }

    private List<LottoNumber> createLottoNumbers() {
        try {
            int money = createMoney();
            return lottoNumberGenerator.createLottoNumbers(money);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return null;
        }
    }

    private int createMoney() {
        try {
            return Integer.parseInt(InputView.inputMoney());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(PRICE_IS_NOT_NUMBER.getMessage());
        }
    }

    private Lotto createLotto() {
        try {
            return new Lotto(createWinningNumber());
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return null;
        }
    }

    private List<Integer> createWinningNumber() {
        String[] numbers = InputView.inputWinningNumbers().split(SEPARATOR);
        try {
            return Arrays.stream(numbers)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(WINNING_NUMBER_IS_NOT_NUMBER.getMessage());
        }
    }

    private void setLottoBonusNumber(Lotto lotto) {
        try {
            int bonusNumber = Integer.parseInt(InputView.inputBonusNumber());
            lotto.setBonusNumber(bonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(BONUS_NUMBER_IS_NOT_NUMBER.getMessage());
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
        }
    }
}
