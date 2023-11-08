package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class LottoTicketManagerTest {

    private final LottoTicketManager lottoTicketManager = new LottoTicketManager();

    @Test
    @DisplayName("금액에 맞는 번호 갯수 반환 ")
    public void 금액에_맞는_로또_개수_테스트() {
        assertEquals(1234,lottoTicketManager.countTickets("1234000"));
    }

    @Test
    @DisplayName("보너스 번호에는 1 ~ 45 사이의 숫자만 입력할 수 있다.")
    void 보너스_번호_범위_예외_테스트(){
        Assertions.assertThatThrownBy(()->lottoTicketManager.getBonusNumber(46))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 번호에는 당첨 번호와 중복 입력할 수 없다.")
    void 보너스_번호_중복_예외_테스트() {
        lottoTicketManager.getLuckyNumber(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        Assertions.assertThatThrownBy(() -> lottoTicketManager.getBonusNumber(6))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("lottoData")
    @DisplayName("당첨 번호와 일치하는 로또 번호 갯수 반환 테스트")
    public void 당첨_일치하는_번호_개수_확인(Lotto input, Integer expected) {
        lottoTicketManager.getLuckyNumber(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        assertThat(lottoTicketManager.correctLuckyNumber(input)).isEqualTo(expected);
    }

    static Stream<Arguments> lottoData() {
        return Stream.of(
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 6),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 7)), 5),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 10, 11)), 4),
                Arguments.of(new Lotto(List.of(12, 27, 32, 4, 5, 6)), 3),
                Arguments.of(new Lotto(List.of(12, 32, 43, 24, 5, 6)), 2),
                Arguments.of(new Lotto(List.of(18, 21, 43, 24, 15, 6)), 1),
                Arguments.of(new Lotto(List.of(11, 12, 13, 14, 15, 16)), 0)
        );
    }

    @ParameterizedTest
    @MethodSource("bonusData")
    @DisplayName("보너스 번호와 일치하는 로또 참,거짓 반환 테스트")
    public void 보너스_번호_일치_확인(Lotto input, boolean expected) {
        lottoTicketManager.getLuckyNumber(new Lotto(List.of(1, 3, 5, 7, 8, 11)));
        lottoTicketManager.getBonusNumber(2);
        Assertions.assertThat(lottoTicketManager.correctBonusNumber(input)).isEqualTo(expected);
    }

    static Stream<Arguments> bonusData() {
        return Stream.of(
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), true),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 7)), true),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 10, 11)), true),
                Arguments.of(new Lotto(List.of(12, 27, 32, 4, 5, 6)), false),
                Arguments.of(new Lotto(List.of(12, 32, 43, 24, 5, 6)), false),
                Arguments.of(new Lotto(List.of(18, 21, 43, 24, 15, 2)), true),
                Arguments.of(new Lotto(List.of(11, 12, 13, 14, 15, 16)), false)
        );
    }

    @Test
    @DisplayName("당첨금 총 합계가 정상 작동하는지 확인 합니다.")
    public void 당첨금_총합계_테스트() {
        lottoTicketManager.countTickets("5000");
        lottoTicketManager.setUserLottoTickets(new ArrayList<>(initLottoList()));
        lottoTicketManager.getLuckyNumber(new Lotto(List.of(11, 12, 13, 14, 25, 36)));
        lottoTicketManager.getBonusNumber(2);
        lottoTicketManager.makeResult();
        Assertions.assertThat(lottoTicketManager.getTotalPrize()).isEqualTo(2_030_100_000);
    }

    @Test
    @DisplayName("수익률 계산이 정상 작동하는지 확인 합니다.")
    public void 수익률_계산_테스트() {
        lottoTicketManager.countTickets("5000");
        lottoTicketManager.setUserLottoTickets(new ArrayList<>(initLottoList()));
        lottoTicketManager.getLuckyNumber(new Lotto(List.of(11, 12, 13, 14, 25, 36)));
        lottoTicketManager.getBonusNumber(2);
        lottoTicketManager.makeResult();
        Assertions.assertThat(lottoTicketManager.calculateRevenue()).isEqualTo(40_602_000);
    }

    private List<Lotto> initLottoList() {
        List<Lotto> list = new ArrayList<>();
        list.add(new Lotto(List.of(11, 12, 13, 14, 25, 36)));
        list.add(new Lotto(List.of(11, 12, 13, 14, 25, 2)));
        list.add(new Lotto(List.of(11, 12, 13, 14, 17, 1)));
        list.add(new Lotto(List.of(11, 12, 13, 14, 29, 1)));
        list.add(new Lotto(List.of(11, 12, 23, 24, 39, 1)));
        return list;
    }


}