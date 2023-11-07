package lotto.view;


import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.stream.Collectors;
import lotto.Lotto;
import lotto.exception.BonusNumberException;
import lotto.exception.CashException;
import lotto.exception.WinningNumberException;

public class Input {

    private static final String INPUT_CASH = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    private CashException cashException = new CashException();
    private WinningNumberException winningNumberException = new WinningNumberException();
    private BonusNumberException bonusNumberException = new BonusNumberException();

    public int cash() {
        while (true) {
            try {
                System.out.println(INPUT_CASH);
                String cash = Console.readLine();
                cashException.validate(cash);
                System.out.println();
                return Integer.parseInt(cash);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public Lotto winningNumbers() {
        while (true) {
            try {
                System.out.println(INPUT_WINNING_NUMBERS);
                String[] inputNumbers = Console.readLine().split(",");
                winningNumberException.word(inputNumbers);
                int[] winningNumbers = Arrays.stream(inputNumbers).mapToInt(Integer::parseInt).toArray();
                Lotto winningLotto = new Lotto(Arrays.stream(winningNumbers).boxed().collect(Collectors.toList()));
                System.out.println();
                return winningLotto;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int bonusNumber(Lotto winningLotto) {
        while (true) {
            try {
                System.out.println(INPUT_BONUS_NUMBER);
                String bonusNumber = Console.readLine();
                bonusNumberException.validate(bonusNumber, winningLotto);
                System.out.println();
                return Integer.parseInt(bonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
