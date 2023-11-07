package lotto;

import lotto.Logic.Lotto;
import lotto.Logic.Member;
import lotto.Logic.Prize;
import lotto.Logic.WinningNumber;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningNumberTest {
    WinningNumber winningNumber;
    String checkNumber;
    Lotto lotto;
    Member member;

    @BeforeEach
    public void setUp(){
        winningNumber=new WinningNumber();

        checkNumber="1,2,3,4,5,6";
        lotto=new Lotto(List.of(1,2,3,4,5,6));

        member=new Member();
    }

    @Test
    public void 당첨번호에_따른_split_및_파싱_정상(){
        winningNumber.splitValid(checkNumber);

        Assertions.assertEquals(winningNumber.getLotto().getNumbers(),lotto.getNumbers());
    }

    @DisplayName("당첨번호에 숫자가 아닌 값이 있으면 예외가 발생한다.")
    @Test
    public void splitDigitValid(){
        String[] checkNumber={"aa","1","2","3","4","5"};

        assertThatThrownBy(() -> winningNumber.digitValid(checkNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 보너스번호_설정_정상(){
        winningNumber.splitValid(checkNumber);
        winningNumber.setBonusValid("7");

        Assertions.assertEquals(7,winningNumber.getBonus());
    }

    @DisplayName("보너스 번호가 당첨번호와 중복되면 예외가 발생한다.")
    @Test
    public void bonusNumberRepeat(){
        winningNumber.splitValid(checkNumber);

        assertThatThrownBy(() -> winningNumber.bonusValid(1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 1~45 사이가 아니면 예외가 발생한다.")
    @Test
    public void bonusNumberOutOfRange(){
        winningNumber.splitValid(checkNumber);

        assertThatThrownBy(() -> winningNumber.bonusValid(100))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 숫자가 아니면 예외가 발생한다.")
    @Test
    public void bonusNumberValid(){
        winningNumber.splitValid(checkNumber);

        assertThatThrownBy(() -> winningNumber.setBonusValid("a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 로또_비교_4개_일치_보너스_일치(){
        List<Integer> winNumber=new ArrayList<>();
        winNumber.add(1); winNumber.add(2);
        winNumber.add(3); winNumber.add(4);
        winNumber.add(10); winNumber.add(11);
        List<Integer> result = winningNumber.correctBonus(lotto,winNumber,6);

        Assertions.assertEquals(List.of(4,0),result);
    }

    @Test
    public void 로또_비교_5개_일치_보너스_불일치(){
        List<Integer> winNumber=new ArrayList<>();
        winNumber.add(1); winNumber.add(2);
        winNumber.add(3); winNumber.add(4);
        winNumber.add(5); winNumber.add(10);

        List<Integer> result = winningNumber.correctBonus(lotto,winNumber,11);

        Assertions.assertEquals(List.of(5,0),result);
    }

    @Test
    public void 로또_비교_5개_일치_보너스_일치(){
        List<Integer> winNumber=new ArrayList<>();
        winNumber.add(1); winNumber.add(2);
        winNumber.add(3); winNumber.add(4);
        winNumber.add(5); winNumber.add(10);

        List<Integer> result = winningNumber.correctBonus(lotto,winNumber,6);

        Assertions.assertEquals(List.of(5,1),result);
    }

    @Test
    public void 당첨내역_1등_1개(){
        List<Lotto> memberLotto=new ArrayList<>();
        memberLotto.add(lotto);
        winningNumber.splitValid("1,2,3,4,5,6");
        winningNumber.setBonusValid("7");

        winningNumber.calculate(memberLotto,member);

        Assertions.assertEquals(List.of(Prize.first),member.getPrize());
    }

    @Test
    public void 당첨내역_1등_1개_2등_1개(){
        List<Lotto> memberLotto=new ArrayList<>();
        memberLotto.add(lotto);
        memberLotto.add(new Lotto(List.of(1,2,3,4,5,7)));

        winningNumber.splitValid("1,2,3,4,5,6");
        winningNumber.setBonusValid("7");

        winningNumber.calculate(memberLotto,member);

        Assertions.assertEquals(List.of(Prize.first,Prize.second),member.getPrize());
    }
}
