package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.Lotto;
import lotto.GameInput;
import lotto.GameOutput;

public class GameController {

    public GameController() {

        GameOutput.printUserCashInterface();
        int moneys = GameInput.getUserCash();
        //System.out.println(moneys);
        GameOutput.printUserHopeLottoNumbersInterface();
        List<Integer> numbers = GameInput.getUserHopeLottoNumbers();
        //System.out.println(numbers);
        Lotto lottoGame = new Lotto(numbers);
        int tickets = lottoGame.buyLottoTickets(moneys);
        GameOutput.getUserHopeBonusNumbersInterface();
        int bonusNumber = GameInput.getUserHopeBonusNumbers();
        lottoGame.setBonusNumber(bonusNumber);
        //System.out.println(bonusNumber);

        List<String> ticketNumbers = GameOutput.printBuyTickets( lottoGame , tickets );
        float earnRatio = 100*GameInput.earnMoney(numbers,ticketNumbers, bonusNumber)/(float)moneys;
        System.out.print(String.format("총 수익률은 %.1f%%입니다." , earnRatio));
        //%% 두개 붙이면 % 출력됨



        Console.close();
    }


}
