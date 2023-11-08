package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResultTest {

    @DisplayName("로또 번호 6개가 일치하는데 보너스번호가 일치하지 않으면 1등에 해당한다.")
    @Test
    void 보너스번호_미포함_6개_일치하면_1등() {
        Result result = new Result(new LinkedHashMap<>());
        List<Integer> lotto = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNum = 7;
        result.compare(lotto,winningNumbers,bonusNum);
        assertEquals(1,result.getResult().get(Rank.FIRST));
    }

    @DisplayName("로또 번호 6개가 일치하는데 보너스 일치하면 2등에 해당한다.")
    @Test
    void 보너스번호_포함_6개_일치하면_2등() {
        Result result = new Result(new LinkedHashMap<>());
        List<Integer> lotto = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 7);
        int bonusNum = 6;
        result.compare(lotto,winningNumbers,bonusNum);
        assertEquals(1,result.getResult().get(Rank.SECOND));
    }

    @DisplayName("보너스번호 포함하여 로또 번호 5개가 일치하는데 2등에 해당한다.")
    @Test
    void 보너스번호_포함_5개_일치하면_3등() {
        Result result = new Result(new LinkedHashMap<>());
        List<Integer> lotto = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 45, 44);
        int bonusNum = 5;
        result.compare(lotto,winningNumbers,bonusNum);
        assertEquals(1,result.getResult().get(Rank.THIRD));
    }

    @DisplayName("보너스번호 미포함하여 로또 번호 5개가 일치하는데 2등에 해당한다.")
    @Test
    void 보너스번호_미포함_5개_일치하면_3등() {
        Result result = new Result(new LinkedHashMap<>());
        List<Integer> lotto = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 45);
        int bonusNum = 44;
        result.compare(lotto,winningNumbers,bonusNum);
        assertEquals(1,result.getResult().get(Rank.THIRD));
    }

    @DisplayName("보너스번호 미포함하여 로또 번호 4개가 일치하는데 2등에 해당한다.")
    @Test
    void 보너스번호_미포함_4개_일치하면_4등() {
        Result result = new Result(new LinkedHashMap<>());
        List<Integer> lotto = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 45, 44);
        int bonusNum = 43;
        result.compare(lotto,winningNumbers,bonusNum);
        assertEquals(1,result.getResult().get(Rank.FOURTH));
    }

    @DisplayName("보너스번호 미포함하여 로또 번호 4개가 일치하는데 2등에 해당한다.")
    @Test
    void 보너스번호_포함_4개_일치하면_4등() {
        Result result = new Result(new LinkedHashMap<>());
        List<Integer> lotto = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> winningNumbers = List.of(1, 2, 3, 45, 44, 43);
        int bonusNum = 4;
        result.compare(lotto,winningNumbers,bonusNum);
        assertEquals(1,result.getResult().get(Rank.FOURTH));
    }
}
