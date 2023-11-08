package lotto;

import java.util.List;

public class GameManager {
    LottoMachine lottoMachine = new LottoMachine();

    public void playGame() {
        int money = lottoMachine.lottoMoney();
        int amount = lottoMachine.lottoAmount(money);
        lottoMachine.printLottoAmount(amount);
        ComputerLotto computerLottos = new ComputerLotto(amount);
        computerLottos.printLottos();
        List<Integer> userNumbers = lottoMachine.makeLotto();
        int bonusNumber = lottoMachine.makeBonusNumber(userNumbers);
        RankJudge rankJudge = new RankJudge(userNumbers, bonusNumber, money);
        rankJudge.checkAndPrintResults(computerLottos);
    }

}
