package output;


import constant.ProfitType;
import java.util.LinkedHashMap;
import java.util.List;

public class LottoResult {
    public static LinkedHashMap<String, Integer> countResultLotto(List<List<Integer>> lottos, List<Integer> winningNumbers) {
            // 마지막 인덱스에서 보너스 숫자 추출
            int bonusNumber = winningNumbers.get(winningNumbers.size() - 1);
            // 보너스 숫자를 제외한 나머지 당첨 번호
            List<Integer> mainWinningNumbers = winningNumbers.subList(0, winningNumbers.size() - 1);

            // 당첨 결과를 저장할 HashMap
            LinkedHashMap<String, Integer> matchCounts = new LinkedHashMap<>();
            for(ProfitType profitType : ProfitType.getProfitTypes()) {
                matchCounts.put(profitType.getMatch(), 0);
            }

            for (List<Integer> lotto : lottos) {
                // 로또와 당첨 번호와의 교집합 개수 계산
                int matchCount = (int) lotto.stream().filter(mainWinningNumbers::contains).count();

                // 보너스 번호 일치 여부 확인
                boolean bonusMatch = lotto.contains(bonusNumber);

                // 결과 업데이트
                if(bonusMatch && matchCount == 5) {
                    matchCounts.put(ProfitType.five.getMatch(), matchCounts.get(ProfitType.five.getMatch()) + 1);
                }

                if(matchCount != 5) {
                    for(ProfitType profitType : ProfitType.getProfitTypes()) {
                        if(profitType.getCount() == matchCount) {
                            matchCounts.put(profitType.getMatch(), matchCounts.get(profitType.getMatch()) + 1);
                        }
                    }
                }

            }

            return matchCounts;
        }

    }
