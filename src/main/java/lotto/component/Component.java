package lotto.component;

public interface Component {

    void render();

    default ComponentRenderResult execute() {
        try {

            this.render();
            return ComponentRenderResult.createSuccess();
        } catch (IllegalArgumentException illegalArgumentException) {
            return ComponentRenderResult.createFail(illegalArgumentException.getMessage());
        }
    }


    record ComponentRenderResult(boolean isComplete, String errorMessage) {

        public static ComponentRenderResult createSuccess() {
            return new ComponentRenderResult(true, "");
        }

        public static ComponentRenderResult createFail(String message) {
            return new ComponentRenderResult(false, message);
        }

        public boolean isContinue() {
            return !isComplete;
        }

    }
}
