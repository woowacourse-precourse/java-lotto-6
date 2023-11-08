package lotto;

public class Application {
    public static void main(String[] args) {
        // 로또 상점 생성
        LottoShop lottoShop = new LottoShop();
       
        LottoResult lottoResult = new LottoResult(lottoShop);
        lottoResult.getResult();  // 결과를 계산합니다.
 
        // 결과 출력
        lottoResult.printResult();
    }
}
