package lotto.serviceTest;

import lotto.domain.*;
import lotto.service.DecideAward;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DecideAwardTest {
    @Test
    @DisplayName("흐음")
    void test() {
        // 유효한 로또 번호와 당첨 번호 생성
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        // 유저 생성
        User user = new User(1, Collections.singletonList(new Lotto(lottoNumbers)));

        // 당첨 번호 및 유저의 로또를 전달하여 결과 계산
        JackpotNumber jackpotNumber = new JackpotNumber(new Lotto(winningNumbers));
        Result result = DecideAward.userResult(user, jackpotNumber);

        // 기대되는 결과를 정의
        Result expected = new Result();
        expected.add(Rank.FIRST);

        // 결과 확인
        assertThat(result.getResults()).isEqualTo(expected.getResults());
    }


}
