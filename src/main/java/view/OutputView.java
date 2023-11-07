package view;

import model.Lotto;
import model.User;
import service.LottoEnum;

import java.util.List;

public class OutputView {
    public void printLottoCount(User user){
        System.out.printf("%d개를 구매했습니다.", user.getPrice()/LottoEnum.LOTTOPRICE.getMoney());
        printLottoNumbers(user.getLottoList());
    }
    public void printLottoNumbers(List<Lotto> lottoList){
        for(Lotto lotto:lottoList){
            lotto.toString();
        }
        //로또 번호 출력하기
    }
    public void printResult(User user,double rate){
        System.out.printf("당첨 통계\n");
        System.out.printf("---\n");
        System.out.printf("3개 일치 (5,000원) - %d개\n",user.getFifth());
        System.out.printf("4개 일치 (50,000원) - %d개\n",user.getFourth());
        System.out.printf("5개 일치 (1,500,000원) - %d개",user.getThird());
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개",user.getSecond());
        System.out.printf("6개 일치 (2,000,000,000원) - %d개",user.getFirst());
        System.out.printf("총 수익률은 %.1f%입니다.",rate);
    }
}
