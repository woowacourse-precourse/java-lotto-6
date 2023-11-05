package Model;

public class LottoModel {

    public int getPayment() {
        return payment;
    }

    public int getCountOfLotto() {
        return countOfLotto;
    }

    public void setCountOfLotto(int countOfLotto) {
        this.countOfLotto = countOfLotto;
    }

    private int payment;
    private int countOfLotto;

    public void setPayment(int payment) {
        this.payment = payment;
        this.countOfLotto = calculateCountOfLotto();
    }

    private int calculateCountOfLotto() {
        return payment / 1000;
    }


}
