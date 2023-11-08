package lotto.repository;

import lotto.entity.LottoGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoGameRepositoryTest {
    private LottoGameRepository repository;

    @BeforeEach
    void setUp() {
        repository = new LottoGameRepository();
    }

    @Test
    @DisplayName("새로운 로또 게임을 저장하면, ID가 증가")
    void testSave() {

        LottoGame game = new LottoGame("3000");

        Long firstId = repository.save(game);
        Long secondId = repository.save(new LottoGame("4000"));

        assertNotNull(firstId);
        assertEquals(Long.valueOf(0L), firstId);
        assertEquals(Long.valueOf(1L), secondId);
    }

    @Test
    @DisplayName("저장된 로또 게임을 ID로  찾을 수 있어야 함")
    void testFindById() {
        LottoGame game = new LottoGame("1000");
        Long savedId = repository.save(game);

        LottoGame foundGame = repository.findById(savedId);

        assertEquals(game, foundGame);
    }

    @Test
    @DisplayName("존재하지 않는 ID의 게임을 찾으려고 하면, null을 반환")
    void testFindById_NotFound() {
        LottoGame foundGame = repository.findById(999L);

        assertNull(foundGame);
    }

}