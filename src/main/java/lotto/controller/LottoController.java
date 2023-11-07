package lotto.controller;

import lotto.domain.common.Lotto;
import lotto.domain.consumer.Consumer;
import lotto.domain.consumer.Price;
import lotto.domain.producer.Bonus;
import lotto.domain.producer.Producer;
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

        printProducerLottoMessage();
        Lotto producerLotto = createProducerLotto();
        printProducerLottoBonusMessage();
        Producer producer = getProducer(producerLotto);

    }

    private void printPriceMessage() {
        outputView.printPriceMessage();
    }

    private Price createPrice() {
        Price price = null;
        boolean valid = false;

        while (!valid) {
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

    private void printProducerLottoMessage() {
        outputView.printProducerLottoMessage();
    }

    private Lotto createProducerLotto() {
        boolean valid = false;
        Lotto lotto = null;

        while (!valid) {
            try {
                lotto = new Lotto(inputView.inputLotto());
                valid = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return lotto;
    }

    private void printProducerLottoBonusMessage() {
        outputView.printProducerBonusMessage();
    }

    public Producer getProducer(Lotto producerLotto) {
        Bonus producerLottoBonus = createProducerLottoBonus(producerLotto);
        Producer producer = createProducer(producerLotto, producerLottoBonus);
        return producer;
    }

    private Bonus createProducerLottoBonus(Lotto producerLotto) {
        boolean valid = false;
        Bonus bonus = null;

        while(!valid) {
            try {
                int bonusInt = inputView.inputBonus();
                bonus = new Bonus(producerLotto, bonusInt);
                valid = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return bonus;
    }

    public Producer createProducer(Lotto producerLotto, Bonus bonus) {
        return new Producer(producerLotto, bonus);
    }
}
