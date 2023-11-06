package lotto.domain;

import static lotto.enums.Prize.*;
import static org.assertj.core.api.Assertions.*;

import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningDetailsTest {

    List<Lotto> lottos;

    @BeforeEach
    public void init(){
        lottos = List.of(
                new Lotto("1,2,3,4,5,6"),
                new Lotto("7,8,9,10,11,12"),
                new Lotto("13,14,15,16,17,18"),
                new Lotto("19,20,21,22,23,24"),
                new Lotto("25,26,27,28,29,30"),
                new Lotto("31,32,33,34,35,36")
        );
    }

    @Test
    @DisplayName("1등이 1개 당첨된 경우")
    void 일등_한개_당첨() throws Exception{
        //given
        List<Integer> winningNumbers = List.of(1,2,3,4,5,6);
        final int bonusNumber = 7;

        //when
        WinningDetails winningDetails = new WinningDetails(lottos,winningNumbers,bonusNumber);
        HashMap<Integer,Integer> rank = winningDetails.getRank();

        //then
        assertThat(rank.get(FIRST_RANK.getRank())).isEqualTo(1);
    }

    @Test
    @DisplayName("2등이 1개 당첨된 경우")
    void 이등_한개_당첨() throws Exception{
        //given
        List<Integer> winningNumbers = List.of(1,2,3,4,5,9);
        final int bonusNumber = 6;

        //when
        WinningDetails winningDetails = new WinningDetails(lottos,winningNumbers,bonusNumber);
        HashMap<Integer,Integer> rank = winningDetails.getRank();

        //then
        assertThat(rank.get(SECOND_RANK.getRank())).isEqualTo(1);
    }

    @Test
    @DisplayName("3등이 1개 당첨된 경우")
    void 삼등_한개_당첨() throws Exception{
        //given
        List<Integer> winningNumbers = List.of(1,2,3,4,5,9);
        final int bonusNumber = 10;

        //when
        WinningDetails winningDetails = new WinningDetails(lottos,winningNumbers,bonusNumber);
        HashMap<Integer,Integer> rank = winningDetails.getRank();

        //then
        assertThat(rank.get(THIRD_RANK.getRank())).isEqualTo(1);
    }

    @Test
    @DisplayName("4등이 1개 당첨된 경우")
    void 사등_한개_당첨() throws Exception{
        //given
        List<Integer> winningNumbers = List.of(1,2,3,4,9,10);
        final int bonusNumber = 10;

        //when
        WinningDetails winningDetails = new WinningDetails(lottos,winningNumbers,bonusNumber);
        HashMap<Integer,Integer> rank = winningDetails.getRank();

        //then
        assertThat(rank.get(FOURTH_RANK.getRank())).isEqualTo(1);
    }

    @Test
    @DisplayName("5등이 1개 당첨된 경우")
    void 오등_한개_당첨() throws Exception{
        //given
        List<Integer> winningNumbers = List.of(1,2,3,9,10,22);
        final int bonusNumber = 10;

        //when
        WinningDetails winningDetails = new WinningDetails(lottos,winningNumbers,bonusNumber);
        HashMap<Integer,Integer> rank = winningDetails.getRank();

        //then
        assertThat(rank.get(FIFTH_RANK.getRank())).isEqualTo(1);
    }

    @Test
    @DisplayName("5등이 2개 당첨된 경우")
    void 오등_두개_당첨() throws Exception{
        //given
        List<Integer> winningNumbers = List.of(1,2,3,9,10,11);
        final int bonusNumber = 10;

        //when
        WinningDetails winningDetails = new WinningDetails(lottos,winningNumbers,bonusNumber);
        HashMap<Integer,Integer> rank = winningDetails.getRank();

        //then
        assertThat(rank.get(FIFTH_RANK.getRank())).isEqualTo(2);
    }
}
