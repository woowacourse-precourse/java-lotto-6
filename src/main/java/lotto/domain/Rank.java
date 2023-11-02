package lotto.domain;

public enum Rank {
    FIRST("6개 번호일치 / 2,000,000,000원"),
    SECOND("6개 번호일치 / 2,000,000,000원"),
    THIRD("6개 번호일치 / 2,000,000,000원"),
    FOURTH("6개 번호일치 / 2,000,000,000원"),
    FIFTH("6개 번호일치 / 2,000,000,000원");

    private final String title;

    Rank(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}