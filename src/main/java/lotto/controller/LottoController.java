package lotto.controller;

import lotto.model.Lotto;
import lotto.model.Result;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    private static Result result = new Result();

    public static void guessLottos(List<Lotto> lottos, int money, int ticketNum, List<Integer> winningNumbers, int bonusNumber) {
        // 로또 맞추기
        playLottoGame(lottos, winningNumbers, bonusNumber);
        // 결과 출력
        result.printResult();
        result.printRateOfReturn(money);
    }


    public static void playLottoGame(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        for(Lotto lotto : lottos){
            List<Integer> numbers = lotto.getLottoNumbers();
            int bonus = 0;
            int cnt = hasWinNumbers(winningNumbers, numbers);
            if(numbers.contains(bonusNumber))
                bonus++;
            result.recordResult(cnt, bonus);
        }
    }

    public static int hasWinNumbers(List<Integer> winningNumbers, List<Integer> numbers){
        int cnt = 0;
        for(int winNum : winningNumbers){
            if(numbers.contains(winNum))
                cnt++;
        }
        return cnt;
    }
}
