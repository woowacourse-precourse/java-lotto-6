package user;

import java.util.Arrays;

public class User {
    private int lottoTicketPrice;
    private int bonusNumber;
    private int[] winningLottoNumber;
    private static final int DIVISION_NUM_FOR_TICKET = 1000;

    public User(int lottoTicketPrice, int bonusNumber, int[] winningLottoNumber) {
        this.lottoTicketPrice = lottoTicketPrice;
        this.bonusNumber = bonusNumber;
        this.winningLottoNumber = winningLottoNumber;
    }

    public void setLottoTicketPrice(int lottoTicketPrice) {
        this.lottoTicketPrice = lottoTicketPrice;
    }
    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }
    public void setWinningNumbers(int[] winningLottoNumber) {
        this.winningLottoNumber = winningLottoNumber;
    }

    public int inputLottoTicketPrice() {
        return this.lottoTicketPrice / DIVISION_NUM_FOR_TICKET;
    }

    public int getInputBonusNumber() {
        return this.bonusNumber;
    }

    public int[] getInputWinningLottoNumber() {
        return this.winningLottoNumber;
    }
}
