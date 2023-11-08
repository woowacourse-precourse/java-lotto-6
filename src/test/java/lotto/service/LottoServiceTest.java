package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoServiceTest {
    @DisplayName("1등 테스트")
    @Test
    void validateCalculateWinningsCountsFirst(){
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add( new Lotto(List.of(1,2,3,4,5,6)));
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6");

        LottoService lottoService = new LottoService();
        int[] counts = lottoService.calculateWinningsCounts(winningNumbers, lottoList);

        assertThat(counts).isEqualTo(Stream.of(0,0,0,0,1).mapToInt(i->i).toArray());
    }

    @DisplayName("2등 테스트")
    @Test
    void validateCalculateWinningsCountsSecond(){
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add( new Lotto(List.of(1,2,3,4,5,6)));
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,7");
        winningNumbers.setBonusNumber(6);

        LottoService lottoService = new LottoService();
        int[] counts = lottoService.calculateWinningsCounts(winningNumbers, lottoList);

        assertThat(counts).isEqualTo(Stream.of(0,0,0,1,0).mapToInt(i->i).toArray());
    }
    @DisplayName("3등 테스트")
    @Test
    void validateCalculateWinningsCountsThird(){
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add( new Lotto(List.of(1,2,3,4,5,6)));
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,7");
        winningNumbers.setBonusNumber(9);

        LottoService lottoService = new LottoService();
        int[] counts = lottoService.calculateWinningsCounts(winningNumbers, lottoList);

        assertThat(counts).isEqualTo(Stream.of(0,0,1,0,0).mapToInt(i->i).toArray());
    }
    @DisplayName("4등 테스트")
    @Test
    void validateCalculateWinningsCountsForth(){
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add( new Lotto(List.of(1,2,3,4,5,6)));
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,8,7");
        winningNumbers.setBonusNumber(9);

        LottoService lottoService = new LottoService();
        int[] counts = lottoService.calculateWinningsCounts(winningNumbers, lottoList);

        assertThat(counts).isEqualTo(Stream.of(0,1,0,0,0).mapToInt(i->i).toArray());
    }
    @DisplayName("5등 테스트")
    @Test
    void validateCalculateWinningsCountsFifth(){
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add( new Lotto(List.of(1,2,3,4,5,6)));
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,9,8,7");
        winningNumbers.setBonusNumber(9);

        LottoService lottoService = new LottoService();
        int[] counts = lottoService.calculateWinningsCounts(winningNumbers, lottoList);

        assertThat(counts).isEqualTo(Stream.of(1,0,0,0,0).mapToInt(i->i).toArray());
    }
}
