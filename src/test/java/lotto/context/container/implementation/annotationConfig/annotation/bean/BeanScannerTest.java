package lotto.context.container.implementation.annotationConfig.annotation.bean;

import lotto.context.container.implementation.annotationConfig.annotation.config.TestConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BeanScannerTest {
    @Test
    @DisplayName("테스트용 클래스에는 3개 중 2개의 메서드에 @Bean 이 적용되어 있습니다.")
    void scan() {
        // given
        Class<?> clazz = TestConfig.class;

        // when
        List<Method> result = BeanScanner.scan(clazz);

        // then
        assertThat(result.size()).isEqualTo(2);
    }
}