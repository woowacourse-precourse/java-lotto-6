package lotto.domain;

import java.util.Map;
import lotto.Message.GameMessage;
import lotto.util.MoneyCalculation;

public class Money {

        int money;
        int count;

        public Money(int money) {
            this.money = money;
        }

        public void checkmoney() {
            if (money % 1000 != 0) {
                throw new IllegalArgumentException();
            }else if(money % 1000 == 0){
                this.count = money % 1000;
            }
        }
        public void printCount(){
            System.out.printf(count + GameMessage.OUT_QUNTITY_LOTTO_MESSAGE);
        }

        public void minusCount(){
            --count;
        }

        public boolean checkCount(){
            if(count == 0){
                return false;
            }
            return true;
        }

        public float calculateProfit(Map<Integer, Integer> resultLottos){
            long percentage = MoneyCalculation.calculateResult(resultLottos) / money;
            return percentage;
        }

}
