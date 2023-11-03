package lotto.ui;

public class Writer {

    private Writer(){}

    /**
     * 사용자에게 가이드 메시지를 출력한 뒤 개행을 출력해 줍니다.
     * @param guide
     */
    static void printGuide(String guide){
        System.out.println(guide);
        System.out.println();
    }
}
