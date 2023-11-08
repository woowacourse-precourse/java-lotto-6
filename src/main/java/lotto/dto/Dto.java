package lotto.dto;

import static lotto.Error.View.CAN_NOT_OVERRIDE;

public abstract class Dto {
    private Dto() {
    }

    public abstract static class Input extends Dto {
    }

    public abstract static class Output extends Dto {
    }

    protected void validateOverride(Object object) {
        if (object != null) {
            throw new IllegalArgumentException(CAN_NOT_OVERRIDE.getText());
        }
    }
}
