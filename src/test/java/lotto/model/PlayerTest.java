package lotto.model;

import lotto.dto.LottoDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@DisplayName("Player Domain 테스트")
public class PlayerTest {
    private final List<Integer> lotto = List.of(1,2,3,4,5,6);
    private final List<Integer> emptyResult = List.of(0,0,0,0,0);
    private final List<Integer> result = List.of(0,0,0,0,1);
    private final int INIT_VALUE = 10;
    private final int NOT_EMPTY_SIZE = 1;
    private final int EMPTY_SIZE = 0;
    private final int GRADE_VALID = 1;
    private Player player;

    @BeforeEach
    public void initTest() {
        player = new Player(INIT_VALUE);
    }

    @Test
    @DisplayName("createDomain() method 테스트")
    public void createDomainTest() {
        // when - then
        assertThat(player.getLottoNumbers().isEmpty()).isTrue();
    }

    @Test
    @DisplayName("addLotto() method 테스트")
    public void addLottoTest() {
        // when
        player.addLotto(lotto);

        // then
        assertThat(player.getLottoNumbers().size()).isEqualTo(NOT_EMPTY_SIZE);
    }

    @Test
    @DisplayName("getLottoNumbers() method 테스트")
    public void getLottoNumbersTest() {
        // when
        List<LottoDto> lottoNumbers = player.getLottoNumbers();

        // then
        assertThat(lottoNumbers.size()).isEqualTo(EMPTY_SIZE);
    }

    @Test
    @DisplayName("updateResult() method 테스트")
    public void updateResultTest() {
        // when
        player.updateResult(GRADE_VALID);

        // when
        assertThat(player.getResults()).isEqualTo(result);
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
