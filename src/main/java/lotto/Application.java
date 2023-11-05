package lotto;

import lotto.util.Log;

public class Application {

    private static final LottoController lottoController = new LottoController();
    private static final Input input = new Input();
    public static void main(String[] args) {
        Log.println("구입금액을 입력해 주세요.");
        lottoController.buyLotto(input.buyMoney());

        Log.println("당첨 번호를 입력해 주세요.");
        lottoController.saveAnswerNumber();

        Log.println("보너스 번호를 입력해주세요.");
        lottoController.saveBonusNumber();

        lottoController.getStatistics();
    }
}
