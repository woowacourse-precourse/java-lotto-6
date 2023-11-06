package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoView {
    private static final String[] RANK_MESSAGE={
            "3개 일치 (5,000원) - ",
            "4개 일치 (50,000원) - ",
            "5개 일치 (1,500,000원) - ",
            "5개 일치, 보너스 볼 일치 (30,000,000원) - ",
            "6개 일치 (2,000,000,000원) - "};
    public int inputMoney(){
        System.out.println("구입금액을 입력해 주세요.");
        int money = Integer.parseInt(Console.readLine());
        return money;
    }
    public Lotto inputWinningLotto(){
        System.out.println("당첨 번호를 입력해 주세요.");
        String[] sNumbers = Console.readLine().split(",");
        List<Integer> winningLottoNumber=new ArrayList<>();
        for(int i=0;i<sNumbers.length;i++){
            winningLottoNumber.add(Integer.parseInt(sNumbers[i]));
        }
        return new Lotto(winningLottoNumber);
    }
    public int inputBonusNumber(){
        System.out.println("보너스 번호를 입력해 주세요.\n");
        return Integer.parseInt(Console.readLine());
    }
    public void showLottos(LottoRepository lottoRepository){
        List<Lotto> lottos = lottoRepository.getLottos();
        lottos.forEach(lotto->System.out.println(Arrays.toString(lotto.getNumbers().toArray())));
    }
    public void showStatus(LottoRepository lottoRepository){
        int[] ranks = lottoRepository.getRanks();
        System.out.println("당첨 통계");
        System.out.println("---");
        for(int i=4;i<=0;i--){
            System.out.println(RANK_MESSAGE[i]+ranks[i]+"개");
        }
        System.out.printf("총 수익률은 %f%%입니다.\n",lottoRepository.getProfitRate()*100);
    }
}
