package component;

/**
 * Composer는 여러 개의 Component를 하나의 String으로 렌더링합니다.
 */
public final class Composer {

    /**
     * variadic arguments로 여러 Component를 받아서 각각 렌더링 한 결과를 하나의 String으로 합쳐줍니다.
     */
    public String renderAll(final Component... components) {
        final StringBuilder sb = new StringBuilder();
        for (final Component component : components) {
            sb.append(component.render());
        }
        return sb.toString();
    }
}
