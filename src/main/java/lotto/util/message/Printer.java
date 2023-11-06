package lotto.util.message;

public class Printer {
    public static void printThreeHit(int threeHit){
        System.out.printf(Message.THREE_HIT + "%d"+ Message.COUNT,threeHit);
    }
    public static void printFourHit(int fourHit){
        System.out.printf(Message.FIVE_HIT + "%d"+ Message.COUNT,fourHit);
    }
    public static void printFiveHit(int fiveHit){
        System.out.printf(Message.FIVE_HIT + "%d"+ Message.COUNT,fiveHit);
    }
    public static void printFiveWithBonusHit(int fiveWithBonus){
        System.out.printf(Message.FIVE_WITH_BONUS_HIT + "%d"+ Message.COUNT,fiveWithBonus);
    }
    public static void printSixHit(int sixHit){
        System.out.printf(Message.SIX_HIT+"%d" + Message.COUNT,sixHit);
    }
    public static void printCount(int size){
        System.out.printf("%d"+Message.BOUGHT,size);
    }
    public static void printComma(){
        System.out.print(Message.COMMA);
    }
    public static void printOpen(){
        System.out.print(Message.OPEN);
    }
    public static void printClose(){
        System.out.print(Message.CLOSE);
    }
    public static void printLottoNumber(int num){
        System.out.printf("%d", num);
    }
    public static void changeLine(){
        System.out.println();
    }




}
