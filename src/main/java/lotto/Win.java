package lotto;

public enum Win {
        ONE(6, 2000000000, "6개 일치 (2,000,000,000원) - ") ,
        TWO(5, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
        THREE(5, 1500000, "5개 일치 (1,500,000원) - "),
        FOUR(4, 50000, "4개 일치 (50,000원) - "),
        FIVE(3, 5000, "3개 일치 (5,000원) -");

        final private int count;
        final private int prize;
        final private String str;
        public int getCount(){
            return count;
        }
        public int getPrize(){
            return prize;
        }
        public String getStr(){
            return str;
        }
        Win(int count, int prize, String str){
            this.count = count;
            this.prize = prize;
            this.str = str;
        }
}
