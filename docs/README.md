# 기능 구현 목록

## 입력(예외처리 필요)
- [x] 로또 구입 금액 : GameData#budget
- [x] 당첨 번호 : GameData#winningNumbers
  - [x] 번호는 쉼표(,)를 기준으로 구분
- [x] 보너스 번호 : GameData#bonusNumber

---

## 출력
- ### 게임시작
  - [x] 구입 금액 입력 요청 : view#print#AskBudget
- ### 게임진행
  - [ ] 구매개수 출력 : view#print#LotteriesNumber
  - [ ] 로또별 **무작위** 선정된 **중복되지** 않은 번호 6개 출력
  - [x] 당첨 번호 입력 요청 : view#print#AskwinningNumbers
  - [x] 보너스 번호 입력 요청 : view#print#AskBonusNumber
- ### 실행결과
  - [ ] 당첨통계 : view#print#winningStatistics
    - [ ] 일치 개수 별 당첨금액, 당첨 개수 출력
    - [ ] (일치 개수)개 일치 ((당첨금액)) - (당첨 개수)개
  - [ ] 총 수익률 출력 view#print#
    - [ ] 총 수익률은 (수익율_소수점 둘째자리에서 반올림)%입니다.
- ### 예외, 예외 메시지
  - "[ERROR]"로 시작
  - [ERROR] +(예외문구)

---

## 객체, 변수
- [x] 로또 구입 금액 : GameData#budget
- [x] 발행 로또 수량 : GameData#lotteriesNumber
- [x] 당첨 번호 : GameData#winningNumbers
- [x] 보너스 번호 : GameData#bonusNumber
- [x] 당첨내역 : GameData
  - [x] 당첨금액 합계 : GameData#winningPrizeByRank
- [x] 수익률 : GameData#budgetPrizeRatio
  - [x] 당첨금액 총합 : GameData#totalPrize
  - [ ] 소수점 둘째 자리 반올림
- [x] 로또 클래스
  - [x] 발행 번호 Lotto#numbers
- [x] 당첨 통계
  - [x] 일치개수 Lotto#sameNumberCount
  - [ ] 당첨여부 Lotto#winningFlag ???
  - [] 등수(default = 0) Lotto#rankNumber ???
- [ ] Java Enum -> Rank
  - [x] 등수별 Enum(FIRST, SECOND, THIRD, FOURTH, FIFTH)
  - [x] 등수별 당첨금액
- [x] Java Enum -> NOTICE
  - [x] 프린트 메시지
    - [x] 구입 금액 입력 요청 Notice#AskBudget
    - [x] 당첨 번호 입력 요청 Notice#AskWinningNumbers
    - [x] 보너스 번호 입력 요청 Notice#AskBonusNumber
    - [x] 당첨 통계 출력 Notice#GameStatistics
    - [x] 구분선 출력 Notice#SeparateLine
- [ ] Java Enum -> Error
  - [ ] 당첨(보너스) 번호
    - [x] 숫자가 아닐 경우
    - [x] 쉼표 이외의 문자가 입력될 경우
    - [x] 중복된 숫자가 입력될 경우
      - [ ] 당첨 번호 내 중복 숫자
      - [ ] 당첨 번호와 보너스 번호 간 중복 숫자
    - [x] 범위 밖 숫자가 입력될 경우
  - [ ] 로또 구입 금액
    - [x] 1,000이상
      - [x] 나누어 떨어지지 않는 경우
    - [x] 1,000미만
    - [x] 숫자가 아닌 경우

---

## 메서드
- [x] 메시지 프린트(구입 금액 입력 요청) : view#print#AskBudget
- [ ] 구입 금액으로 로또 구매 개수 계산 : GameData#calculateLotteryCount
  - [ ] 로또 구매 개수 만큼 로또 객체 생성 : Controller#generateLotteries
  - [ ] 생성된 객체별 로또 번호 6자리 생성(생성자 사용_난수) : Lotto#(constructor)
- [ ] 일치개수, 등수 초기화 : GameStatistics#(constructor)
- [x] 메시지 프린트(당첨 번호 입력 요청) : view#print#AskwinningNumbers
  - [x] 당첨 번호 입력받기 : GameData#getWinningNumbersInput
  - [x] 당첨 번호 전환(String[]->Integer) : Convertor#convertWinningNumbersType
  - [ ] GameData 객체 내 당첨 번호 컬렉션에 저장 : GameData#setWinningNumbers
- [x] 메시지 프린트(보너스 번호 입력 요청) : view#print#AskBonusNumber
  - [x] 보너스 번호 입력받기 : GameData#getBonusNumberInput
  - [x] 보너스 번호 전환(String[]->Integer) : Convertor#convertBonusNumberType
  - [ ] GameData 객체 내 보너스 번호 변수에 저장 : GameData#setBonusNumber
- [ ] 로또별 생성 번호랑 당첨 번호+보너스 번호 비교
  - [ ] 이중 for loop/foreach 생성 번호(i)가 당첨번호(j) 중에 있으면 일치개수++ : controller#getWinningCount
  - [ ] 5개가 아닌 경우(normal case)
    - [ ] 일치 개수별 등수 할당 GameData#setRank
  - [ ] 5개인 경우(special case)
    - [ ] 해당 로또는 보너스 번호 찾는 loop 한번 더 돌리기(if->foreach)
      - [ ] 보너스 일치하는 경우 로또객체 등수 변수에 2등값 할당 GameData#setRank
      - [ ] 보너스 일치하지 않는 경우 3등값 할당 GameData#setRank
- [ ] 당첨통계 출력 메서드
  - [ ] 당첨통계 구분지점 메시지 출력 
  - [ ] Rank.foreach
- [ ] (등수별 당첨개수)*(당첨금액) 의 합계 / 로또개수 로 수익률 계산
  - [ ] 등수별 당첨금액 산출(Enum 사용) : Rank#calculatePrizeSumByRank
  - [ ] 당첨금액 총합 산출(Enum 사용) : GameData#calCulateTotalPrize
  - [ ] 수익률 계산 : GameData#calculateBudgetEarningRatio
- [ ] 수익률 출력 메서드

---

## 게임 진행 절차 개요
- 게임 시작 문구 출력
```
구입금액을 입력해 주세요.
```
- 게임 진행 문구1 출력
```
()개를 구매했습니다.
[(당첨번호) * 6개]
```
- 게임 진행 문구2 출력 
```
당첨 번호를 입력해 주세요.
```
- 게임 진행 문구3 출력
```
보너스 번호를 입력해 주세요.
```
- 실행 결과 표시 후 종료
  - 일치 개수 별로 줄바꿈으로 구분
```
()개 일치 ((당첨금액)) - ()개 * 5번
촐 수익률은 (수익률_소수점 둘째자리에서 반올릶(첫째자리까지 표기))% 입니다.
```

---

## 예외처리
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException 발생시킨다.
- "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
- `Exception`이 아닌 `IllegalArgumentException`, `IllegalStateException` 등과 같은 명확한 유형을 처리한다.
- 잘못된 값 예시 
  - 당첨(보너스) 번호
    - 숫자인 경우
      - 1 ~ 45 사이 숫자
      - 중복된 숫자 존재 여부
        - 당첨 번호 끼리
        - 당첨 번호와 보너스 번호간
    - 숫자가 아닌 경우
    - 쉼표(,) 구분 아닌 경우(당첨 번호 only!)
  - 금액
    - 1,000이상
      - 나누어 떨어지는 경우
      - 나누어 떨어지지 않는 경우
    - 1,000미만
    - 숫자가 아닌 경우


## 테스트 코드 작성

---

## 요구사항

- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용
  - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
  - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 방법은 함수(또는 메서드)를 분리하면 된다.
- 3항 연산자를 쓰지 않는다.
- 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- JUnit 5와 AssertJ를 이용하여 본인이 정리한 목록이 정상 동작함을 테스트 코드로 작성한다.
- 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.
  - 함수(또는 메서드)가 한 가지 일만 하도록 구현한다.
- else 예약어를 사용하지 않는다.
  - 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
  - switch/case문 사용 금지
- Java Enum을 적용한다.
- 도메인 로직에 단위 테스트를 구현해야 한다. 단, UI(System.out, System.in, Scanner) 로직은 제외한다.
  - 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 분리해 구현한다.
  - 단위 테스트 작성이 익숙지 않다면 `test/java/lotto/LottoTest`를 참고하여 학습한 후 테스트를 구현

### Lotto 클래스

- 제공된 `Lotto` 클래스를 활용해 구현
- `number`의 접근 제어자인 private을 변경할 수 없다.
- `Lotto`에 필드(인스턴스 변수) 추가 금지
- `Lotto`의 패키지 변경은 가능한다.