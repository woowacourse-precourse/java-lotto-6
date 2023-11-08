package lotto.io;

import lotto.domain.lotto.BonusNumber;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.PurchasePrice;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.mock;

@DisplayName("입력 변환 객체에 대해")
class InputMapperTest {

    private final InputMapper inputMapper = new InputMapper();

    @Test
    @DisplayName("구매 가격을 입력하면 PurchasePrice 객체로 변환하여 로또 개수를 가진다.")
    void Given_ToPurchasePrice_When_GetLottosAmount_Then_EqualAmount() {
        //given
        PurchasePrice PurchasePrice = inputMapper.toPurchasePrice("2000");

        //when
        Integer actual = PurchasePrice.getLottosAmount();

        //then
        assertThat(actual).isEqualTo(2);
    }

    @Test
    @DisplayName("당첨 번호를 입력하면 Lotto 객체로 변환되어 저장한다.")
    void Given_ToLotto_When_GetNumbers_Then_ContainsExactly() {
        Lotto lotto = inputMapper.toLotto("1,2,3,4,5,6");

        List<Integer> actualValues = lotto.getNumbers();

        assertThat(actualValues).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    @DisplayName("보너스 번호를 입력하면 BonusNumber 객체로 변환되어 일치한 BonusNumber라면 true를 반환한다.")
    void Given_ToBonusNumber_When_MatchBonusNumber_Then_ReturnTrue() {
        //given
        Lotto lotto = mock(Lotto.class);
        BonusNumber bonusNumber = inputMapper.toBonusNumber("3", lotto);

        //when
        boolean actual = bonusNumber.isMatchBonusNumber(3);

        //then
        assertTrue(actual);
    }

    @Test
    @DisplayName("보너스 번호를 입력하면 BonusNumber 객체로 변환되어 일치하지 않은 BonusNumber라면 false를 반환한다.")
    void Given_ToBonusNumber_When_MatchBonusNumber_Then_ReturnFalse() {
        //given
        Lotto lotto = mock(Lotto.class);
        BonusNumber bonusNumber = inputMapper.toBonusNumber("3", lotto);

        //when
        boolean actual = bonusNumber.isMatchBonusNumber(4);

        //then
        assertFalse(actual);
    }
}
