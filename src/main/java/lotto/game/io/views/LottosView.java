package lotto.game.io.views;

import java.util.List;
import lotto.collaboration.lottos.dto.PlayerLotto;
import lotto.game.io.Input;
import lotto.game.io.InteractionRepeatable;
import lotto.game.io.Output;

public class LottosView implements InteractionRepeatable {

    public final Input input;
    public final Output output;

    public LottosView(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    public int askPurchaseAmount() {
        return supplyInteraction(() -> {
            output.println("구입금액을 입력해 주세요.");
            return input.number();
        });
    }

    public void announcePurchaseLottos(List<PlayerLotto> purchaseLottos) {
        output.println();
        output.println(purchaseLottos.size() + "개를 구매했습니다.");
        for (PlayerLotto purchaseLotto : purchaseLottos) {
            output.println(purchaseLotto);
        }
    }

}
