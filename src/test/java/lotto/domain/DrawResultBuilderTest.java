package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DrawResultBuilderTest {
    @DisplayName("올바른 당첨번호와 보너스 번호를 저장하고 빌드하면 정상적으로 DrawResult를 생성한다.")
    @Test
    void setDrawResultAndBonusThenBuild() {
        DrawResultBuilder drawResultBuilder = new DrawResultBuilder();
        drawResultBuilder.setLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        drawResultBuilder.setBonusNumber(7);
        assertThat(drawResultBuilder.build())
                .isInstanceOf(DrawResult.class);
    }

    @DisplayName("올바른 보너스 번호와 당첨번호를 저장하고 빌드하면 정상적으로 DrawResult를 생성한다..")
    @Test
    void setBonusNumber() {
        DrawResultBuilder drawResultBuilder = new DrawResultBuilder();
        drawResultBuilder.setBonusNumber(7);
        drawResultBuilder.setLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        assertThat(drawResultBuilder.build())
                .isInstanceOf(DrawResult.class);
    }

    @DisplayName("올바르지 않은 보너스번호를 저장하고 빌드하면 예외가 발생한다.")
    @Test
    void setInvalidNumbersThenBuild() {
        DrawResultBuilder drawResultBuilder = new DrawResultBuilder();
        drawResultBuilder.setLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        drawResultBuilder.setBonusNumber(1);
        assertThatThrownBy(() -> drawResultBuilder.build())
                .isInstanceOf(IllegalStateException.class);
    }

    @DisplayName("필드 값 없이 빌드하면 예외가 발생한다.")
    @Test
    void buildWithoutField() {
        DrawResultBuilder drawResultBuilder = new DrawResultBuilder();
        assertThatThrownBy(() -> drawResultBuilder.build())
                .isInstanceOf(IllegalStateException.class);
    }
}
