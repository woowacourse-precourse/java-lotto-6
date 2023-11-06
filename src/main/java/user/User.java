package user;

import java.util.Arrays;

public class User {
    private int lottoTicketPrice;
    private int bonusNumber;
    private int[] winningLottoNumber;
    private static final int DIVISION_NUM_FOR_TICKET = 1000;

    public User(int lottoTicketPrice, int bonusNumber, String[] winningLottoNumber) {
        this.lottoTicketPrice = lottoTicketPrice;
        this.bonusNumber = bonusNumber;
        setWinningNumbers(winningLottoNumber);
    }

    public void setLottoTicketPrice(int lottoTicketPrice) {
        this.lottoTicketPrice = lottoTicketPrice;
    }
    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }
    public void setWinningNumbers(String[] winningLottoNumber) {
        this.winningLottoNumber = Arrays.stream(winningLottoNumber)
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public int inputLottoTicketPrice() {
        return lottoTicketPrice / DIVISION_NUM_FOR_TICKET;
    }

    public int inputBonusNumber() {
        return bonusNumber;
    }

    public int[] getInputWinningLottoNumber() {
        return winningLottoNumber;
    }
}
