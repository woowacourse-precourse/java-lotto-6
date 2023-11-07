package lotto;

import lotto.service.domain.lotto.CreateAutoLottoNumber;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CreateAutoLottoNumberServiceTest {

    private CreateAutoLottoNumber cal = new CreateAutoLottoNumber();
    @Test
    public void LottoOneSeason(){
        List<Integer> lottoNumbers = cal.getLottoSixNumbers();
        int bonusNumber = cal.getBonusNumber();
        System.out.println(lottoNumbers);
        System.out.println(bonusNumber);
    }
    @Test
    public void LottoTwoSeason(){
        List<Integer> lottoNumbers = cal.getLottoSixNumbers();
        int bonusNumber = cal.getBonusNumber();
        System.out.println(lottoNumbers);
        System.out.println(bonusNumber);
    }
    @Test
    public void LottoThreeSeason(){
        List<Integer> lottoNumbers = cal.getLottoSixNumbers();
        int bonusNumber = cal.getBonusNumber();
        System.out.println(lottoNumbers);
        System.out.println(bonusNumber);
    }
    @Test
    public void LottoBuyTest(){
        int buyPickNumber = 8;
        int buyMoney = buyPickNumber * 1000;
        for(int i = 1; i <= buyPickNumber; i++){
            List<Integer> lottoNumbers = cal.getLottoSixNumbers();
            System.out.println("---- " + i +" 회차 구매");
            System.out.println("투입 금액 : " + buyMoney);
            System.out.println(lottoNumbers);
            System.out.println("남은 잔액 : " + (buyMoney -= 1000));
            if(buyMoney == 0){
                System.out.println("-----------");
                System.out.println("모든 게임이 종료");
                System.out.println("-----------");
            }
        }
    }
}
