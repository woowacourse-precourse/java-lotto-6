package lotto;

import lotto.code.GameMessage;
import lotto.utils.InputUtils;
import lotto.utils.PrintUtils;

import java.util.ArrayList;
import java.util.List;

import static lotto.utils.Constant.LOTTO_AMOUNT;

public class Application {
    public static void main(String[] args) {
        int amount = InputUtils.getAmount();

        int lottoCount = amount / LOTTO_AMOUNT;
        PrintUtils.print("");
        PrintUtils.print(lottoCount + GameMessage.LOTTO_COUNT.getMessage());

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = new Lotto();
            lottos.add(lotto);
        }
    }
}
