package view;

public class View {
    private String content;

    public void print() {
        System.out.println(content);
    }

    public View(String content) {
        this.content = content;
    }
}
