package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import lotto.factory.ComponentFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("ComponentFactory의")
class ComponentFactoryTest {

    @Test
    @DisplayName("싱글톤인가")
    void is_singleton() {
        // given
        final ComponentFactory before = ComponentFactory.getInstance();
        final ComponentFactory after = ComponentFactory.getInstance();

        // when
        final boolean result = before.equals(after);

        // then
        assertThat(result).isTrue();
    }

}
