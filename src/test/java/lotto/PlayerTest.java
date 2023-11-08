package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.assertThat;
public class PlayerTest {
    @DisplayName("플레이어는 받은 개수만큼 로또를 만든다.")
    @ParameterizedTest
    @ValueSource(ints = {5,6,7,8,9,10})
    void makeLotto(int lottoNumberCount){
        Player player = new Player(lottoNumberCount);
        assertThat(player.getLottoSize()).isEqualTo(lottoNumberCount);
    }
}
