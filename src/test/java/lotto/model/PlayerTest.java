package lotto.model;

import lotto.dto.LottoDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.utility.TestConstant.*;
import static org.assertj.core.api.Assertions.*;

@DisplayName("Player Domain 테스트")
public class PlayerTest {
    private final List<Integer> lotto = List.of(1,2,3,4,5,6);
    private final List<Integer> emptyResult = List.of(0,0,0,0,0);
    private Player player;

    @BeforeEach
    public void initTest() {
        player = new Player(INIT_COST.getConstant());
    }

    @Test
    @DisplayName("addLotto() method 테스트")
    public void addLottoTest() {
        // when
        player.addLotto(lotto);

        // then
        assertThat(player.getLottoNumbers().size()).isEqualTo(CONSTANT_ONE.getConstant());
    }

    @Test
    @DisplayName("getLottoNumbers() method 테스트")
    public void getLottoNumbersTest() {
        // when
        List<LottoDto> lottoNumbers = player.getLottoNumbers();

        // then
        assertThat(lottoNumbers.size()).isEqualTo(CONSTANT_ZERO.getConstant());
    }

    @Test
    @DisplayName("updateResult() method 테스트")
    public void updateResultTest() {
        // when
        player.updateResult(VALID_GRADE.getConstant());

        // when
        assertThat(player.getResults()).isNotEqualTo(emptyResult);
    }

    @Test
    @DisplayName("getResults() method 테스트")
    public void getResultsTest() {
        // when
        List<Integer> results = player.getResults();

        // then
        assertThat(results).isEqualTo(emptyResult);
    }
}
