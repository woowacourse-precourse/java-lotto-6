package lotto;

import lotto.Logic.Lotto;
import lotto.Logic.Member;
import lotto.Logic.Prize;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MemberTest {

    Member member;

    @BeforeEach
    public void setUp(){
        member=new Member();
    }

    @DisplayName("구매금액이 숫자가 아니라면 예외가 발생한다.")
    @Test
    public void priceNotNumber() {
        assertThatThrownBy(() -> member.setPriceValid("abc"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매금액이 0 이하라면 예외가 발생한다.")
    @Test
    public void priceNotMinus() {
        assertThatThrownBy(() -> member.setPriceValid("-1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매금액이 1000원 단위가 아니라면 예외가 발생한다.")
    @Test
    public void priceNotDividedBy1000() {
        assertThatThrownBy(() -> member.setPriceValid("1999"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 구매금액에_따른_개수_설정_정상(){
        member.setCount(9000);

        Assertions.assertEquals(member.getCount(),9);
    }

    @Test
    public void 구매개수에_따른_사용자의_로또_생성_정상(){
        member.createMemberLotto(5);

        Assertions.assertEquals(member.getMemberLotto().size(),5);
    }

    @Test
    public void 당첨통계_리스트_생성_정상(){
        member.setPrize(Prize.first);
        member.setPrize(Prize.second);
        member.setPrize(Prize.fourth);
        member.setPrize(Prize.fourth);

        Assertions.assertEquals(List.of(1,1,0,2,0),member.prizeResult());
    }

    @Test
    public void 수익률_도출_정상1(){
        member.setPriceValid("10000");

        member.setPrize(Prize.second);
        member.setPrize(Prize.fourth);
        member.setPrize(Prize.fourth);

        Assertions.assertEquals("301000.0",member.getProfit());
    }

    @Test
    public void 수익률_도출_정상2(){
        member.setPriceValid("10000");

        member.setPrize(Prize.first);

        Assertions.assertEquals("20000000.0",member.getProfit());
    }

}
