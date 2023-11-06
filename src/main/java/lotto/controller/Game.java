package lotto.controller;

import static lotto.console.Console.close;
import static lotto.console.Console.println;

import java.util.List;
import java.util.Map;
import lotto.domain.Answer;
import lotto.domain.Bonus;
import lotto.domain.Prize;
import lotto.domain.Profit;
import lotto.domain.UserLotto;
import lotto.dto.AnswerResponse;
import lotto.dto.BonusResponse;
import lotto.dto.LottoResponses;
import lotto.dto.ProfitResponse;
import lotto.dto.ResultResponse;
import lotto.exception.LottoException;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Game {
    private Game() {
    }

    public static void start() {
        int count = readPurchaseAmount();
        List<List<Integer>> allLotto = printTotalLotto(count);
        List<Integer> answerNumbers = readPrizeNumber();
        int bonusNumber = readBonusNumber(answerNumbers);
        Map<Integer, Integer> prizeResult = printPrizeResult(allLotto, answerNumbers, bonusNumber);
        printProfit(count, prizeResult);
        close();
    }

    private static int readPurchaseAmount() {
        while (true) {
            try {
                return InputView.readPurchaseAmountAndCount();
            } catch (LottoException e) {
                println(e.getMessage());
            }
        }
    }

    private static List<List<Integer>> printTotalLotto(final int count) {
        UserLotto userLotto = UserLotto.create(count);
        LottoResponses lottoResponses = userLotto.buildLottoResponses();
        OutputView.printAllLotto(lottoResponses.getResponses());
        return lottoResponses.getResponses();
    }

    private static List<Integer> readPrizeNumber() {
        while (true) {
            try {
                List<Integer> answerNumbers = InputView.readAnswerNumbers();
                Answer answer = Answer.create(answerNumbers);
                AnswerResponse answerResponse = answer.generateAnswerResponse();
                return answerResponse.getResponse();
            } catch (LottoException e) {
                println(e.getMessage());
            }
        }
    }

    private static int readBonusNumber(List<Integer> answerNumbers) {
        while (true) {
            try {
                int bonusNumber = InputView.readBonusNumber();
                Bonus bonus = Bonus.create(answerNumbers, bonusNumber);
                BonusResponse bonusResponse = bonus.generateBonusResponse();
                return bonusResponse.getResponse();
            } catch (LottoException e) {
                println(e.getMessage());
            }
        }
    }

    private static Map<Integer, Integer> printPrizeResult(final List<List<Integer>> allLotto,
                                                          final List<Integer> answerNumbers, final int bonusNumber) {
        Prize prize = Prize.create(allLotto, answerNumbers, bonusNumber);
        ResultResponse resultResponse = prize.generateResultResponse();
        OutputView.printPrizeResult(resultResponse.getResponse());
        return resultResponse.getResponse();
    }

    private static void printProfit(int count, Map<Integer, Integer> prizeResult) {
        Profit profit = Profit.create(count, prizeResult);
        ProfitResponse profitResponse = profit.generateProfitResponse();
        OutputView.printLottoProfit(profitResponse.getResponse());
    }
}
