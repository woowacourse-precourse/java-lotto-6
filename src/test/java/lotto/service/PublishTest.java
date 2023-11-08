package lotto.service;

import java.util.List;
import lotto.config.AppConfig;
import lotto.service.Publish;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PublishTest {
    Publish publish;

    @BeforeEach
    void beforeEach() {
        publish = new AppConfig().publish();
    }

    @Test
    void 번호생성테스트() {
        //when
        List<Integer> result = publish.makeNumbers();
        //then
        Assertions.assertThat(result.size()).isEqualTo(6);
    }
}