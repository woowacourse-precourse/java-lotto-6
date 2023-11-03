package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoManagerTest {
    @DisplayName("발행된 로또 수가 맞는지 확인")
    @Test
    void checkCorrectPublishLotto() {
        LottoBuyer buyer = new LottoBuyer();
        LottoManager manager = new LottoManager(buyer);
        buyer.buyLotto("11000");

        manager.publishLotto();

        assertThat(buyer.getMyLotts().size()).isEqualTo(11);
    }

    @Test
    void 당첨번호_입력시_숫자가아닌경우_체크() {
        String stringWinningNumbers = "1,2,3,4,5,7a";
        List<String> listToStream = Arrays.stream(stringWinningNumbers.split(",")).toList();

        LottoBuyer buyer = new LottoBuyer();
        LottoManager manager = new LottoManager(buyer);

        System.out.println(String.join("", listToStream));
        assertThatThrownBy(() -> manager.setWinningNumbers(listToStream))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨번호_입력시_1_45사이인지_체크() {
        String stringWinningNumbers = "1,12,673,4,5,6";
        List<String> listToStream = Arrays.stream(stringWinningNumbers.split(",")).toList();

        LottoBuyer buyer = new LottoBuyer();
        LottoManager manager = new LottoManager(buyer);

        assertThatThrownBy(() -> manager.setWinningNumbers(listToStream))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨번호_6개인지_체크() {
        String stringWinningNumbers = "1,12,3,4,9";
        List<String> listToStream = Arrays.stream(stringWinningNumbers.split(",")).toList();

        LottoBuyer buyer = new LottoBuyer();
        LottoManager manager = new LottoManager(buyer);

        assertThatThrownBy(() -> manager.setWinningNumbers(listToStream))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨번호_중복_체크() {
        String stringWinningNumbers = "1,1,3,4,9,12";
        List<String> listToStream = Arrays.stream(stringWinningNumbers.split(",")).toList();

        LottoBuyer buyer = new LottoBuyer();
        LottoManager manager = new LottoManager(buyer);

        assertThatThrownBy(() -> manager.setWinningNumbers(listToStream))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
