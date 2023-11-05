package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.dto.LottoResponses;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName("구매 개수만큼 사용자 로또 번호 생성 테스트")
class UserLottoTest {
    int input = 5;
    UserLotto userLotto = UserLotto.create(input);
    LottoResponses lottoResponses = userLotto.buildLottoResponses();
    List<List<Integer>> userLottos = lottoResponses.getResponses();

    @Test
    void 알맞은_개수의_로또_번호가_생성되었는지_확인한다() {
        userLottos.forEach(userLottoNumbers -> {
            assertEquals(6, userLottoNumbers.size());
        });
    }

    @Test
    void 중복되지_않은_숫자가_생성되었는지_확인한다() {
        userLottos.forEach(userLottoNumbers -> {
            Set<Integer> uniqueNumbers = new HashSet<>(userLottoNumbers);
            assertEquals(6, uniqueNumbers.size());
        });
    }

    @Test
    void 올바른_범위_내의_숫자가_생성되었는지_확인한다() {
        userLottos.forEach(userLottoNumbers -> {
            assertTrue(userLottoNumbers.stream().allMatch(number -> number >= 1 && number <= 45));
        });
    }
}
