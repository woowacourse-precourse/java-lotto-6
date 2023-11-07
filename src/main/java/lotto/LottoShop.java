package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoShop {
    public LottoTicket buyLottoTicket() {
        List<Lotto> lottos = new ArrayList<>();
        ConsoleManager consoleManager = new ConsoleManager();
        InputValidator inputValidator = new InputValidator();

        int totalPurchasedLottoCount = consoleManager.getPurchaseAmount();
        for (int i = 0; i < totalPurchasedLottoCount; i++) {
            List<Integer> numbers = consoleManager.getManualInputNumbers();
            inputValidator.validateLottoNumbers(numbers);
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }

        return new LottoTicket(lottos);
    }
}
