package lotto.DTO;

public enum PrizeDTO {
    FIFTH(5000),FORTH(50000),THIRD(1500000),SECOND(30000000),FIRST(2000000000);

    private int prize;

    PrizeDTO(int prize){
        this.prize = prize;
    }

    public int getPrize(){
        return prize;
    }
}


    // private enum price {
    //     FIFTH(5000),FORTH(50000),THIRD(1500000),SECOND(30000000),FIRST(2000000000);

    //     private int winnings;

    //     price(int winnings){
    //         this.winnings = winnings;
    //     }

    //     public int getPrice(){
    //         return winnings;
    //     }
    // }