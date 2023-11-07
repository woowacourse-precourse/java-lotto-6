package lotto;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class UserInput {
    private static final String ERROR_MESSAGE = "[ERROR]";
    private static final String PRICE_EXPLANATION = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_EXPLANATION = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_EXPLANATION = "보너스 번호를 입력해 주세요.";

    public static LottoTicketMoney inputPrice() {
        while (true) {
            try {
                System.out.println(PRICE_EXPLANATION);
                return new LottoTicketMoney(Integer.parseInt(readLine()));
            } catch (IllegalArgumentException illegalArgumentException) {
                System.out.println(ERROR_MESSAGE + illegalArgumentException.getMessage());
            }
        }
    }

    public static Lotto inputWinningLotto() {
        while (true) {
            try {
                System.out.println(WINNING_NUMBER_EXPLANATION);
                return new Lotto(readLine());
            } catch (IllegalArgumentException illegalArgumentException) {
                System.out.println(ERROR_MESSAGE + illegalArgumentException.getMessage());
            }
        }
    }
}
