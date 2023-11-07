package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.GuessLotto;
import lotto.domain.Lotto;
import lotto.domain.WinningLottoList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;



public class Application {
    private static final String REQUEST_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String REQUEST_LOTTO_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String REQUEST_LOTTO_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String SHOW_WINNING_STATISTICS = "당첨 통계" + "\n" + "---";

    public static int lottery;

    public static void main(String[] args) {
        System.out.println(REQUEST_PURCHASE_AMOUNT);

        try {
            int price = Integer.parseInt(Console.readLine());
            lottery = price / 1000;
            System.out.println(lottery + "개를 구매했습니다.");

        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력하세요.");
        }

        WinningLottoList lotterys = new WinningLottoList(lottery);
        lotterys.printWinningLottoList();

        System.out.println(REQUEST_LOTTO_NUMBER);
        String[] splittedNumbers = Console.readLine().split(",");
        List<Integer> numbers = Arrays.stream(splittedNumbers).map(Integer::parseInt).collect(Collectors.toList());
        Lotto lotto = new Lotto(numbers);

        System.out.println(REQUEST_LOTTO_BONUS_NUMBER);
        int bonusNumber = Integer.parseInt(Console.readLine());

         GuessLotto guessLotto = new GuessLotto(lotto, bonusNumber);







    }
}
