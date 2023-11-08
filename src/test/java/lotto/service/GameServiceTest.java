package lotto.service;

import lotto.domain.Game;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GameServiceTest {
    private static final List<Integer> FIRST_RANK_LOTTO = List.of(1,2,3,4,5,6);
    private static final List<Integer> SECOND_RANK_LOTTO = List.of(1,2,3,4,5,45);
    private static final List<Integer> THIRD_RANK_LOTTO = List.of(2,3,4,5,6,7);
    private static final List<Integer> FOURTH_RANK_LOTTO = List.of(3,4,5,6,7,8);
    private static final List<Integer> BONUS_FOURTH_RANK_LOTTO = List.of(3,4,5,6,7,45);
    private static final List<Integer> FIFTH_RANK_LOTTO = List.of(4,5,6,7,8,9);
    private static final List<Integer> BONUS_FIFTH_RANK_LOTTO = List.of(4,5,6,7,8,45);
    private static final List<Integer> NO_RANK_TWO_LOTTO = List.of(5,6,7,8,9,10);
    private static final List<Integer> BONUS_NO_RANK_TWO_LOTTO = List.of(5,6,7,8,9,45);
    private static final List<Integer> NO_RANK_ONE_LOTTO = List.of(6,7,8,9,10,11);
    private static final List<Integer> BONUS_NO_RANK_ONE_LOTTO = List.of(6,7,8,9,10,45);
    private static final List<Integer> NO_RANK_ZERO_LOTTO = List.of(7,8,9,10,11,12);
    private static final List<Integer> BONUS_NO_RANK_ZERO_LOTTO = List.of(7,8,9,10,11,45);

    private final GameService gameService = new GameService();

    @DisplayName("당첨된 로또 개수를 등수별로 저장하는 기능 테스트")
    @Test
    void saveMatchRankTest(){
        //given
        final Game lottogame = new Game(List.of(1,2,3,4,5,6),45);
        final User cases = new User(1000);
        //로또 번호 리스트, 보너스번호 상수화하기
        cases.buyLotto(new Lotto(FIRST_RANK_LOTTO));    //6개 일치
        cases.buyLotto(new Lotto(SECOND_RANK_LOTTO));   //5개 일치 + 보너스번호 일치
        cases.buyLotto(new Lotto(THIRD_RANK_LOTTO));    //5개 일치
        cases.buyLotto(new Lotto(FOURTH_RANK_LOTTO));   //4개 일치
        cases.buyLotto(new Lotto(FIFTH_RANK_LOTTO));    //3개 일치
        cases.buyLotto(new Lotto(NO_RANK_TWO_LOTTO));   //2개 일치
        cases.buyLotto(new Lotto(NO_RANK_ONE_LOTTO));  //1개 일치
        cases.buyLotto(new Lotto(NO_RANK_ZERO_LOTTO)); //0개 일치

        //when
        gameService.checkUserLotteries(cases, lottogame);
        HashMap<Rank,Integer> results = cases.getLottoResult();

        //then
        assertThat(results.get(Rank.FIRST)).isEqualTo(1);
        assertThat(results.get(Rank.SECOND)).isEqualTo(1);
        assertThat(results.get(Rank.THIRD)).isEqualTo(1);
        assertThat(results.get(Rank.FOURTH)).isEqualTo(1);
        assertThat(results.get(Rank.FIFTH)).isEqualTo(1);
        assertThat(results.get(Rank.NO_RANK_TWO)).isEqualTo(1);
        assertThat(results.get(Rank.NO_RANK_ONE)).isEqualTo(1);
        assertThat(results.get(Rank.NO_RANK_ZERO)).isEqualTo(1);
    }

    @DisplayName("구매한 로또 번호에 보너스번호가 포함여부를 확인하고 2등 선정 테스트")
    @Test
    void isContainBonusNumberTest(){
        //given
        final Game lottogame = new Game(List.of(1,2,3,4,5,6),45);
        final User cases = new User(1000);
        //로또 번호 리스트, 보너스번호 상수화하기
        cases.buyLotto(new Lotto(SECOND_RANK_LOTTO));   //5개 일치 + 보너스번호 일치
        cases.buyLotto(new Lotto(BONUS_FOURTH_RANK_LOTTO));    //4개 일치 + 보너스번호 일치
        cases.buyLotto(new Lotto(BONUS_FIFTH_RANK_LOTTO));    //3개 일치 + 보너스번호 일치
        cases.buyLotto(new Lotto(BONUS_NO_RANK_TWO_LOTTO));   //2개 일치 + 보너스번호 일치
        cases.buyLotto(new Lotto(BONUS_NO_RANK_ONE_LOTTO));  //1개 일치 + 보너스번호 일치
        cases.buyLotto(new Lotto(BONUS_NO_RANK_ZERO_LOTTO)); //0개 일치 + 보너스번호 일치

        //when
        gameService.checkUserLotteries(cases, lottogame);
        HashMap<Rank,Integer> results = cases.getLottoResult();

        //then
        assertThat(results.get(Rank.SECOND)).isEqualTo(1);
        assertThat(results.get(Rank.FOURTH)).isEqualTo(1);
        assertThat(results.get(Rank.FIFTH)).isEqualTo(1);
        assertThat(results.get(Rank.NO_RANK_TWO)).isEqualTo(1);
        assertThat(results.get(Rank.NO_RANK_ONE)).isEqualTo(1);
        assertThat(results.get(Rank.NO_RANK_ZERO)).isEqualTo(1);
    }


}