package lotto.controller;

import lotto.model.Lotto;
import lotto.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class LottoGameController {

    public void start(){
        // '구입 금액' 입력 받기
        Integer money = UserController.getMoney();
        System.out.println();

        // '표 개수' 구하기 및 출력
        int ticketNum = getTickets(money);

        // 로또 생성 n개
        List<Lotto> lottos = createLottos(ticketNum);
        // 로또 n개 출력
        printLottos(lottos);
        System.out.println();

        // '당첨 번호' 입력 받기
        List<Integer> winningNumbers = UserController.getWinningNumbers();
        System.out.println();

        // '보너스 번호' 입력 받기
        int bonusNumber = UserController.getBonusNumber(winningNumbers);
        System.out.println();

        // 로또 맞추기 및 결과
        LottoController.guessLottos(lottos, money, ticketNum, winningNumbers, bonusNumber);
    }

    public int getTickets(Integer money) {
        int tickets = money / 1000;
        System.out.println(tickets + "개를 구매했습니다.");
        return tickets;
    }

    private static void printLottos(List<Lotto> lottos) {
        for(Lotto lotto : lottos){
            System.out.println(lotto.getLottoNumbers());
        }
    }

    public static List<Lotto> createLottos(int ticketNum) {
        List<Lotto> lottos = new ArrayList<>();
        for(int i=0; i<ticketNum; i++){
            List<Integer> randomNumbers = LottoGenerator.getRandomNumbers();
            Lotto lotto = new Lotto(randomNumbers);
            lottos.add(lotto);
        }

        return lottos;
    }
}
