package lotto.controller.prize;

import java.util.List;
import lotto.domain.prize.Prize;
import lotto.domain.prize.PrizeNumber;
import lotto.exception.LottoException;
import lotto.view.input.LottoPrizeInputView;
import lotto.view.output.LottoPrizeOutputView;

public class PrizeController {
    private final LottoPrizeInputView lottoPrizeInputView;
    private final LottoPrizeOutputView lottoPrizeOutputView;

    public PrizeController(
            final LottoPrizeInputView lottoPrizeInputView,
            final LottoPrizeOutputView lottoPrizeOutputView
    ) {
        this.lottoPrizeInputView = lottoPrizeInputView;
        this.lottoPrizeOutputView = lottoPrizeOutputView;
    }

    public Prize inputPrize() {
        final List<PrizeNumber> prizeNumbers = inputPrizeNumber();
        lottoPrizeOutputView.printNewLine();

        final PrizeNumber bonusNumber = inputBonusNumber();
        lottoPrizeOutputView.printNewLine();

        return new Prize(prizeNumbers, bonusNumber);
    }

    private List<PrizeNumber> inputPrizeNumber() {
        lottoPrizeOutputView.printInputPrizeNumberMessage();
        return readPrizeNumbers();
    }

    private List<PrizeNumber> readPrizeNumbers() {
        try {
            return lottoPrizeInputView.readPrizeNumbers();
        } catch (LottoException exception) {
            return readPrizeNumbers();
        }
    }

    private PrizeNumber inputBonusNumber() {
        lottoPrizeOutputView.printInputBonusNumberMessage();
        return readBonusNumber();
    }

    private PrizeNumber readBonusNumber() {
        try {
            return lottoPrizeInputView.readBonusNumber();
        } catch (LottoException exception) {
            return readBonusNumber();
        }
    }
}
