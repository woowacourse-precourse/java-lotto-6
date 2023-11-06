package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;
import lotto.model.Validator;
import lotto.view.Message;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {
    private final Integer LOTTO_PRICE = 1000;
    private final Integer START = 1;
    private final Integer END = 45;
    private final Integer NUMBER_COUNT = 6;

    private final Message message;
    private final Validator validator;

    public Game() {
        this.message = new Message();
        this.validator = new Validator();
    }

    public void start() {
        Integer lottoCount = buyLotto();
        List<Lotto> lottos = generateLottos(lottoCount);
        Lotto answer = generateAnswer();
    }

    private Integer buyLotto() {
        Integer lottoCount;
        String cost = message.inputCost();

        validator.validateCost(cost, LOTTO_PRICE);
        lottoCount = countLotto(cost);
        message.printLottoCount(lottoCount);
        return lottoCount;
    }

    private Integer countLotto(String cost) {
        return (Integer.parseInt(cost) / LOTTO_PRICE);
    }

    private List<Lotto> generateLottos(Integer lottoCount) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            lottos.add(oneLotto());
        }
        showLottos(lottos);
        return lottos;
    }

    private Lotto oneLotto() {
        return new Lotto(pickNumbers());
    }

    private List<Integer> pickNumbers() {
        List<Integer> numbers;

        numbers = Randoms.pickUniqueNumbersInRange(START, END, NUMBER_COUNT);
        Collections.sort(numbers);
        return numbers;
    }

    private void showLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            showOneLotto(lotto);
        }
    }

    private void showOneLotto(Lotto lotto) {
        String[] lottoNumbers = lotto.stringLotto();

        message.printLotto(lottoNumbers);
    }

    private Lotto generateAnswer() {
        return new Lotto(generateNumbers());
    }

    private List<Integer> generateNumbers() {
        String[] numbers = inputNumbers();

        return stringToNumbers(numbers);
    }

    private String[] inputNumbers() {
        String numbers = message.inputString();

        return numbers.split(",");
    }

    private List<Integer> stringToNumbers(String[] numbers) {
        List<Integer> result = new ArrayList<>();

        for (String number : numbers) {
            validator.isAnswerNumeric(number);
            result.add(Integer.parseInt(number));
        }
        return result;
    }
}
