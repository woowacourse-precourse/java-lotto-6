package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.domain.Customer;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import lotto.util.TypeConverter;

public class InputView {
    private static final String PURCHASE_AMOUNT_INPUT = "구입금액을 입력해 주세요.\n";
    private static final String WINNING_NUMBER_INPUT = "당첨 번호를 입력해 주세요.\n";
    private final TypeConverter typeConverter;

    public InputView(TypeConverter typeConverter) {
        this.typeConverter = typeConverter;
    }

    public Customer getCustomer() {
        System.out.print(PURCHASE_AMOUNT_INPUT);
        String input = Console.readLine();
        return typeConverter.convertStringToCustomer(input);
    }

    public WinningLotto getWinningLotto() {
        Lotto lotto = inputLotto();
        return null;
    }

    private Lotto inputLotto() {
        System.out.print(WINNING_NUMBER_INPUT);
        String input = Console.readLine();
        return typeConverter.convertStringToLotto(input);
    }
}
