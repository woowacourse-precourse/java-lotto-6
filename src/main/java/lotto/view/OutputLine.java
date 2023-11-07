package lotto.view;

public enum OutputLine {

    THREE("3개 일치 (5,000원) - %d개\n"),
    FOUR("4개 일치 (50,000원) - %d개\n"),
    FIVE("5개 일치 (1,500,000원) - %d개\n"),
    FIVE_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n"),
    SIX("6개 일치 (2,000,000,000원) - %d개\n");

    private final String correct;

    OutputLine(String correct) {
        this.correct = correct;
    }

    public String getCorrect() {
        return correct;
    }

}
