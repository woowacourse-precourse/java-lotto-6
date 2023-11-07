package lotto.service;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.stream.IntStream;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.util.RandomNumber;
import lotto.util.io.InputUtils;
import lotto.util.io.OutputUtils;

public class LottoDraw {

    private static final int PRICE_PER_TICKET = 1000;
    private Lottos lottos;
    private int money;
    private List<Integer> winningNumbers;
    private int bonusNumber;

    public void lottoDraw() {
        getValidPurchaseAmount();
        lottos = createLottos(money / PRICE_PER_TICKET);
        OutputUtils.printNumberOfPurchaseMessage(lottos.getNumber());
        OutputUtils.printPurchaseLottos(lottos.getLottos());
        getValidWinningNumbers();
        getValidBonusNumber();
        lottos.draw(winningNumbers, bonusNumber);
    }

    public void getValidPurchaseAmount() {
        while (true) {
            try {
                OutputUtils.printPurchaseAmountInputMessage();
                money = InputUtils.getPurchaseAmount();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println();
    }

    public Lottos createLottos(int number) {
        List<Lotto> newLottos = IntStream.range(0, number)
                .mapToObj(i -> new Lotto(RandomNumber.createRandomLottoNumber()))
                .collect(toList());
        return new Lottos(newLottos);
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
        System.out.println();
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
        System.out.println();
    }
}
