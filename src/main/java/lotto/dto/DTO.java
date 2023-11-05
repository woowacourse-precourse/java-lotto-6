package lotto.dto;

public abstract class DTO {
    private DTO() {
    }

    public abstract static class Input extends DTO {
    }

    public abstract static class Output extends DTO {
    }
}
