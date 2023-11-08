package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import GameIO.GameInput;
import GameIO.GameOutput;

public class GameController {

    public GameController() {
        GameOutput.printUserCashInterface();
        int moneys = GameInput.getUserCash();
        System.out.println(moneys);
        GameOutput.printUserHopeLottoNumbersInterface();
        List<Integer> numbers = GameInput.setupLottoNumbers();
        //System.out.println(numbers);
        Lotto lottoGame = new Lotto(numbers);
        int tickets = lottoGame.buyLottoTickets(moneys);
        GameOutput.printUserHopeBonusNumbersInterface();
        int bonusNumber = GameInput.setupLottoBonusNumbers(numbers);
        lottoGame.setBonusNumber(bonusNumber);
        GameOutput.printBuyTickets(tickets);
        lottoGame.buyTickets(tickets);
        float earnRatio = lottoGame.earnMoney() / (float) moneys;
        GameOutput.printPlacedTickets(lottoGame.getPlaced());
        GameOutput.printEarnMoneyRatio(earnRatio);
        Console.close();
    }

    //%% 두개 붙이면 % 출력됨


}
