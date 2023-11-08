package lotto.view.component;

/**
 * 여러 Component를 조합하여 새로운 Component를 만들 때 사용합니다.
 */
public interface Composable {
    Component compose(Component component);
}
