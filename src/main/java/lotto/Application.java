package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        Input input = new Input();
        int money = input.getMoney();

        int numberOfLotto = input.getNumberOfLotto();
        System.out.println(numberOfLotto+"개를 구매했습니다.");

        LottoMachine lottoMachine = new LottoMachine();

        List<Lotto> lottos = lottoMachine.print(numberOfLotto);
        lottoMachine.showLottos();

        List<Integer> winningNumbers = input.getWinningNumber();

        int bonusNumber = input.getBonusNumber();

        Prize totalReturn = new Prize(money, winningNumbers, lottos, bonusNumber);
        totalReturn.printResult();

    }
}
