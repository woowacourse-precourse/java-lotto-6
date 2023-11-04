package component.output;

import component.Component;
import java.util.List;
import lotto.controller.dto.output.LottosBuyingResult;

public final class LottoNumbersComponent implements Component {

    private final LottosBuyingResult data;

    public LottoNumbersComponent(final LottosBuyingResult data) {
        this.data = data;
    }

    @Override
    public String render() {
        final List<String> rendered = data.lottos().stream()
                .map(LottoComponent::new)
                .map(LottoComponent::render)
                .toList();

        return String.join("\n", rendered);
    }

}
