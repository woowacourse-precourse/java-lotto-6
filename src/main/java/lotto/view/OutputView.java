package lotto.view;

import static lotto.view.PromptMessage.PURCHASE_NUMBERS_OF_LOTTO;

import lotto.domain.Lottos;

public class OutputView {

    public void promptMessage(String message) {
        System.out.println(message);
    }

    public void purchasedNumberOfLotto(int number) {
        System.out.println(String.format(PURCHASE_NUMBERS_OF_LOTTO.getMessage(), number));
    }

    public void printPurchasedLottoNumbers(Lottos lottos) {
        lottos.getLottos()
                .forEach(lotto -> System.out.println(lotto.getNumbers()));
    }
}
