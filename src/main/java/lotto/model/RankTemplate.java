package lotto.model;

public enum RankTemplate {
    FIRST("6개 일치"),
    SECOND("5개 일치, 보너스 볼 일치"),
    THIRD("5개 일치"),
    FOURTH("4개 일치"),
    FIFTH("3개 일치"),
    EMPTY("없음");
    private final String template;

    RankTemplate(String template) {
        this.template = template;
    }

    public String getTemplate() {
        return template;
    }
}
