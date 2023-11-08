package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.Exception;
import lotto.view.PrintGames;

import java.util.ArrayList;
import java.util.List;

public class Buy {
    private List<Lotto> lottoGames = null;

    NumberGenerator generator = null;
    Lotto lotto = null;

    public Buy() {
        generator = new NumberGenerator();
        lottoGames = new ArrayList<>();
    }

    public List<Lotto> getLottoGames() {
        return lottoGames;
    }

    public int getGames() {
        int totalAmount = 0;
        boolean correctAmount = false;
        Exception exception = new Exception();
        System.out.println("구입금액을 입력해주세요.");
        while (!correctAmount || totalAmount < Constants.LOTTOPRICE) {
            totalAmount = exception.checkInt(Console.readLine());
            if (totalAmount < Constants.LOTTOPRICE) {
                System.out.println("[ERROR] 금액은 1000 단위 숫자로 입력해주세요.");
                continue;
            }
            correctAmount = exception.checkAmount(totalAmount, correctAmount);
        }
        return totalAmount / Constants.LOTTOPRICE;
    }

    public void createGames(PrintGames printGames) {
        int count = getGames();
        while (lottoGames.size() < count) {
            lotto = new Lotto(generator.createRandomNumbers());
            lottoGames.add(lotto);
        }
        printGames.purchaseHistory(lottoGames);
    }
}
