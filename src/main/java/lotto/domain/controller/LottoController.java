package lotto.domain.controller;

import lotto.domain.controller.dto.LottoDtos;
import lotto.domain.entity.User;
import lotto.domain.service.LottoService;
import lotto.domain.service.dto.GameResult;
import lotto.domain.view.dto.LottoBonusNumberDto;
import lotto.domain.view.dto.PurchasePriceDto;
import lotto.domain.view.input.LottoInputView;
import lotto.domain.view.input.LottoNumbersDto;
import lotto.domain.view.output.LottoOutputView;

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
        User user = createUser();
        lottoOutputView.printLottos(LottoDtos.of(user));

        GameResult gameResult = getGameResult(user);
        lottoOutputView.printResult(gameResult);
    }

    private User createUser() {
        PurchasePriceDto purchasePriceDto = getPurchasePrice();
        return lottoService.createUser(purchasePriceDto.purchasePrice());
    }

    private PurchasePriceDto getPurchasePrice() {
        lottoOutputView.askPurchasePrice();
        return lottoInputView.readPurchasePrice();
    }

    private GameResult getGameResult(final User user) {
        LottoNumbersDto lottoNumbersDto = getLottoNumbers();

        LottoBonusNumberDto lottoBonusNumber = getLottoBonusNumber();

        return lottoService.calculateResult(
                lottoNumbersDto.numbers(),
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
