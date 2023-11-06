package lotto.ui;

import java.util.List;
import lotto.component.Component;
import lotto.event.EventListener;

public class MainComponents {
    private final List<Component> components;


    public MainComponents(InputView inputView, OutputView outputView, EventListener eventListener) {
        this.components = List.of();
    }

    public void renderAll() {
        components.forEach(Component::render);
    }
}
