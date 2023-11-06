package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.EnumList.ConstantLotto;
import lotto.Input.Input;
import lotto.Output.Output;

public class LottoGame {
    private static List<List<Integer>> randomLotto;
    private static InsertLottoNumber insertLottoNumber;
    private static BonusNumber bonusNumber;
    private static Lotto lotto;
    private static ResultLotto resultLotto;
    private static Input input;
    private static Output output;
    private static Money money;
    private static final int WON = 1000;

    public void Game() {
        input = new Input();
        output = new Output();
        startGame();
    }

    private void startGame() {
        validateLoop();
        resultLotto = new ResultLotto(lotto.lottoNumber(), bonusNumber.bonusNumber());
        resultLotto.printResult(randomLotto);
        output.printRateOfReturn(rateOfReturn(resultLotto.resultOfMoney()));
    }

    private void validateLoop() {
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
            randomLotto.add(randomLotto());
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

    private List<Integer> randomLotto() {
        return Randoms.pickUniqueNumbersInRange(ConstantLotto.MIN_NUMBER.value(),ConstantLotto.MAX_NUMBER.value(), ConstantLotto.LOTTO_SIZE.value());
    }
}
