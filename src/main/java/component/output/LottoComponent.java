package component.output;

import component.Component;
import java.util.stream.Collectors;
import lotto.controller.dto.output.LottoDto;

public final class LottoComponent implements Component {

    private final LottoDto data;

    public LottoComponent(final LottoDto data) {
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
