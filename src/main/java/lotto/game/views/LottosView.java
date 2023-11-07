package lotto.game.views;

import static lotto.game.views.enums.LottosViewMessage.ASK_PURCHASE_AMOUNT;

import java.util.List;
import lotto.collaboration.lottos.dto.PlayerLotto;
import lotto.game.io.Input;
import lotto.game.io.InteractionRepeatable;
import lotto.game.io.Output;
import lotto.game.views.enums.LottosViewMessage;

public class LottosView implements InteractionRepeatable {

    public final Input input;
    public final Output output;

    public LottosView(final Input input, final Output output) {
        this.input = input;
        this.output = output;
    }

    public int askPurchaseAmount() {
        return supplyInteraction(() -> {
            output.println(ASK_PURCHASE_AMOUNT.get());
            return input.number();
        });
    }

    public void announcePurchaseLottos(final List<PlayerLotto> purchaseLottos) {
        output.println(LottosViewMessage.showNumberOfPurchaseLottos(purchaseLottos.size()));
        for (PlayerLotto purchaseLotto : purchaseLottos) {
            output.println(purchaseLotto);
        }
    }

}
