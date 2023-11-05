package lotto.dto;

import static lotto.Error.View.CAN_NOT_OVERRIDE;

public abstract class DTO {
    private DTO() {
    }

    public abstract static class Input extends DTO {
    }

    public abstract static class Output extends DTO {
    }

    protected void validateOverride(Object object) {
        if (object != null) {
            throw new IllegalArgumentException(CAN_NOT_OVERRIDE.getText());
        }
    }
}
