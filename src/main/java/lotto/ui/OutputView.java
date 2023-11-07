package lotto.ui;

public class OutputView {
    public static final String LOTTO_COUNT_MESSAGE = "개를 구매했습니다.";
    public static void outputLottoList(int count,String lottoNumbers){
        System.out.println(count+LOTTO_COUNT_MESSAGE);
        System.out.println(lottoNumbers);
    }

    public static void outputLottoResult(String lottoResult){
        System.out.println(lottoResult);
    }


}
