package lotto.view;

public enum statisitcsView {
    THIRD(3,"3개 일치 (5,000원) - "),
    FOURTH(4,"4개 일치 (50,000원) - "),
    FIFTH(5,"5개 일치 (1,500,000원) - "),
    SIXTH(6,"6개 일치 (2,000,000,000원) - "),
    BONUS(7,"5개 일치, 보너스 볼 일치 (30,000,000원) - ");


    private String message;

    private int value;

    statisitcsView(int value,String message) {
        this.value = value;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
