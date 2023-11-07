package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import lotto.Constants;
import lotto.exception.Exception;

import java.util.List;

public class Buy {
    List<Lotto> lottoGames = null;
    NumberGenerator generator = null;
    Lotto lotto = null;

    public int getGames() {
        int totalAmount = 0;
        boolean correctAmount = false;
        Exception exception = new Exception();
        System.out.println("구입금액을 입력해주세요.");
        while (!correctAmount || totalAmount < 1) {
            totalAmount = exception.checkInt(Console.readLine());
            correctAmount = exception.checkAmount(totalAmount, correctAmount);
        }
        return totalAmount / Constants.LOTTOPRICE;
    }

    public void createGames() {
        generator = new NumberGenerator();
        int count = getGames();
        System.out.println(count+"개를 구매했습니다.");
        while (lottoGames.size() < count) {
            lotto = new Lotto(generator.createRandomNumbers());
            lottoGames.add(lotto);
        }
    }
}
