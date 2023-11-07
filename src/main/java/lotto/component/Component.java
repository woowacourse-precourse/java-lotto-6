package lotto.component;

public interface Component {

    void render();

    default boolean execute() {
        try {
            this.render();
            return true;
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println("[ERROR]" + illegalArgumentException.getMessage());
            return false;
        }
    }
}
