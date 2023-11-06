package lotto.ui;

import java.util.List;
import lotto.component.Component;
import lotto.component.InitializeLottoStoreComponent;
import lotto.component.PurchaseLottoComponent;
import lotto.event.EventListener;

public class MainComponents {
    private final List<Component> components;


    public MainComponents(InputView inputView, OutputView outputView, EventListener eventListener) {
        this.components = List.of(
                new InitializeLottoStoreComponent(eventListener),
                new PurchaseLottoComponent(inputView, outputView, eventListener)
        );
    }

    public void renderAll() {
        components.forEach(Component::render);
    }
}
