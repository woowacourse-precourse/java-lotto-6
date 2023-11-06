package lotto.context.container.implementation.annotationConfig.annotation.configuration;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ConfigurationScannerTest {

    @Test
    @DisplayName("테스트 디렉토리 내에는 1개의 클래스에만 @Configuration 이 적용되어 있습니다.")
    void scan() {
        // given
        String basePackage = "lotto.context";

        // when
        List<Class<?>> result = ConfigurationScanner.scan(basePackage);

        // then
        assertThat(result.size()).isEqualTo(1);
    }
}