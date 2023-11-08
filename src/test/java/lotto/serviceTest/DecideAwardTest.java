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
    @DisplayName("사용자의 로또 번호와 당첨 번호에 따른 올바른 결과 반환 여부 테스트 ")
    void examineGettingAwardtest() {
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        User user = new User(1, Collections.singletonList(new Lotto(lottoNumbers)));

        JackpotNumber jackpotNumber = new JackpotNumber(new Lotto(winningNumbers));
        Result result = DecideAward.userResult(user, jackpotNumber);

        Result expected = new Result();
        expected.add(Rank.FIRST);

        assertThat(result.getResults()).isEqualTo(expected.getResults());
    }


}
