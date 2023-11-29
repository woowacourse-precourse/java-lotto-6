package lotto.controller;

import java.util.List;
import lotto.dto.BuyLottoDto;
import lotto.model.BonusNumber;
import lotto.model.LottoNumbers;
import lotto.model.PurchasePrice;
import lotto.model.WinnerNumber;
import lotto.service.BuyLottoService;
import lotto.view.input.InputView;
import lotto.view.output.OutputView;

public class BuyLottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final BuyLottoService buyLottoService;

    public BuyLottoController(InputView inputView, OutputView outputView, BuyLottoService buyLottoService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.buyLottoService = buyLottoService;
    }

    public BuyLottoDto buyLotto() {
        PurchasePrice purchasePrice = createPurchasePrice(); // 구입 금액 입력

        LottoNumbers lottoNumbers = buyLottoService.buyLotto(purchasePrice); // 로또 구입

        WinnerNumber winnerNumber = createWinnerNumber(); // 당첨 번호 입력

        BonusNumber bonusNumber = createBonusNumber(winnerNumber); // 보너스 번호 입력

        return BuyLottoDto.createBuyLottoDto(purchasePrice, lottoNumbers, winnerNumber, bonusNumber);
    }

    private BonusNumber createBonusNumber(WinnerNumber winnerNumber) {
        while (true) {
            try {
                outputView.printBonusNumberMessage();
                int bonus = inputView.inputBonusNumber();
                return BonusNumber.createBonusNumber(winnerNumber.getWinnerNumbers(), bonus);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private WinnerNumber createWinnerNumber() {
        while (true) {
            try {
                outputView.printWinnerNumberMessage();
                List<Integer> winners = inputView.inputWinnerNumber();
                return WinnerNumber.createWinnerNumber(winners);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private PurchasePrice createPurchasePrice() {
        while (true) {
            try {
                outputView.printPurchasePriceMessage();
                int price = inputView.readPrice();
                PurchasePrice purchasePrice = PurchasePrice.createPurchasePrice(price);
                return purchasePrice;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
