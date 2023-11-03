package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.utils.LottoFormatter;

import java.util.List;

public class GameView {
    private final LottoFormatter lottoFormatter;

    public GameView(LottoFormatter lottoFormatter) {
        this.lottoFormatter = lottoFormatter;
    }

    public String getPurchaseAmountInput() {
        System.out.println("구입 금액을 입력해 주세요.");
        String input = getInput();

        return input;
    }

    public void showLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            String formattedNumbers = lottoFormatter.format(lotto.getSortedNumbers());
            System.out.println(formattedNumbers);
        }
    }

    public String getWinningNumbersInput() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = getInput();

        return input;
    }

    public String getBonusNumber() {
        System.out.println("보너스 번호를 입력해주세요.");
        String input = getInput();

        return input;
    }

    private String getInput() {
        return Console.readLine();
    }
}
