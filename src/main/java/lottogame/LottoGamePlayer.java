package lottogame;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.Lotto;
import user.User;

public class LottoGamePlayer {
    private final User user;
    public final Lotto lotto;

    public LottoGamePlayer(User user, Lotto lotto) {
        this.user = user;
        this.lotto = lotto;
    }
    public void playLottoGame() {
        settingLottoNumber();

    }

    private void settingLottoNumber() {
        // ?? ?? ??
        String lottoTicket = Console.readLine();
        // ?? ?? ?? ??
        String[] winningNum = Console.readLine().split(",");

        // ??? ?? ??
        String bonusNum = Console.readLine();

        // ?? ??
        new User(lottoTicket, winningNum, bonusNum);

        // ?? ??? ?? (x?? ??????.) ??
        // ??? ? ??? ?? ??? ??


    }

}
