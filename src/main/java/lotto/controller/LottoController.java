package lotto.controller;

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
        int money = createMoney();
        List<LottoNumber> lottoNumbers = lottoNumberGenerator.createLottoNumbers(money);
        OutputView.printLottoNumbers(lottoNumbers);
        Lotto lotto = new Lotto(createWinningNumber());
        lotto.setBonusNumber(createBonusNumber());

        LottoResult lottoResult = lottoService.compare(lottoNumbers, lotto);
        OutputView.printLottoResult(lottoResult);
    }

    private int createMoney() {
        try {
            return Integer.parseInt(InputView.inputMoney());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 금액은 숫자만 입력 가능합니다.");
        }
    }

    private List<Integer> createWinningNumber() {
        String[] numbers = InputView.inputWinningNumbers().split(SEPARATOR);
        try {
            return Arrays.stream(numbers)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자만 입력 가능합니다.");
        }
    }

    private int createBonusNumber() {
        try {
            return Integer.parseInt(InputView.inputBonusNumber());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자만 입력 가능합니다.");
        }
    }
}
