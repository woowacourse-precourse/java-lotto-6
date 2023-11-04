package lotto.view.input;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;
import lotto.message.LottoBuyMessage;
import lotto.util.LottoFactory;
import lotto.validator.InputValidator;

import java.util.List;
import java.util.stream.Stream;

public class LottoShopInput extends Input{

    private final InputValidator inputValidator;
    private static final int DENOMINATION = 1000;

    public LottoShopInput() {
        this.inputValidator = new InputValidator();
    }

    public int requestLottoPurchaseAmount() {
        printRequestLottoPurchaseAmount();

        int amount = inputValidator.parseInt(readLine());
        validateLottoAmount(amount, DENOMINATION);

        return amount;
    }

    private void printRequestLottoPurchaseAmount() {
        System.out.println(LottoBuyMessage.PURCHASE_AMOUNT_PROMPT_MESSAGE.getMassage());
    }

    private void validateLottoAmount(int amount, int denomination) {
        inputValidator.validateLottoAmount(amount);
        inputValidator.validateMultipleOfDenomination(amount, denomination);
    }

    public Lottos buyLottos(int amount) {
        System.out.println();
        return new Lottos(createLottos(amount));
    }

    private List<Lotto> createLottos(int amount) {
        return Stream.generate(LottoFactory::getLotto)
                .limit(amount / DENOMINATION)
                .toList();
    }

}
