package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.Input.Input;

public class LottoGame {
    private static List<List<Integer>> randomLotto;
    private static InsertLottoNumber insertLottoNumber;
    private static BonusNumber bonusNumber;
    private static Lotto lotto;
    private static ResultLotto resultLotto;
    private static Input input;
    private static Money money;
    private static final int WON = 1000;

    public void Game() {
        input = new Input();
        startGame();
    }

    private void startGame() {
        loop();
        resultLotto = new ResultLotto(lotto.lottoNumber(), bonusNumber.bonusNumber());
        resultLotto.printResult(randomLotto);
        System.out.print("총 수익률은 " + rateOfReturn(resultLotto.resultOfMoney()) + "%입니다.");
    }

    private void loop() {
        loopInsertMoney();
        createRandomLotto(money.currentMoney() / WON);
        printRandomLotto();
        loopInsertNumber();
        loopInsertBonusNumber();
    }

    private void loopInsertNumber() {
        while (true) {
            try {
                insertLottoNumber = new InsertLottoNumber(input.inputLottoNumber());
                lotto = new Lotto(insertLottoNumber.sendLottoNumber());
                input.lineBreaking();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void loopInsertBonusNumber() {
        while (true) {
            try {
                bonusNumber = new BonusNumber(lotto.lottoNumber(), input.inputBonusNumber());
                input.lineBreaking();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void loopInsertMoney() {
        while (true) {
            try {
                money = new Money(input.inputBuyMoney());
                input.lineBreaking();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void createRandomLotto(int size) {
        input.buyLotto(size);
        randomLotto = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            RandomLotto createLottoNumbers = new RandomLotto();
            randomLotto.add(createLottoNumbers.randomLotto());
        }
    }

    private void printRandomLotto() {
        for (List<Integer> lottoNumber : randomLotto) {
            System.out.println(Arrays.toString(lottoNumber.toArray()));
        }

        input.lineBreaking();
    }

    private double rateOfReturn(long earnMoney) {
        return Math.round(((double) earnMoney / money.currentMoney()) * 1000.0) / 10.0;
    }
}
