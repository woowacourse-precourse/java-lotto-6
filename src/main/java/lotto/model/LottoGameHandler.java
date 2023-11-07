package lotto.model;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGameHandler {

    //로또 발행기능
    public void createLotto() {

    }

    //당첨로또 발행기능
    public WinningTicket createWinningTicket(List<Integer> winningNum, int bonumNum) {
        return new WinningTicket(winningNum, bonumNum);

    }

    //당첨통계 계산기능
    public void checkWinningResult() {

    }

    //우승상금 수익률 계산하는 기능
    public void calculatePrizes() {

    }

    //로또를 구매하는 기능
    public void purchaseLotto() {

    }

}
