## 구현해야할 기능들
### 1) 입출력 틀 잡기
#### 입력
- 로또 구매 금액
- 당첨 번호 6자리 (쉼표로 구분) 
- 보너스 번호


### 2) 입출력 형태 완성하기
입력한 금액을 1000원으로 나누었을 떄 몇개의 로또가 구매 가능한지를 계산하였고

그렇게 계산된 로또 개수만큼 Lotto 클래스 형 객체 lotto 를 생성시켜 각 객체 필드인 numbers 에 1~45 까지의 랜덤한 수를 만들어 할당하였다

그런 다음 로또 번호를 오름차순으로 정렬 후 출력

당첨 번호를 String 으로 입력 받고 이를 구분문자 (",") 기준으로 split 하여 winningNumbers 안에 할당

보너스 번호도 입력 받고 변수 bonus 에 할당



`### 3) 일치 조건 계산하고 출력하기 
`
5+b 의 경우는 인덱스 6에 
6 개가 다 일치하는 경우는 인덱스 7에 배정


### 4) **입**력 조건 예외 처리


### 5) 중간 리팩토링
- CalcCash -> calculateNuimberOfLotto
- 금액 입력 받기 -> getPurchaseAmount 메서드로 만들기
- 당첨 번호, 보너스 번호 입력 메서드로 만들기 : getWinningNumbers, getBonusNumber
- 일치 조건 찾기와, 및 출력 분리
- 
#### 5) 수익률 기능 추가

수익률 오버플로우


```agsl
        // 수익 계산
        // 전체 상금
        double totalPrize = calculateTotalPrize(matchCounts, prizeMoney);
        // 전체 구매 비용
        double totalCost = matchCounts[0] * 1000; // 1장당 1000원
        // 수익률 계산
        double profitRate = ((totalPrize - totalCost) / totalCost) * 100.0;
        profitRate = Math.round(profitRate * 10) / 10.0; // 소수점 둘째 자리에서 반올림

        System.out.println("총 수익률은 " + profitRate + "% 입니다.");


    // 총 수익 계산하는 메서드
    private static double calculateTotalPrize(int[] matchCounts, int[] prizeMoney) {
        double totalPrize = 0;
        for (int i = 3; i < matchCounts.length; i++) {
            totalPrize += matchCounts[i] * prizeMoney[i];
        }
        return totalPrize;
    }
```