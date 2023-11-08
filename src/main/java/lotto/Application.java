package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Player player = new Player();
        Integer consumeMoney = 0;
        try {
            consumeMoney = player.payTicketPrice();
        } catch (IllegalArgumentException e){
            e.printStackTrace();
        }


        int myTicketCount = player.getMyTicketCount();
        player.printMyTicketCount();

        List<Lotto> lottos = new ArrayList<Lotto>();
        for (int index = 0; index < myTicketCount; index++){
            Random random = new Random();
            List<Integer> lottoNumbers = random.generateLottoNumbers();
            Lotto lotto = null;
            try {
                lotto = new Lotto(lottoNumbers);
            }catch (IllegalArgumentException e){
                e.printStackTrace();
            }

            lottos.add(lotto);
        }

        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }

        Picker picker = new Picker();
        List<Integer> winNumbers = null;
        try {
            winNumbers = picker.generateWinNumbers();
        } catch (IllegalArgumentException e){
            e.printStackTrace();
        }

        Integer winBonusNumber = 0;
        try {
            winBonusNumber = picker.generateWinBonusNumber();
        }catch(IllegalArgumentException e){
            e.printStackTrace();
        }


        for (Lotto lotto : lottos) {
            lotto.compareWinNumbers(winNumbers);
            lotto.compareWinBonusNumber(winBonusNumber);
        }

        Board board = new Board(lottos);

        board.calculateMatch();
        board.calculateIncome();
        board.calculateIncomeRate(consumeMoney);
        board.printBoard();

    }
}
