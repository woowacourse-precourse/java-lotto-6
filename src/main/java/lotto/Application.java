package lotto;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Player player = new Player();
        player.payTicketPrice();
        int myTicketCount = player.getMyTicketCount();
        player.printMyTicketCount();

        List<Lotto> lottos = new ArrayList<Lotto>();
        for (int index = 0; index < myTicketCount; index++){
            Random random = new Random();
            List<Integer> lottoNumbers = random.generateLottoNumbers();

            Lotto lotto = new Lotto(lottoNumbers);
            lottos.add(lotto);
        }

        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }

        Picker picker = new Picker();
        List<Integer> winNumbers = picker.generateWinNumbers();
        int winBonusNumber = picker.generateWinBonusNumber();


    }
}
