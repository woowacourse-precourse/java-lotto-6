package lotto.ui;

import java.util.List;
import java.util.stream.Stream;
import lotto.component.Component;
import lotto.component.Component.ComponentRenderResult;
import lotto.component.InitializeLottoStoreComponent;
import lotto.component.PurchaseLottoComponent;
import lotto.component.RegisterAnswerNumberComponent;
import lotto.component.RegisterBonusNumberComponent;
import lotto.component.WinningStatisticsComponent;
import lotto.event.EventListener;

public class MainComponents {
    private final List<Component> components;
    private final OutputView outputView;


    public MainComponents(InputView inputView, OutputView outputView, EventListener eventListener) {
        this.outputView = outputView;
        this.components = List.of(
                new InitializeLottoStoreComponent(eventListener),
                new PurchaseLottoComponent(inputView, outputView, eventListener),
                new RegisterAnswerNumberComponent(inputView, eventListener),
                new RegisterBonusNumberComponent(inputView, eventListener),
                new WinningStatisticsComponent(outputView, eventListener)
        );
    }

    public void renderAll() {
        components.forEach(component -> Stream.generate(component::execute)
                .takeWhile(ComponentRenderResult::isContinue)
                .forEach(renderResult -> outputView.printError(renderResult.errorMessage())));
    }
}
