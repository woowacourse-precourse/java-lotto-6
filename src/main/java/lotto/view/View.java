package lotto.view;

import java.util.stream.Collectors;

public class View {

    private static final String OPEN_SQUARE_BRACKETS = "[";
    private static final String CLOSE_SQUARE_BRACKETS = "]";


    public void printRequestPriceMessage() {
        System.out.println(ViewMessage.REQUEST_PURCHASE_PRICE_MESSAGE.getMessage());
    }

    public void printNumberOfPurchasedLotto(int number) {
        System.out.printf(ViewMessage.NUMBER_OF_PURCHASED_LOTTO_FORMAT.getMessage(), number);
        System.out.println();
    }

    public void printIssuedLottoNumbers(List<IssuedLottosDto> lottos) {
        for (IssuedLottosDto lotto : lottos) {
            String message = lotto.getNumbers.stream()
                    .map(IssuedLottosDto::getLottoNumbers)
                    .collect(Collectors.joining(", "));
            System.out.println(OPEN_SQUARE_BRACKETS + message + CLOSE_SQUARE_BRACKETS);
        }
    }

    public void printRequestWinningNumbers() {
        System.out.println(ViewMessage.REQUEST_WINNING_NUMBER_MESSAGE.getMessage());
    }

    public void printRequestBonusNumber() {
        System.out.println(ViewMessage.REQUEST_BONUS_NUMBER_MESSAGE.getMessage());
    }


}
