package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.game.GameOperator;
import lotto.domain.lotto.Bonus;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoDraw;
import lotto.domain.money.Wallet;
import lotto.domain.prize.Prize;
import lotto.domain.prize.LottoPrizeSummary;
import lotto.domain.prize.Prizes;

import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ConsoleInputOutput implements GameOperator {
    @Override
    public Wallet inputBuyPrice() {
        String msg = "구입금액을 입력해 주세요.";

        return promptInput(msg, Converter::stringToWallet);
    }

    @Override
    public void buyMessage(List<Lotto> lottos) {
        print(lottos.size() + "개를 구매했습니다.");

        String msg = lottos.stream()
                .map(Lotto::printNumber)
                .collect(Collectors.joining("\n"));

        print(msg);
    }

    @Override
    public LottoDraw inputAccordNumbers() {
        Lotto lotto = inputAccordLottoNumber();

        Bonus bonus = inputBonusNumber(lotto);

        return new LottoDraw(lotto, bonus);
    }

    private Lotto inputAccordLottoNumber() {
        String msg = "당첨 번호를 입력해 주세요.";
        return promptInput(msg, Converter::stringToLotto);
    }

    private Bonus inputBonusNumber(Lotto lotto) {
        String msg = "보너스 번호를 입력해 주세요.";

        return promptInput(msg, Converter::stringToBonus, lotto);
    }

    private <T> T promptInput(String promptMessage, Function<String, T> converter) {
        return promptInput(promptMessage, (input, context) -> converter.apply(input), null);
    }

    private <T> T promptInput(String promptMessage, BiFunction<String, Lotto, T> converter, Lotto context) {
        T result = null;
        boolean isValidInput = false;

        while (!isValidInput) {
            try {
                print(promptMessage);
                String userInput = Console.readLine();
                result = converter.apply(userInput, context);
                isValidInput = true;
            } catch (IllegalArgumentException e) {
                print("입력이 유효하지 않습니다. 다시 시도해주세요.");
                print(e.getMessage());
            }
        }

        return result;
    }

    @Override
    public void printResult(LottoPrizeSummary lottoPrizeSummary) {
        String result = lottoPrizeSummary.prizesCount().entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .filter(entry -> entry.getKey() != Prize.NONE)
                .map(entry -> entry.getKey().getMsg() + entry.getValue() + "개")
                .collect(Collectors.joining("\n"));

        print(result);
    }

    @Override
    public void printProfitRatio(Wallet wallet, Prizes prizes) {
        float profitRatio = wallet.calculateProfitRatio(prizes.sumProfit());
        String message = String.format("총 수익률은 %.1f%%입니다.", profitRatio);

        print(message);
    }

    @Override
    public void print(String msg) {
        System.out.println(msg);
    }
}
