package lotto;

import java.util.Arrays;
import java.util.Optional;

public enum MatchNumber {
        three("5,000",5000,3),
        four("50,000",50000,4),
        five("1,500,000",1500000,5),
        fiveAndBonus("30,000,000",30000000,6),
        six("2,000,000,000",2000000000,7),
        missingno("값 없음",0,0);
        private final String name;
        private final int value;
        private final int count;

        MatchNumber(String name, int value, int count){
            this.name = name;
            this.value = value;
            this.count = count;
        }
        public String getName(){
            return name;
        }

        public int getValue(){
            return value;
        }

        public int getCount(){
            return count;
        }

        public static MatchNumber getMatchNumber(int count){
            return Arrays.stream(MatchNumber.values())
                    .filter(x -> x.count == count)
                    .findAny()
                    .orElse(missingno);
        }
}
