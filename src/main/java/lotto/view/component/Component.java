package lotto.view.component;

import io.output.Writer;

/**
 * React의 Component에서 영감을 받아 매우 간단한 구조이지만, 각 메세지를 Component 단위로 나누어 보았습니다.
 * <p>
 * 여러 개의 Component가 합쳐져서 하나의 View가 되며, Composer가 다수의 Component를 하나의 문자열로 합쳐줍니다.
 */
public interface Component {
    String render();

    default void renderTo(Writer writer) {
        writer.write(render());
    }

}
