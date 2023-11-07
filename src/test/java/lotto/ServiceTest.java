package lotto;

import lotto.domain.Client;
import lotto.domain.Game;
import lotto.domain.Lotto;
import lotto.domain.Prize;
import lotto.service.Service;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ServiceTest {

    final Service service = new Service();
    private static final List<Integer> FIRST_GRADE =List.of(1,2,3,4,5,6);
    private static final List<Integer> SECOND_GRADE =List.of(1,2,3,4,5,30);
    private static final List<Integer> THIRD_GRADE =List.of(1,2,3,4,5,7);
    private static final List<Integer> FORTH_GRADE =List.of(1,2,3,4,7,8);
    private static final List<Integer> FIFTH_GRADE =List.of(1,2,3,7,8,9);
    private static final List<Integer> BLANK_GRADE_TWO =List.of(1,2,7,8,9,10);
    private static final List<Integer> BLANK_GRADE_ONE =List.of(1,7,8,9,10,11);
    private static final List<Integer> BLANK_GRADE_ZERO =List.of(7,8,9,10,11,12);

    private static final List<Integer> FORTH_GRADE_PLUS_BONUS =List.of(1,2,3,4,7,30);
    private static final List<Integer> FIFTH_GRADE_PLUS_BONUS =List.of(1,2,3,7,8,30);
    private static final List<Integer> BLANK_GRADE_TWO_PLUS_BONUS =List.of(1,2,7,8,9,30);
    private static final List<Integer> BLANK_GRADE_ONE_PLUS_BONUS =List.of(1,7,8,9,10,30);
    private static final List<Integer> BLANK_GRADE_ZERO_PLUS_BONUS =List.of(7,8,9,10,11,30);

    @DisplayName("입력된 금액만큼 로또번호들이 발급되야한다")
    @Test
    void checkBuyLotto(){
        //given
        final Client example1 = new Client(5000);

        //when
        service.buyLotto(example1);

        //then
        assertThat(example1.getClientLottoList().size()).isEqualTo(5);
    }

    @DisplayName("당첨된 로또 개수예 따라 등급별로 저장")
    @Test
    void testPrizeGrade(){
        //given
        final Game game = new Game(List.of(1,2,3,4,5,6),30);
        final Client examples = new Client(1000);

        examples.addClientLotto(new Lotto(FIRST_GRADE));    //6개일치
        examples.addClientLotto(new Lotto(SECOND_GRADE));   //5개일치 + 보너스일치
        examples.addClientLotto(new Lotto(THIRD_GRADE));    //5개일치
        examples.addClientLotto(new Lotto(FORTH_GRADE));    //4개일치
        examples.addClientLotto(new Lotto(FIFTH_GRADE));    //3개일치
        examples.addClientLotto(new Lotto(BLANK_GRADE_TWO));    //2개일치
        examples.addClientLotto(new Lotto(BLANK_GRADE_ONE));    //1개일치
        examples.addClientLotto(new Lotto(BLANK_GRADE_ZERO));   //0개일치

        //when
        service.checkResult(examples,game);
        HashMap<Prize,Integer> results = examples.getResult();

        //then
        assertThat(results.get(Prize.FIRST)).isEqualTo(1);
        assertThat(results.get(Prize.SECOND)).isEqualTo(1);
        assertThat(results.get(Prize.THIRD)).isEqualTo(1);
        assertThat(results.get(Prize.FORTH)).isEqualTo(1);
        assertThat(results.get(Prize.FIFTH)).isEqualTo(1);
        assertThat(results.get(Prize.BLANK_TWO)).isEqualTo(1);
        assertThat(results.get(Prize.BLANK_ONE)).isEqualTo(1);
        assertThat(results.get(Prize.BLANK_ZERO)).isEqualTo(1);

    }

    @DisplayName("보너스 번호가 2등 선정에만 반영되는지 확인")
    @Test
    void checkBonusNumberFeedbackOnlyToSecondGrade(){
        //given
        final Game game = new Game(List.of(1,2,3,4,5,6),30);
        final Client examples = new Client(1000);

        examples.addClientLotto(new Lotto(SECOND_GRADE)); //5개일치 + 보너스일치
        examples.addClientLotto(new Lotto(FORTH_GRADE_PLUS_BONUS)); //4개일치 + 보너스일치
        examples.addClientLotto(new Lotto(FIFTH_GRADE_PLUS_BONUS)); //3개일치 + 보너스일치
        examples.addClientLotto(new Lotto(BLANK_GRADE_TWO_PLUS_BONUS)); //2개일치 + 보너스일치
        examples.addClientLotto(new Lotto(BLANK_GRADE_ONE_PLUS_BONUS)); //1개일치 + 보너스일치
        examples.addClientLotto(new Lotto(BLANK_GRADE_ZERO_PLUS_BONUS)); //0개일치 + 보너스일치

        //when
        service.checkResult(examples,game);
        HashMap<Prize,Integer> results = examples.getResult();

        //then
        assertThat(results.get(Prize.SECOND)).isEqualTo(1);
        assertThat(results.get(Prize.FORTH)).isEqualTo(1);
        assertThat(results.get(Prize.FIFTH)).isEqualTo(1);
        assertThat(results.get(Prize.BLANK_TWO)).isEqualTo(1);
        assertThat(results.get(Prize.BLANK_ONE)).isEqualTo(1);
        assertThat(results.get(Prize.BLANK_ZERO)).isEqualTo(1);


    }
}
