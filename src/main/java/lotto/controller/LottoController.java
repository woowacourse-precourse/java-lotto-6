package lotto.controller;

import lotto.domain.consumer.Consumer;
import lotto.domain.consumer.Price;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final static OutputView outputView = new OutputView();
    private final static InputView inputView = new InputView();

    public void run() {
        printPriceMessage();
        Price price = createPrice();

        Consumer consumer = createConsumer(price);
        printConsumerLotto(consumer);

    }

    private void printPriceMessage() {
        outputView.printPriceMessage();
    }

    private Price createPrice() {
        Price price = null;
        boolean valid = false;

        while(!valid) {
            try {
                price = new Price(inputView.inputPrice());
                valid = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return price;
    }

    private Consumer createConsumer(Price price) {
        return new Consumer(price);
    }

    private void printConsumerLotto(Consumer consumer) {
        outputView.printCountMessage(consumer);
        outputView.printConsumerNumbers(consumer);
    }
}
