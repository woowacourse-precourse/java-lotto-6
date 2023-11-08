package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        try {
            lottoGame();
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

    }
    private static void lottoGame(){

        PlayLotto playLotto = new PlayLotto();

        //[입력] 구입 금액
        playLotto.typeAmount();

        //[출력] 구매 금액에 맞는 로또 수량
        // & 로또 수량 만큼의 로또 번호 (오름차순)
        playLotto.buyLottos();
        playLotto.printLottoNumbers();

        //[입력] 당첨 번호&보너스 번호
        playLotto.typeWinningNumbers();
        playLotto.typeBonusNumber();

        //[출력] 당첨 내역&수익률
        playLotto.printResult();
        playLotto.printRateOfReturn();


    }
}
