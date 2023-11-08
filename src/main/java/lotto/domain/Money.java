package lotto.domain;

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
        public void minusCount(){
            --count;
        }
        public boolean checkCount(){
            if(count == 0){
                return false;
            }
            return true;
        }

}
