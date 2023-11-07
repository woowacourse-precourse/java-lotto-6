package lotto;

import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Input input = new Input();

        int quantity = input.cost();
        Output output = new Output(quantity);

        output.generatedMyLottos();

        Lotto winningLottoWithoutBonusNum = input.winningNumberWithoutBonus();
        WinningLotto winningLottoWithBonusNum= input.bonusNumber(winningLottoWithoutBonusNum);

        output.statisticsAndProfitability(winningLottoWithBonusNum);
    }

}
