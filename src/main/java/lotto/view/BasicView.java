package lotto.view;

public class BasicView implements View {
    private String output;

    public BasicView() {
        output = "";
    }

    public BasicView(String output) {
        this.output = output;
    }

    @Override
    public void render() {
        System.out.println(output);
    }
}
