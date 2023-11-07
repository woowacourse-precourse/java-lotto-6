package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.*;


class UserTest {

    @AfterEach
    void test() {
        Console.close();
    }

    @Test
    @DisplayName(value = "구입 금액이 정상 입력 된 케이스")
    void 구입_금액_정상_입력() {
        String input = "14000";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        User user = User.getInstance();
        int purchaseAmount = user.inputPurchaseAmount();
        int count = user.injectCount(purchaseAmount);

        assertThat(count).isEqualTo(14);
    }

    @Test
    @DisplayName(value = "구입 금액이 1000원 단위가 아닌 경우")
    void 구입_금액_비정상_입력() {
        String input = "14310";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        User user = User.getInstance();
        assertThatThrownBy(user::inputPurchaseAmount).isInstanceOf(Exception.class);
    }

    @Test
    @DisplayName(value = "당첨번호 정상 입력")
    void 당첨번호_정상입력() {
        String input = "1,2,3,4,5,6";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        User user = User.getInstance();
        Lotto lotto = user.inputLottoNumbers();

        List<Integer> expectedNumbers = new ArrayList<>();
        IntStream.rangeClosed(1, 6).forEach(expectedNumbers::add);

        assertThat(expectedNumbers.contains(lotto));
    }
}