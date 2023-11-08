package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ResultLotto {
    //매칭 개수 리스트 -> 3개,4개,5개,5+1개,6개 리스트(enum Prize List) -> 각각 몇개인지 리스트 -> 출력 및 수익률 계산
    public static List<Prize> showDetail(List<Integer> lottoNumbersPurchased, List<Integer> winningNumber, int bonusNumber){
        //당첨 내역 출력
        List<Prize> prizeList = checkRank(lottoNumbersPurchased, winningNumber, bonusNumber);
        List<Integer> categorizeRank = categorizeRank(prizeList);

        System.out.println("\n"+ "당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + categorizeRank.get(0) + "개");
        System.out.println("4개 일치 (50,000원) - " + categorizeRank.get(1) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + categorizeRank.get(2) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + categorizeRank.get(3) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + categorizeRank.get(4) + "개");

        return prizeList;
    }

    public static List<Integer> categorizeRank(List<Prize> countMatched){
        //당첨된 로또 등수 각각 몇개인지 확인
        List<Integer> categorizedRank = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0));
        for(Prize p : countMatched){
            if(p == Prize.FIFTH_PLACE){
                categorizedRank.set(0, categorizedRank.get(0) + 1);
            } else if(p == Prize.FOURTH_PLACE){
                categorizedRank.set(1, categorizedRank.get(1) + 1);
            } else if(p == Prize.THIRD_PLACE){
                categorizedRank.set(2, categorizedRank.get(2) + 1);
            } else if(p == Prize.SECOND_PLACE){
                categorizedRank.set(3, categorizedRank.get(3) + 1);
            } else if(p == Prize.FIRST_PLACE){
                categorizedRank.set(4, categorizedRank.get(4) + 1);
            }
        }

        return categorizedRank;
    }

    public static List<Prize> checkRank(List<Integer> lottoNumbersPurchased, List<Integer> winningNumber, int bonusNumber){
        //구매한 로또 번호 6개씩 나눠서 각각 등수 확인하기
        List<Integer> onePieceLotto = new ArrayList<>(); //로또 한 장 번호 담는 리스트
        List<Prize> countMatched = new ArrayList<>(); //각각 매칭 개수 리스트

        for(int i = 0; i < lottoNumbersPurchased.size(); i++){
            onePieceLotto.add(lottoNumbersPurchased.get(i));
            if(i % 6 == 5){
                int value = matchingNumber(onePieceLotto, winningNumber);
                if(value == 5){
                    countMatched.add(matchingBonus(onePieceLotto, bonusNumber));
                } else if(value != 5){
                    countMatched.add(matchingPrize(value));
                }
                onePieceLotto.clear();
            }
        }

        return countMatched;
    }

    public static int matchingNumber(List<Integer> onePieceLotto, List<Integer> winningNumber){
        //로또 한 장이 몇 개의 당첨번호와 매치되는지
        int cntMatchingNumber = 0;

        for(int num : onePieceLotto){
            if(winningNumber.contains(num)){
                cntMatchingNumber++;
            }
        }

        return cntMatchingNumber;
    }

    public static Prize matchingBonus(List<Integer> onePieceLotto, int bonusNumber){
        //당첨 번호 5개가 일치할 때 보너스 번호 확인
        if(onePieceLotto.contains(bonusNumber)){
            return Prize.SECOND_PLACE;
        }
        return Prize.THIRD_PLACE;
    }

    public static Prize matchingPrize(int matchingNumber){
        //당첨 번호 일치 개수에 따른 등수 확인
        if(matchingNumber == 3) {
            return Prize.FIFTH_PLACE;
        }
        else if(matchingNumber == 4) {
            return Prize.FOURTH_PLACE;
        }
        else if(matchingNumber == 6) {
            return Prize.FIRST_PLACE;
        }
        return Prize.NO_PLACE;
    }
}
