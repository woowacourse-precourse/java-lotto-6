package lotto.controller;

import lotto.domain.common.Lotto;
import lotto.domain.common.Rank;
import lotto.domain.consumer.Consumer;
import lotto.domain.consumer.Price;
import lotto.domain.producer.Bonus;
import lotto.domain.producer.Producer;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        printWinningResultMessage();
        Integer totalProfit = printWinningLottoResult(consumer, producer);
        printWinningProfitRatio(price, totalProfit);
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

        while (!valid) {
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

    private void printWinningResultMessage() {
        outputView.printWinningResultMessage();
    }

    private Integer printWinningLottoResult(Consumer consumer, Producer producer) {
        List<Lotto> consumerLottos = consumer.consumerLottos();
        Lotto producerLotto = producer.producerLotto();
        Bonus bonus = producer.producerLottoBonus();

        Map<Integer, Boolean> matchingCountMap = createMatchCountMap(consumerLottos, producerLotto, bonus);

        int totalProfit = 0;
        for (Rank rank : Rank.values()) {
            int count = getCountInCaseOfNotFive(matchingCountMap, rank);

            if (rank.getMatchCount() == 5) {
                count = getCountInCaseOfFive(matchingCountMap, rank);
            }

            outputView.printWinningResult(rank, count);
            totalProfit += rank.calculatePrize(count);
        }

        return totalProfit;
    }

    private int getCountInCaseOfNotFive(Map<Integer, Boolean> matchingCountMap, Rank rank) {
        return (int) matchingCountMap.entrySet().stream()
                .filter(entry -> entry.getKey() == rank.getMatchCount())
                .count();
    }

    private int getCountInCaseOfFive(Map<Integer, Boolean> matchingCountMap, Rank rank) {
        return (int) matchingCountMap.entrySet().stream()
                .filter(entry -> entry.getKey() == rank.getMatchCount() && entry.getValue() == rank.getIsMatchWithBonus())
                .count();
    }

    private void printWinningProfitRatio(Price price, double totalProfit) {
        outputView.printWinningProfitRatioMessage(totalProfit / price.value() * 100);
    }

    private Map<Integer, Boolean> createMatchCountMap(List<Lotto> consumerLottos, Lotto producerLotto, Bonus bonus) {
        Map<Integer, Boolean> matchingCountMap = new HashMap<>();

        for (Lotto consumerLotto : consumerLottos) {
            int matchingCount = countMatchNumber(consumerLotto, producerLotto);
            boolean isMatchedWithBonus = countMatchBonusNumber(consumerLotto, bonus);

            matchingCountMap.put(matchingCount, isMatchedWithBonus);
        }
        return matchingCountMap;
    }

    private int countMatchNumber(Lotto consumerLotto, Lotto producerLotto) {
        return (int) consumerLotto.numbers().stream()
                .filter(integer -> producerLotto.numbers().contains(integer))
                .count();
    }

    private boolean countMatchBonusNumber(Lotto consumerLotto, Bonus bonus) {
        return consumerLotto.numbers().stream()
                .anyMatch(integer -> integer.equals(bonus.value()));
    }
}
