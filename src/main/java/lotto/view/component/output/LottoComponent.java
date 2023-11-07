package lotto.view.component.output;

import java.util.stream.Collectors;
import lotto.controller.dto.output.LottoOutput;
import lotto.view.component.Component;

public final class LottoComponent implements Component {

    private final LottoOutput data;

    public LottoComponent(final LottoOutput data) {
        this.data = data;
    }

    @Override
    public String render() {
        return String.format("[%s]",
                data.numbers()
                        .stream()
                        .map(Object::toString)
                        .collect(Collectors.joining(", ")));
    }
}
