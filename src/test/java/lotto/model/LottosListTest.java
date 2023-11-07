package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.List;
import lotto.controller.LottoController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosListTest {

    private LottoController controller;

    @BeforeEach
    public void setUp() {

    }

    @DisplayName("중복되지 않는 6개 번호 만들기")
    @Test
    void generateUniqueNumbers() {
        LottosList lottosList = new LottosList();
        List<Integer> list = lottosList.generateUniqueNumbers();
        HashSet<Integer> set = new HashSet<>(list);
        assertThat(list.size()).isEqualTo(set.size());
    }
}