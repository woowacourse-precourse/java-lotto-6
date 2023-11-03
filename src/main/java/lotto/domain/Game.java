package lotto.domain;

import lotto.utils.Reader;

import java.util.Arrays;
import java.util.List;

public class Game {
    private Player player;
    private WinningLotto winningLotto;

    public void joinPlayer() {
        player = new Player(inputMoney());
        player.issueLotto();
        System.out.println(player.issuedLottos());
    }

    public void drawWinningLotto() {
        winningLotto = new WinningLotto(inputWinningNumbers(), inputBonusNumber());
    }

    public void findResult() {
        player.findResults(winningLotto);
        player.findTotalPrize();
        System.out.println(player.lottoResults());
    }

    private int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Reader.readLine().strip();
        return Integer.parseInt(input);
    }

    private List<Integer> inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Reader.readLine();

        List<Integer> winningNumbers = Arrays.stream(input.split(",", -1))
                .map(String::strip)
                .map(Integer::parseInt)
                .toList();

        return winningNumbers;
    }

    private int inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Reader.readLine().strip();
        return Integer.parseInt(input);
    }
}
