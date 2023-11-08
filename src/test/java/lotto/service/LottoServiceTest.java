package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import static util.TestUtil.setInput;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.exception.InputExceptionTemplate;
import lotto.model.Lotto;
import lotto.view.InputValidator;
import lotto.view.InputView;

public class LottoServiceTest extends NsTest {

    private static final String INVALID_PURCHASE_AMOUNT = "[ERROR] 1,000원 단위의 숫자를 입력하세요. 최소 1,000원, 최대 100,000원을 구입할 수 있습니다.\n";
    private static final String INVALID_COUNT = "[ERROR] 로또 번호는 6개를 입력해야 합니다.\n";
    private static final String NUMBER_OUT_OF_RANGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.\n";
    private static final String DUPLICATED_NUMBER = "[ERROR] 로또 번호는 중복될 수 없습니다.\n";
    private static final String INVALID_BONUS_NUMBER = "[ERROR] 보너스 번호는 1부터 45 사이의 숫자이며, 당첨번호와 중복될 수 없습니다.\n";
    private static final String NO_INTEGER_ARRAY = "[ERROR] 숫자와 쉼표(,)만 입력해주세요.\n";
    private static final String NO_INTEGER = "[ERROR] 숫자만 입력해주세요.";

    private static final String ASK_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.\n";
    private static final String ASK_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.\n";
    private static final String ASK_BONUS_NUMBER = "보너스 번호를 입력해 주세요.\n";

    LottoService service = new LottoService(new InputExceptionTemplate());
    InputView inputView = new InputView(new InputValidator());

    @AfterEach
    void closeInput() {
        Console.close();
    }

    @DisplayName("구매금액 입력 예외가 발생하면 메시지를 출력하고 다시 입력한다.")
    @Test
    void inputPurchaseMoneyException() {
        // given
        setInput("String", "100", "1000000", "12345", "2000");

        // when
        service.askPurchaseMoney(inputView::askPurchaseMoney);

        // then
        assertThat(output())
                .contains(ASK_PURCHASE_AMOUNT)
                .contains(INVALID_PURCHASE_AMOUNT);
    }

    @DisplayName("당첨번호 입력 예외가 발생하면 메시지를 출력하고 다시 입력한다.")
    @Test
    void inputWinningNumberException() {
        // given
        setInput("String", "100", "1,1,3,4,6,6", "45,46,47,48,49,50", "1,2,3,4,5,6");

        // when
        service.askWinningNumbers(inputView::askWinningNumbers);

        // then
        assertThat(output())
                .contains(ASK_WINNING_NUMBERS)
                .contains(NUMBER_OUT_OF_RANGE)
                .contains(DUPLICATED_NUMBER)
                .contains(NO_INTEGER_ARRAY)
                .contains(INVALID_COUNT);
    }

    @DisplayName("보너스 번호 입력 예외가 발생하면 메시지를 출력하고 다시 입력한다.")
    @Test
    void inputBonusNumberException() {
        // given
        setInput("String", "100", "45,46,47,48,49,50", "7");

        // when
        service.createWinningNumbers(new Lotto(List.of(1,2,3,4,5,6)), inputView::askBonusNumber);

        // then
        assertThat(output())
                .contains(ASK_BONUS_NUMBER)
                .contains(NO_INTEGER)
                .contains(INVALID_BONUS_NUMBER);
    }

    @Override
    protected void runMain() {
    }
}
