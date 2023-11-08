package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.Hashtable;
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

        assertThat(buyer.getMyLottos().size()).isEqualTo(11);
    }

    @Test
    void 당첨번호_입력시_숫자가아닌경우_체크() {
        String stringWinningNumbers = "1,2,3,4,5,7a";
        List<String> listToStream = Arrays.stream(stringWinningNumbers.split(",")).toList();

        LottoBuyer buyer = new LottoBuyer();
        LottoManager manager = new LottoManager(buyer);

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

    @Test
    void 보너스번호_당첨번호와_중복_체크() {
        String stringBonusNumber = "1";
        String stringWinningNumbers = "1,2,3,4,5,6";

        List<String> listToStream = Arrays.stream(stringWinningNumbers.split(",")).toList();
        List<String> listToStream2 = Arrays.stream(stringBonusNumber.split("")).toList();

        LottoBuyer buyer = new LottoBuyer();
        LottoManager manager = new LottoManager(buyer);
        manager.setWinningNumbers(listToStream);

        assertThatThrownBy(() -> manager.setBonusNumber(listToStream2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스번호_숫자타입_체크() {
        String stringBonusNumber = "1a";

        List<String> listToStream = Arrays.stream(stringBonusNumber.split("")).toList();

        LottoBuyer buyer = new LottoBuyer();
        LottoManager manager = new LottoManager(buyer);

        assertThatThrownBy(() -> manager.setBonusNumber(listToStream))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스번호_범위_체크() {
        String stringBonusNumber = "46";

        List<String> listToStream = Arrays.stream(stringBonusNumber.split("")).toList();

        LottoBuyer buyer = new LottoBuyer();
        LottoManager manager = new LottoManager(buyer);

        assertThatThrownBy(() -> manager.setBonusNumber(listToStream))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스번호_갯수_체크() {
        String stringBonusNumber = "42,45";

        List<String> listToStream = Arrays.stream(stringBonusNumber.split(",")).toList();

        LottoBuyer buyer = new LottoBuyer();
        LottoManager manager = new LottoManager(buyer);

        assertThatThrownBy(() -> manager.setBonusNumber(listToStream))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨결과확인() {
        int forthPlace = 4;
        LottoBuyer buyer = new LottoBuyer();
        LottoManager manager = new LottoManager(buyer);
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 7));

        List<String> winningNumbers = List.of("1", "2", "3", "4", "8", "9");
        List<String> bonusNumber = List.of("10");

        manager.setWinningNumbers(winningNumbers);
        manager.setBonusNumber(bonusNumber);
        buyer.addMyLottos(lotto1);
        buyer.addMyLottos(lotto2);

        manager.setWinningResult();
        manager.announceResult();
        Hashtable<Integer, Integer> copiedWinningTable = manager.getWinningCountTable();

        assertThat(copiedWinningTable.get(forthPlace)).isEqualTo(2);
    }

    @Test
    void 총수익률확인() {
        LottoBuyer buyer = new LottoBuyer();
        LottoManager manager = new LottoManager(buyer);
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 11, 12, 14));
        buyer.buyLotto("8000");
        List<String> winningNumbers = List.of("1", "2", "3", "4", "8", "9");
        manager.setWinningNumbers(winningNumbers);
        buyer.addMyLottos(lotto1);

        manager.setWinningResult();
        manager.announceResult();

        assertThat(manager.getTotalRateOfRevenue()).isEqualTo(62.5f);
    }
}
