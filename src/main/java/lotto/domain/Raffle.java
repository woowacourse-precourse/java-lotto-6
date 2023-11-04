package lotto.domain;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.stream.IntStream;
import lotto.util.RandomNumber;
import lotto.util.io.InputUtils;
import lotto.util.io.OutputUtils;

public class Raffle {

    private Lottos lottos;
    private List<Integer> winningNumbers;
    private int bonusNumber;

    public int getValidPurchaseAmount() {
        int money;
        while (true) {
            try {
                OutputUtils.printPurchaseAmountInputMessage();
                money = InputUtils.getPurchaseAmount();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return money;
    }

    public void createLottos(int number) {
        List<Lotto> newLottos = IntStream.range(0, number)
                .mapToObj(i -> new Lotto(RandomNumber.createRandomLottoNumber()))
                .collect(toList());
        lottos = new Lottos(newLottos);
    }

    public void getValidWinningNumbers() {
        while (true) {
            try {
                OutputUtils.printWinningNumbersInputMessage();
                winningNumbers = InputUtils.getWinningNumbers();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void getValidBonusNumber() {
        while (true) {
            try {
                OutputUtils.printBonusNumberInputMessage();
                bonusNumber = InputUtils.getBonusNumber(winningNumbers);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
