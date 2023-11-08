package lotto.domain;

public class Count {

        int money;
        int lottoCount;

        public Count(int money) {
            this.money = money;
        }

        public void checkmoney() {
            if (money % 1000 != 0) {
                throw new IllegalArgumentException();
            }else if(money % 1000 == 0){
                this.lottoCount = money % 1000;
            }


        }
}
