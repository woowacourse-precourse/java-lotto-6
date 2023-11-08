package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoView {
    private static final String[] RANK_MESSAGE = {
            "3개 일치 (5,000원) - ",
            "4개 일치 (50,000원) - ",
            "5개 일치 (1,500,000원) - ",
            "5개 일치, 보너스 볼 일치 (30,000,000원) - ",
            "6개 일치 (2,000,000,000원) - "};

    public static int inputMoney() {
        while (true) {
            System.out.println("구입금액을 입력해 주세요.");
            try {
                int money = Integer.parseInt(Console.readLine());
                return money;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자를 입력해 주십시오.");
            }
        }
    }

    public static Lotto inputWinningLotto() {
        while (true) {
            System.out.println("당첨 번호를 입력해 주세요.");
            try {
                String[] sNumbers = Console.readLine().split(",");
                List<Integer> winningLottoNumber = new ArrayList<>();
                for (int i = 0; i < sNumbers.length; i++) {
                    winningLottoNumber.add(Integer.parseInt(sNumbers[i]));
                }
                return new Lotto(winningLottoNumber);
            }catch (NumberFormatException e){
                System.out.println("[ERROR] 형식에 맞춰 작성해 주십시오. ex)1,2,3,4,5,6");
            }
        }
    }

    public static int inputBonusNumber() {
        while(true) {
            System.out.println("보너스 번호를 입력해 주세요.\n");
            try {
                int bonusNum = Integer.parseInt(Console.readLine());
                if(bonusNum<1||bonusNum>45)
                    throw new IllegalArgumentException();
                return bonusNum;
            }catch (NumberFormatException e){
                System.out.println("[ERROR] 1~45사이의 숫자를 입력해 주십시오");
            }catch (IllegalArgumentException e){
                System.out.println("[ERROR] 숫자로 입력해주십시오.");
            }
        }
    }

    public static void showLottos(LottoRepository lottoRepository) {
        System.out.printf("%d개를 구매했습니다.\n", lottoRepository.getLottos().size());
        List<Lotto> lottos = lottoRepository.getLottos();
        lottos.forEach(lotto -> System.out.println(Arrays.toString(lotto.getNumbers().toArray())));
    }

    public static void showStatus(LottoRepository lottoRepository) {
        int[] ranks = lottoRepository.getRanks();
        System.out.println("당첨 통계");
        System.out.println("---");
        for (int i = 4; i >= 0; i--) {
            System.out.println(RANK_MESSAGE[4 - i] + ranks[i] + "개");
        }
        System.out.printf("총 수익률은 %.1f%%입니다.\n", lottoRepository.getProfitRate() * 100);
    }
}
