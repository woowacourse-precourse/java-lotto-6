package lotto.domain;

public record Payment (int amount){
    public Payment(int amount){
        this.amount = amount;
    }
}
