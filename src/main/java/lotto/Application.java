package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        OutputGuideMessage outputGuideMessage = new OutputGuideMessage();
        OutputError outputError = new OutputError();
        Amount amount = new Amount();
        int playerAmount;
        int count;

        List<Lotto> playerlottos;

        //구입 금액 입력 받기
        InputGuideMessage.enterAmountMessage();
        count = amount.getCount();
        playerAmount = amount.getAmount();

        //금액에 따른 로또 번호 발행
        Player player = new Player();
        playerlottos = player.getPlayerlotto(count);

        //당첨 번호 입력 받기
        WinningLotto getwinningLotto = new WinningLotto();
        Lotto winningLotto = getwinningLotto.getWinningLottoNumbers();

        //보너스 번호 입력 받기
        int bonusNumber = getwinningLotto.setBonusNumber();

        Compare compare = new Compare();
        compare.compareResult(playerlottos,winningLotto,bonusNumber,playerAmount);

    }
}
