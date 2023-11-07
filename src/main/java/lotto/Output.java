package lotto;
import java.util.List;
import java.util.ArrayList;

public class Output {

        /**
         * 랜덤으로 생성된 로또 번호를 출력합니다.
         * @param userNumbers
         */
        public static void lottoInfoPrint( List<List<Integer>> userNumbers) {
                StringBuilder sb = new StringBuilder();
                sb.append(userNumbers.size() +"개를 구매했습니다. \n");
                for (List<Integer> numberInfos : userNumbers) {
                        sb.append("[");
                        sb.append(numberInfos.get(0));
                        for (int i = 1; i < numberInfos.size(); i++) {
                            sb.append(", " + numberInfos.get(i));
                        }

                        sb.append("]" + "\n");
                }

                System.out.println(sb);
        }
        
        /**
         * 당첨 통계를 출력합니다. 
         * 정보는 LottoResult의 enum 형태로 저장되어 있습니다.
         * @param lottoResults
         */
        public static void resultPrint(ArrayList<LottoResult> lottoResults) {
                LottoResult[] allLottoResults = LottoResult.values();

                System.out.println("당첨 통계\n" +  "---");

                for (int i = 3; i < allLottoResults.length; i++) {
                        isMatch(allLottoResults[i], lottoResults);
                }
        }


        /**
         * 구매 비용에 비해 수익률이 얼마나 되는지 테스트 합니다.
         * @param lottoResults 로또 결과를 가지고 있는 List입니다. 
         * @param priceAmount 구매한 로또의 가격의 총량입니다.
         * @return 몇프로의 수익을 냈는지를 return 합니다.
         * 
         */
        public static double calculateLottoEarnings(ArrayList<LottoResult> lottoResults, double priceAmount) {
            int totalPrice = 0;
            double benefit = 0;
            for (LottoResult lottoResult : lottoResults) {
                    totalPrice += lottoResult.getPrice();
            }

            if (totalPrice != 0) 
                    benefit = Math.round(totalPrice / priceAmount * 1000) / 10.0;

            System.out.println("총 수익률은 " + benefit + "%입니다.");

            return benefit;
        }


        /**
         * 로또 결과를 받아 각 enum형과 비교후 몇개를 맞추었는지 출력합니다.
         * @param selectedResult 비교할 enum 형 입니다.
         * @param lottoResults 사용자가 랜덤으로 생성한 로또 번호입니다.
         */
        private static void isMatch(LottoResult selectedResult, ArrayList<LottoResult> lottoResults) {
                int matchCount = 0;

                for (LottoResult lottoResult : lottoResults) {
                        if (lottoResult == selectedResult) {
                            matchCount++;
                        }
                }

                if (selectedResult.getBonusMatch()) {
                        System.out.println(selectedResult.getMatch() + "개 일치, 보너스 볼 일치 (" + selectedResult.getStringPrize() + "원) - " + matchCount + "개");
                        return;
                }

                System.out.println(selectedResult.getMatch() + "개 일치 (" + selectedResult.getStringPrize() + "원) - " + matchCount +"개");
        }

}

