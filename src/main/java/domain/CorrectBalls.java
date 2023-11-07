package domain;

public enum CorrectBalls {

    ThreeSameBalls("3개 일치 (5,000원) - %d개"),
    FourSameBalls("4개 일치 (50,000원) - %d개"),
    FiveSameBalls("5개 일치 (1,500,000원) - %d개"),
    FiveSameBallsWithBonus("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    SixSameBalls("6개 일치 (2,000,000,000원) - %d개");

    private final String sentence;

    CorrectBalls(String sentence) {
        this.sentence = sentence;
    }

    public String makeBallSentence(int count) {
        return String.format(this.sentence, count);
    }
}
