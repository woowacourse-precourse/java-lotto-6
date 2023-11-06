package lotto.component;

import lotto.event.EventListener;
import lotto.ui.OutputView;

public record WinningStatisticsComponent(OutputView outputView, EventListener eventListener) implements Component {
    @Override
    public void render() {

    }
}
