출력
==

* * * 

## 게임 상태와 결과 출력
1. 구입 금액을 입력해 주세요.
2. N개를 구매했습니다.
3. 구매 로또 N개 출력 
   > [1, 2, 3, 4, 5, 6]
4. 당첨 번호를 입력해 주세요.
5. 보너스 번호를 입력해 주세요.
6. 당첨 통계 출력
    > 당첨 통계   
    > *---*  
    > 3개 일치 (5,000원) - 0개   
    > 4개 일치 (50,000원) - 0개    
    > 5개 일치 (1,500,000원) - 0개   
    > 5개 일치, 보너스 볼 일치 (30,000,000원) - 0개  
    > 6개 일치 (2,000,000,000원) - 0개
7. 수익률 출력
   > 총 수익률은 0.0%입니다.

* * * 

## 입력에 대한 예외 처리
> * OutputView의 displayERRORMESSAGE()를 통해 에러 출력

### 1. 구입 금액의 예외 처리
   >- 공백인 경우
   >  * [ERROR] 돈은 공백을 허용하지 않습니다.

   >- 정수가 아닌 값이 입력된 경우
   >  * [ERROR] 돈은 정수만 입력할 수 있습니다.

   >- 10만원이 넘어간 경우
   >  * [ERROR] 돈은 최소 1000원, 최대 100000원 입니다.
   
   >- 1000원 단위가 아닌 경우
   >  * [ERROR] 돈은 1000원 단위 입니다.
### 2. 로또 당첨 각 번호의 예외 처리
   >- 공백인 경우
  >  * [ERROR] 로또 번호는 공백을 허용하지 않습니다.

   >- 정수가 아닌 경우
   >  * [ERROR] 로또 번호는 정수만 입력 가능합니다.

   >- 1보다 작고 45보다 큰 경우
   >  * [ERROR] 로또 번호는 최소 1, 최대 45 입니다.
### 3. 로또 당첨 번호의 예외 처리
   >- 공백인 경우
   >  * [ERROR] 로또 번호는 공백을 허용하지 않습니다.

   >- 보너스 번호를 포함 하지 않은 로또 당첨 번호의 크기가 맞지 않는 경우
   >  * [ERROR] 로또 번호는 6개의 숫자 입니다.

   >- 중복된 숫자가 입력된 경우
   >  * [ERROR] 로또 번호는 겹치도록 숫자를 입력할 수 없습니다.
### 4. 로또 당첨 보너스 번호의 예외 처리
   >- 공백인 경우
   >  * [ERROR] 로또 번호는 공백을 허용하지 않습니다.

   >- 보너스 번호를 포함 하지 않은 로또 당첨 번호의 크기가 맞지 않는 경우
   >  * [ERROR] 로또 번호는 6개, 보너스 번호는 1개 입니다.

   >- 중복된 숫자가 입력된 경우
   >  * [ERROR] 로또 번호는 겹치도록 숫자를 입력할 수 없습니다.

* * *

## 시나리오

* * *

### 1. InputView를 통해 로또 구매 금액을 입력 받고 검증한다.
   - 만약 잘못된 값이 입력된 경우 입력을 다시 받는다.
   - 올바른 입력인 경우 Money 객체를 생성한다.
### 2. 로또 구매 금액을 통해 로또 구매 횟수 만큼 로또를 생성한다.
   - 생성된 Money 객체로 부터 구매 횟수를 받는다.
   - 구매 횟수를 통해 Lotto의 List를 가지고 있는 Lottos 객체를 생성한다.
   - 생성은 아래와 같이 생성한다.
<pre>
<code>
Money money = getMoneyFromUser();
Lottos lottos = new Lottos(money.getTryNumber());
</code>
</pre>
### 3. Outputview를 통해 생성된 로또를 출력한다.
- 구매 횟수 만큼 출력한다.
### 4. 로또 당첨 번호를 입력 받는다.
- 만약 잘못된 값이 입력된 경우 입력을 다시 받는다.
- 올바른 입력인 경우 WinningLotto 객체를 생성한다.
### 5. 로또 당첨 보너스 번호를 입력 받는다.
- 만약 잘못된 값이 입력된 경우 입력을 다시 받는다.
- 올바른 입력인 경우 WinningLotto 객체에 존재하는 리스트에 추가한다.
<pre>
<code>
addBonusNumber(winningLotto, getBonusNumber());
</code>
</pre>
### 6. 로또 당첨 여부를 확인한다.
- 입력된 당첨 번호의 수(7)만큼 존재하는지 비교한다.
- 1등 당첨의 경우 7번 째 숫자와 비교하기 전 이미 6개가 모두 맞는 경우 count 값을 하나를 더해서 1등과 구분하도록한다.
<pre>
<code>
private int checkFirstRank(int state, int count) {
        if (state == 5 && count == 6) {
            count++;
        }
        return count;
    }
</code>
</pre>
### 7. OutputView를 통해 Judgemnet가 반환한 로또 당첨 결과와 수익률을 출력한다.
- Lottos 객체에 존재하는 맞는 숫자를 통해서 등수를 판단한다
- 3개 맞는 경우 5등, 4개는 4등, 5개는 3등, 5개와 보너스가 맞는 경우는 2등, 기존 번호 6개가 다 맞는 경우 1등으로 판단한다.
- 각 등수에 따른 count의 값은 5등 3, 4등 4, 3등 5, 2등 6, 1등 7이다

* * *

## 클래스의 구성

* * *

### controller

* * *

- LottoController
  - 도메인과 도메인, 도메인과 뷰를 상호작용시키는 클래스

### domain

* * *

#### Lotto
- List<*Integer*> numbers = 로또 번호를 저장하는 리스트

#### Lottos
- List<*Lotto*> lottos = 구매한 만큼의 로또를 저장하는 리스트
- List<*Integer*> winningCounts = 당첨 로또와 비교했을 때 맞는 갯수를 저장하는 리스트

#### WinningLotto
- private final List<Integer> numbers = 당첨 로또를 저장하는 리스트

#### Money
- String money = 입력한 돈을 저장한다. 
- public void addBonusNumber(String bonus_number)
  - 보너스 번호를 추가할 때 번호의 값이 올바른지 판단하고 올바를 경우 리스트에 추가한다.
  - 올바르지 않을 경우 예외를 처리한다.

#### Judgement
- 로또 번호들을 가진 Lottos와 당첨 로또 번호인 WinningLotto를 넘겨주면 로또 번호를 비교하여 얼마나 맞았는지 계산한다.
- public void checkLottoNumber(Lottos lottos, WinningLotto winningLotto)
  - 각 로또 번호를 반복시행하기 위해 실행 
- private int checkWinningNumberCount(List<Integer> compare_lotto, List<Integer> winning_lotto)
  - 입력된 로또 번호와 당첨 번호를 비교하여 얼마나 맞았는지 한다.
  - 맞을 경우 1을 더하고 아닐경우 0을 더하여 맞는 갯수를 확인 할 수 있도록 한다.
  - count는 각 맞은 갯수를 반환하고 1등일 경우 count를 하나 더 더한다
- private int compareNumber(int number, List<Integer> compare_lotto)
  - 로또 번호와 비교하여 맞으면 count는 1을 반환한다.
- private void checkAddLottoCount(Lottos lottos, int count)
  - 3보다 큰 경우(당첨 금액을 받을 수 있는 경우)만 lottos 객체에 존재하는 winningCounts에 넣는다. 
- public List<Integer> judgeAllLottoRank(Lottos lottos)
  - 저장된 winningCounts에 존재하는 값을 등수별로 위치하도록 한다.
- private void judgeLottoRank(List<Integer> rank, int count)
  - count 값에 따른 등수를 정하고 위치에 따른 값에 1을 더하여 몇 개인지 확인 할 수있도록 한다.
- public float calculateEarningRate(List<Integer> ranks, Money money)
  - 각각의 당첨 금액과 횟수를 곱한 값을 더하여 수익을 계산하고 수익률을 퍼센트로 만들어 return한다.

#### Ranking
- FIRST, SECOND, THIRD, FOURTH, FIFTH
  - 각 등수에 따른 상수 선언
- private final int rank = 등수
- private final String message = 등수에 따른 출력 메시지
- public static String getMatchRankMessage(int rank)
  - 등수에 따라 출력하는 메시지를 얻는 함수

### util

* * * 
util은 모두 정적 메서드를 가진다.   
무분별한 생성자를 사용하지 못하도록 private으로 사용하였다.

#### LottoNumberGenerate
- 사용자가 입력한 돈을 통해 횟수를 입력 받아 입력 받은 만큼 로또를 생성한다.
#### WinningLottoGenerate
- 사용자가 입력한 로또 번호 "1,2,3,4,5,6"을 토대로 ","를 통해 숫자를 나누고 숫자가 올바른지 판단하고 올바를 경우 추가한다.
- 올바른 숫자가 아니라고 판단 될 경우 예외를 발생시킨다.


### validator

* * *

#### LottoNumberValidator 
- 하나의 로또에 대한 예외처리
#### MoneyValidator
- 입력된 돈에 대한 예외처리
#### NumberValidator
- 하나의 로또에 포함된 숫자 하나 하나에 대한 예외처리

### view

* * *

#### InputView
- Lotto 게임에 필요한 데이터를 가져온다
  - 공백 예외를 발생시킬 수 있다.

#### OutputView
- 사용자의 출력을 담당한다.
