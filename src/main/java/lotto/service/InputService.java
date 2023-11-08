package lotto.service;

public class InputService {
    public String price;
    public String answer;
    public String bonusNum;

    public void readPrice(String input) {
        price=input;
    }

    public void readAnswer(String input) {
        answer=input;
    }

    public void readBonusNum(String input) {
        bonusNum=input;
    }
}
