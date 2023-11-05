package lotto;

import camp.nextstep.edu.missionutils.Console;

public class LottoGame {
    private static final String INPUT_WINNING_LOTTO = "\n당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS = "\n보너스 번호를 입력해 주세요.";

    public void start() {
        LottoGenerator lottoGenerator = new LottoGenerator();
        lottoGenerator.printLottos();

        Win win = new Win();
        System.out.println(INPUT_WINNING_LOTTO);
        win.setWinningLotto(Console.readLine());

        System.out.println(INPUT_BONUS);
        win.setBonus(Integer.parseInt(Console.readLine()));
    }
}
