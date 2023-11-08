package lotto.view;

public class ErrorView implements View {
    private final String OUTPUT = "[ERROR] %s";
    private final String message;

    public ErrorView(String message) {
        this.message = message;
    }

    @Override
    public void render() {
        System.out.println(String.format(OUTPUT,message));
    }
}
