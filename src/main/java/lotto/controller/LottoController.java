package lotto.controller;

import lotto.controller.dto.LottoDtos;
import lotto.domain.Lotto;
import lotto.domain.User;
import lotto.exception.ExceptionHandler;
import lotto.service.LottoService;
import lotto.service.dto.GameResult;
import lotto.view.input.dto.LottoBonusNumberDto;
import lotto.view.input.dto.PurchasePriceDto;
import lotto.view.input.LottoInputView;
import lotto.view.input.dto.LottoNumbersDto;
import lotto.view.output.LottoOutputView;

public class LottoController {

    private final LottoService lottoService;
    private final LottoOutputView lottoOutputView;
    private final LottoInputView lottoInputView;

    public LottoController(
            final LottoService lottoService,
            final LottoOutputView lottoOutputView,
            final LottoInputView lottoInputView) {
        this.lottoService = lottoService;
        this.lottoOutputView = lottoOutputView;
        this.lottoInputView = lottoInputView;
    }

    public void run() {
        User user = ExceptionHandler.handle(this::createUser);
        lottoOutputView.printLottos(LottoDtos.of(user));

        Lotto target = ExceptionHandler.handle(this::getTargetLotto);

        GameResult gameResult = ExceptionHandler.handle(this::getGameResult, user, target);
        lottoOutputView.printResult(gameResult);
    }

    private Lotto getTargetLotto() {
        LottoNumbersDto lottoNumbersDto = getLottoNumbers();
        return lottoService.createTargetLotto(lottoNumbersDto.numbers());
    }

    private User createUser() {
        PurchasePriceDto purchasePriceDto = getPurchasePrice();
        return lottoService.createUser(purchasePriceDto.purchasePrice());
    }

    private PurchasePriceDto getPurchasePrice() {
        lottoOutputView.askPurchasePrice();
        return lottoInputView.readPurchasePrice();
    }

    private GameResult getGameResult(final User user, final Lotto target) {
        LottoBonusNumberDto lottoBonusNumber = getLottoBonusNumber();

        return lottoService.calculateResult(
                target,
                lottoBonusNumber.bonusNumber(),
                user
        );
    }

    private LottoNumbersDto getLottoNumbers() {
        lottoOutputView.askLottoNumbers();
        return lottoInputView.readLottoNumber();
    }

    private LottoBonusNumberDto getLottoBonusNumber() {
        lottoOutputView.askLottoBonusNumber();
        return lottoInputView.readLottoBonusNumber();
    }
}
