package lotto.context.container.implementation.annotationConfig;

import lotto.context.beanFactory.SimpleBeanFactoryProxy;
import lotto.context.exception.UndefinedBeanConfigurationException;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class AnnotationConfigApplicationContainerTest {
    private static final String TEST_BASE_PACKAGE = "lotto.context";

    // 테스트를 위해 빈 생성을 지연합니다.
    private final AnnotationConfigApplicationContainer container =
            new AnnotationConfigApplicationContainerProxy(
                    new SimpleBeanFactoryProxy(), LoadingStrategy.LAZY, TEST_BASE_PACKAGE
            );

    @Test
    @DisplayName("getBeanCount()")
    @Disabled("테스트 생략")
    void getBeanCount() {
    }

    static Stream<Arguments> getBeanTestCases() {
        return Stream.of(
                Arguments.of("정상적으로 검색된 빈을 반환합니다.", "mockDependencyBean", null),
                Arguments.of("등록되지 않은 빈 검색 시 구성 파일에서 빈을 찾아 생성하고 반환합니다.", "mockBean", null),
                Arguments.of("설정 클래스에도 등록되지 않은 빈 검색 시 예외가 발생합니다.", "undefinedBean", UndefinedBeanConfigurationException.class)
        );
    }

    @ParameterizedTest(name = "[{index}] {0}")
    @DisplayName("getBean()")
    @MethodSource("getBeanTestCases")
    void getBean(
            String testCaseName,
            String beanName,
            Class<?> expectedException
    ) {
        // given
        container.getBean("mockDependencyBean");

        // when

        // then
        if (expectedException == null) {
            assertNotNull(container.getBean(beanName));
            return;
        }
        assertThatThrownBy(() -> container.getBean(beanName)).isInstanceOf(expectedException);
    }

    @Test
    @Disabled("테스트 생략")
    @DisplayName("getBean() by class")
    void getBeanByClass() {
    }

    @Test
    @Disabled("테스트 생략")
    @DisplayName("remove()")
    void remove() {
    }
}