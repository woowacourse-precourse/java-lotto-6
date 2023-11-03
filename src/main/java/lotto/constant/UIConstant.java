package lotto.constant;

public enum UIConstant {
    ERROR_TAG("[ERROR]");
    
    private final String ui;

    UIConstant(String ui) {
        this.ui = ui;
    }

    public String getUI() {
        return ui;
    }
}
