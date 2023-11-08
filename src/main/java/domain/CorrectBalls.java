package domain;

public enum CorrectBalls {

    Three(3, "3개 일치 (5,000원) - %d개", 5000),
    Four(4, "4개 일치 (50,000원) - %d개", 50000),
    Five(5, "5개 일치 (1,500,000원) - %d개", 1500000),
    FiveWithBonus(7, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개", 30000000),
    Six(6, "6개 일치 (2,000,000,000원) - %d개", 2000000000);

    private final int ballCount;
    private final String sentence;
    private final int price;

    CorrectBalls(int ballCount, String sentence, int price) {
        this.ballCount = ballCount;
        this.sentence = sentence;
        this.price = price;
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getPrice() {
        return price;
    }

    public String makeSentence(int count) {
        return String.format(this.sentence, count);
    }
}
