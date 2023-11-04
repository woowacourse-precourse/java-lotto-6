package lotto;

import camp.nextstep.edu.missionutils.Console;

public class LottoController {

    public static final OutputView OUTPUT_VIEW = new OutputView();
    public static final int LOTTO_PRICE = 1000;

    public void run() {
        int price = buyLotto();
        int lottoCount = getLottoCount(price);
    }

    private int buyLotto() {
        OUTPUT_VIEW.printPriceMessage();
        String inputPrice = Console.readLine();
        return validationPrice(inputPrice);
    }

    private int validationPrice(String inputPrice) {
        int price = 0;

        try {
            Error.CHECK.isAllInteger(inputPrice);
            price = Integer.parseInt(inputPrice);
            Error.CHECK.isUnder1000Price(price);
        } catch (IllegalArgumentException e) {
            buyLotto();
        }
        return price;
    }

    public int getLottoCount(int price) {
        return price / LOTTO_PRICE;
    }

}
