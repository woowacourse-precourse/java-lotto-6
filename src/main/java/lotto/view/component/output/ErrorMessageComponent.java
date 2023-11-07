package lotto.view.component.output;

import lotto.view.component.Component;

public final class ErrorMessageComponent implements Component {
    private final String errorMessage;

    public ErrorMessageComponent(final String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String render() {
        return "\n[ERROR] " + errorMessage;
    }
}
