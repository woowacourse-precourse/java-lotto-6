3주차 미션 - 로또
=========

진행 과정
---
* 투입 금액 입력 (1000원 단위 x n)
* 1 ~ 45 사이의 중복x 숫자 6개 생성 x n회 반복
* 1 ~ 45 사이의 중복x 당첨 숫자 7개 (6 + 1보너스) 인풋
* 당첨(3개 이상 일치)인 경우의 개수 출력
* 수익금 / 구매액의 수익률 계산, 출력

유의사항
---
* "[ERROR]"로 시작하는 메시지 출력 후 입력 다시 받기
* else 쓰지 않기 >> if 조건절 안의 return 
* Java Enum 사용하기
* 제공된 Lotto 클래스 활용하기

- - -

구현할 기능
---

### Purchase 클래스
* 구매액 안내 출력: "구입금액을 입력해 주세요."
* 구매액 입력
  - 숫자가 아니라면 익셉션
    > readNumber()
  - 1,000원 단위가 아니라면 익셉션
    > validate1k()
* (구매액 / 1000) 시행 회수 계산
* 시행 회수 출력: "n개를 구매했습니다."
  > purchaseDone()

### LottoGenerator 클래스
* 시행할 로또번호 6개 x n세트 출력
  > Lotto.printLotto() 호출

### WinningLotto 클래스
* 당첨 번호 안내 출력: "당첨 번호를 입력해 주세요."
* 당첨 번호 6개 입력, 쉼표(,)로 구분
  - 숫자가 아니라면 익셉션
  - 숫자가 6개가 아니라면 익셉션
  - 숫자가 1 ~ 45 사이가 아니라면 익셉션
  - 같은 숫자가 있다면 익셉션
    > setLotto()
* 보너스 번호 안내 출력: "보너스 번호를 입력해 주세요."
* 보너스 번호 1개 입력
  - 숫자가 아니라면 익셉션
  - 숫자가 1 ~ 45 사이가 아니라면 익셉션
  - 당첨 번호와 겹친다면 익셉션
    > setBonus()


### RewardCalculator 클래스
* 각 시행의 당첨 여부 계산
  > calculateWinCount()
* 상금 / 구매액의 수익률 계산
  > calculateReward(), calculateProfit()
* 결과 출력: "당첨 통계", "---"
* 등수에 따른 결과 출력: "a개 일치 (b원) - c개"
* 수익률 출력: "총 수익률은 nn.n%입니다."
  > printResults()


* 입력 예외 시 익셉션 발생
* 에러 메시지 출력 후 재입력


참조 링크\
Link: [Enum1][EnumLink1] [Enum2][EnumLink2] [Exception][ExceptionLink]

[EnumLink1]: https://inpa.tistory.com/entry/JAVA-%E2%98%95-%EC%97%B4%EA%B1%B0%ED%98%95Enum-%ED%83%80%EC%9E%85-%EB%AC%B8%EB%B2%95-%ED%99%9C%EC%9A%A9-%EC%A0%95%EB%A6%AC#enum_%EA%B8%B0%EB%B3%B8_%EB%AC%B8%EB%B2%95
[EnumLink2]: https://howtodoinjava.com/java/enum/enum-with-multiple-values/
[ExceptionLink]: https://woojin.tistory.com/74