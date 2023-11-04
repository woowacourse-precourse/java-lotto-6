package component.output;

import component.Component;

public final class ErrorMessageComponent implements Component {
    private final String errorMessage;

    public ErrorMessageComponent(final String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String render() {
        return "[ERROR]: " + errorMessage;
    }
}
