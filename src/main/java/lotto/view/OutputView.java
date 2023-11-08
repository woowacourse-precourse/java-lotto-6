package lotto.view;

import lotto.model.Lotto;

import java.util.ArrayList;
import java.util.List;

public class OutputView {
    public static void askAmountForLotto() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static int calculateLottoCount() {
        int LottoCount = InputView.getLottoPrice() / 1000;
        System.out.println(LottoCount + "개를 구매했습니다.");
        return LottoCount;
    }

    public static List<Lotto> repeatGenerateRandomLotto() {
        int count = calculateLottoCount();
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Lotto lotto = Lotto.generateRandomLotto();
            lottos.add(lotto);
            System.out.println(lotto.getNumbers());
        }
        return lottos;
    }

    public static void askWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void askBonusNumbers() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }
}
