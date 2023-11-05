package lotto;

import domain.Lotto;
import domain.LottoGameResult;
import domain.LottoTicket;
import domain.PaymentCalculator;
import domain.WinningNumbers;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("구입 금액을 입력해 주세요.");
        int amount = Integer.parseInt(Console.readLine());

        LottoTicket ticket = PaymentCalculator.purchaseLottoTicket(amount);

        System.out.println(ticket.getLottoNumbers().size() + "개를 구매했습니다.");
        for (Lotto lotto : ticket.getLottoNumbers()) {
            System.out.println(lotto.getNumbers());
        }

        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNumbersInput = Console.readLine();
        List<Integer> winningNumbers = parseNumbers(winningNumbersInput);

        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());

        WinningNumbers winningNumbersObj = new WinningNumbers(new Lotto(winningNumbers), bonusNumber);

        LottoGameResult result = calculateResult(ticket, winningNumbersObj);
        printResult(result);
    }

    private static List<Integer> parseNumbers(String input) {
        String[] numberStrings = input.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String numberString : numberStrings) {
            numbers.add(Integer.parseInt(numberString));
        }
        return numbers;
    }
}