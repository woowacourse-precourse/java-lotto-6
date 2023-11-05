package user;

public class User {
    //?? ??? ??????, ??? ??? ??? ?? ???

    private final int lottoTicketPrice;
    private final int bonusNumber;
    private final String[] winningLottoNumber;

    public User(int lottoTicketPrice, int bonusNumber, String[] winningLottoNumber) {
        this.lottoTicketPrice = lottoTicketPrice;
        this.bonusNumber = bonusNumber;
        this.winningLottoNumber = winningLottoNumber;
    }
    public int inputLottoTicketPrice() {
        return lottoTicketPrice / 1000;
    }
    public int inputBonusNumber() {
        return bonusNumber;
    }
    public String[] getInputWinningLottoNumber() {
        return winningLottoNumber;
    }

}
