package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constants.Constants;
import lotto.constants.Errors;
import lotto.constants.Message;
import lotto.model.Lotto;
import lotto.model.Result;
import lotto.model.Validator;
import lotto.view.View;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {
    private final View view;
    private final Validator validator;

    public Game() {
        this.view = new View();
        this.validator = new Validator();
    }

    public void start() {
        Integer lottoCount = tryBuyLotto();
        List<Lotto> lottos = generateLottos(lottoCount);
        Lotto answer = tryGenerateAnswer();
        Integer bonus = tryGenerateBonus(answer);
        Result result = generateResult(lottos, answer, bonus);
        showReturnRate(lottoCount, result);
    }

    private Integer tryBuyLotto() {
        while (true) {
            try {
                return buyLotto();
            } catch (IllegalArgumentException e) {
                view.printError(e);
            }
        }
    }

    private Lotto tryGenerateAnswer() {
        while (true) {
            try {
                return generateAnswer();
            } catch (IllegalArgumentException e) {
                view.printError(e);
            }
        }
    }

    private Integer tryGenerateBonus(Lotto answer) {
        while (true) {
            try {
                return generateBonus(answer);
            } catch (IllegalArgumentException e) {
                view.printError(e);
            }
        }
    }

    private Integer buyLotto() {
        Integer lottoCount;
        String cost = view.inputCost();

        validator.validateCost(cost, Constants.LOTTO_PRICE);
        lottoCount = countLotto(cost);
        view.printLottoCount(lottoCount);
        return lottoCount;
    }

    private Integer countLotto(String cost) {
        return (Integer.parseInt(cost) / Constants.LOTTO_PRICE);
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
        List<Integer> random = Randoms.pickUniqueNumbersInRange(Constants.START, Constants.END, Constants.NUMBER_COUNT);
        List<Integer> numbers = new ArrayList<>(random);

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

        view.printLotto(lottoNumbers);
    }

    private Lotto generateAnswer() {
        return new Lotto(generateNumbers());
    }

    private List<Integer> generateNumbers() {
        String[] numbers = inputNumbers();

        return stringToNumbers(numbers);
    }

    private String[] inputNumbers() {
        String numbers = view.inputString();

        return numbers.split(Message.COMMA);
    }

    private List<Integer> stringToNumbers(String[] numbers) {
        List<Integer> result = new ArrayList<>();

        for (String number : numbers) {
            validator.validateAnswer(number, Constants.START, Constants.END);
            result.add(Integer.parseInt(number));
        }
        Collections.sort(result);
        return result;
    }

    private Integer generateBonus(Lotto answer) {
        Integer bonus;
        String bonusInput = view.inputBonus();

        validator.validateBonus(bonusInput, Constants.START, Constants.END);
        bonus = Integer.parseInt(bonusInput);
        if (answer.compareBonus(bonus)) {
            throw new IllegalArgumentException(Errors.BONUS_DUPLICATE);
        }
        return bonus;
    }

    private Result generateResult(List<Lotto> lottos, Lotto answer, Integer bonus) {
        Result result = countResult(lottos, answer, bonus);

        showResult(result);
        return result;
    }

    private Result countResult(List<Lotto> lottos, Lotto answer, Integer bonus) {
        Result result = new Result(Constants.NUMBER_COUNT);
        Integer count;

        for (Lotto lotto : lottos) {
            count = lotto.compareAnswer(answer);
            result.addResult(count);
            if (count == Constants.NUMBER_COUNT - 1) {
                bonusCheck(lotto, bonus, result);
            }
        }
        return result;
    }

    private void bonusCheck(Lotto lotto, Integer bonus, Result result) {
        if (lotto.compareBonus(bonus)) {
            result.addBonus(Constants.NUMBER_COUNT);
        }
    }

    private void showResult(Result result) {
        String resultMessage = result.generateResultMessage();

        view.printResult(resultMessage);
    }

    private void showReturnRate(Integer lottoCount, Result result) {
        Integer cost = lottoCount * Constants.LOTTO_PRICE;
        Double returnRate = result.calculateReturnRate(cost);

        view.printReturnRate(returnRate);
    }
}
