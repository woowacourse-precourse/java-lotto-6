package lotto.view;

import lotto.Lotto;
import lotto.model.Customer;
import lotto.view.constant.ConstantMessage;
import lotto.view.constant.ErrorMessage;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.view.constant.ConstantMessage.*;

public class OutputView {
    public OutputView() {}

    public static void printConstantMessage(ConstantMessage message) {
        System.out.print(message);
    }

    public static void printBuyLotto(ConstantMessage message, int number) {
        print(String.format(String.valueOf(message), number));
    }

    public static void printLottos(Customer _customer) {
        List<Lotto> lotts = _customer.getLottos();
        for(Lotto lotto: lotts) {
            println(lotto.getNumbers().toString());
        }
    }

    public static void printLottoWinning(List<Integer> _winningNumber) {
        println(_winningNumber.stream().map(String::valueOf)
                .collect(Collectors.joining(",")));
    }

    public static void printWinningStatics(List<Integer> _winning) {
        println(String.format(String.valueOf(THREE_MATCH), _winning.get(0)));
        println(String.format(String.valueOf(FOUR_MATCH), _winning.get(1)));
        println(String.format(String.valueOf(FIVE_MATCH), _winning.get(2)));
        println(String.format(String.valueOf(FIVE_BONUS_MATCH), _winning.get(4)));
        println(String.format(String.valueOf(SIX_MATCH), _winning.get(3)));
    }

    public static void printRateOfReturn(double _rateOfReturn) {
        println(String.format(String.valueOf(TOTAL_RATE_OF_RETURN), _rateOfReturn+"%"));
    }

    public static void print(String message) {
        System.out.print(message);
    }

    public static void println(String message) {
        System.out.println(message);
    }

    public static void printError(String message) {
        println(ErrorMessage.ERROR.getMessage() + message + "\n");
    }
}
