package lotto;

public enum LottoGrade {

    zero("꽝","0",0),
    seventh("7등","0",1),
    sixth("6등","0",2),
    fifth("5등", "5,000", 3),
    forth("4등", "50,000", 4),
    third("3등", "1,500,000", 5),
    second("2등", "30,000,000", 5),
    first("1등", "2,000,000,000", 6);

    LottoGrade(String name, String price, int grade) {
        this.name = name;
        this.price = price;
        this.correct = grade;
    }

    public String getName() {
        return name;
    }

    public int getCorrect() {
        return correct;
    }

    public String getPrice() {
        return price;
    }
    private final String name;
    private final String price;
    private final int correct;

}
