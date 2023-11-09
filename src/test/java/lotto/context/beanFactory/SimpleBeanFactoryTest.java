package lotto.context.beanFactory;

import lotto.context.beans.MockDependencyBean;
import lotto.context.beans.MockBean;
import lotto.context.exception.AlreadyExistBeanException;
import lotto.context.exception.NoSuchBeanException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.function.Supplier;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class SimpleBeanFactoryTest {
    private static final String MOCK_BEAN_NAME1 = "mockDependencyBean";
    private static final String MOCK_BEAN_NAME2 = "mockBean";

    private final SimpleBeanFactory factory = new SimpleBeanFactoryProxy();

    @Test
    @DisplayName("getBeanCount() : 빈을 1개 등록했을 때 등록된 빈의 수는 1개가 나와야합니다.")
    void getBeanCount() {
        // given
        factory.registerBean(MOCK_BEAN_NAME1, MockDependencyBean::new);

        //when

        // then
        assertThat(factory.getBeanCount()).isEqualTo(1);

    }

    static Stream<Arguments> containsTestCases() {
        return Stream.of(
                Arguments.of("해당 이름의 빈이 존재하면 true 를 반환합니다.", MOCK_BEAN_NAME1, true),
                Arguments.of("해당 이름의 빈이 존재하지 않으면 false 를 반환합니다.", "nonExistBean", false)
        );
    }

    @ParameterizedTest(name = "[{index}] {0}")
    @DisplayName("contains()")
    @MethodSource("containsTestCases")
    void contains(
            String testCaseName,
            String beanName,
            boolean result
    ) {
        // given
        factory.registerBean(MOCK_BEAN_NAME1, MockDependencyBean::new);

        // when

        // then
        assertThat(factory.contains(beanName)).isEqualTo(result);

    }

    static Stream<Arguments> getBeanTestCases() {
        return Stream.of(
                Arguments.of("등록된 이름의 빈이 존재하면 해당 빈을 반환합니다.", MOCK_BEAN_NAME1, null),
                Arguments.of("등록된 이름의 빈이 없으면 예외가 발생합니다.", "nonExistBean", NoSuchBeanException.class)
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
        factory.registerBean(MOCK_BEAN_NAME1, MockDependencyBean::new);

        // when

        // then
        if (expectedException != null) {
            assertThatThrownBy(() -> factory.getBean(beanName))
                    .isInstanceOf(expectedException);
            return;
        }
        assertNotNull(factory.getBean(beanName));

    }

    static Stream<Arguments> registerBeanTestCases() {
        return Stream.of(
                Arguments.of(
                        "정상적으로 빈이 등록되면 예외가 발생하지 않습니다.",
                        MOCK_BEAN_NAME2,
                        (Supplier<MockBean>) () -> new MockBean(new MockDependencyBean())
                        , null
                ),
                Arguments.of(
                        "이미 존재하는 빈의 이름을 등록하려하면 예외가 발생합니다",
                        MOCK_BEAN_NAME1,
                        (Supplier<MockDependencyBean>) MockDependencyBean::new,
                        AlreadyExistBeanException.class)
        );
    }

    @ParameterizedTest(name = "[{index}] {0}")
    @DisplayName("registerBean()")
    @MethodSource("registerBeanTestCases")
    void registerBean(
            String testCaseName,
            String beanName,
            Supplier<?> supplier,
            Class<?> expectedException
    ) {
        // given
        factory.registerBean(MOCK_BEAN_NAME1, MockDependencyBean::new);

        // when
        if (expectedException == null) {
            factory.registerBean(beanName, supplier);
        }

        // then
        if (expectedException != null) {
            assertThatThrownBy(() -> factory.registerBean(beanName, supplier));
            return;
        }
        assertTrue(factory.contains(beanName));
    }

    static Stream<Arguments> removeTestCases() {
        return Stream.of(
                Arguments.of("등록된 빈을 정상적으로 제거합니다.", MOCK_BEAN_NAME1, null),
                Arguments.of("등록되지 않은 빈을 제거하려하면 예외가 발생합니다.", "nonExistBean", NoSuchBeanException.class)
        );
    }

    @ParameterizedTest(name = "[{index}] {0}")
    @DisplayName("remove()")
    @MethodSource("removeTestCases")
    void remove(
            String testCaseName,
            String beanName,
            Class<?> expectedException
    ) {
        // given
        factory.registerBean(MOCK_BEAN_NAME1, MockDependencyBean::new);

        // when
        if (expectedException == null) {
            factory.remove(beanName);
        }

        // then
        if (expectedException != null) {
            assertThatThrownBy(() -> factory.remove(beanName))
                    .isInstanceOf(expectedException);
            return;
        }

        assertFalse(factory.contains(beanName));

    }
}