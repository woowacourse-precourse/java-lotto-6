# 로또 게임

## 기능 목록

- [0] 사용자로부터 구입금액을 입력받는다 - Player#inputAmount
  - [0] 입력받은 금액이 1,000원 단위로 나누어 떨어지는지 확인한다 - Judgment#divisibleByThousand 
- [0] 사용자가 입력한 구입 금액만큼 로또를 발행한다 - Player#buyLotto
  - [0] 로또 번호를 오름차순으로 정렬한다 - Judgment#lottoSort
- [0] 발행한 로또 번호들을 출력한다 - Player#lottoPrint


- [0] 당첨 번호를 입력받는다 - Judgment#inputNumbers
  - [0] 당첨 번호를 ","를 기준으로 구분하여 반환한다 - Judgment#splitNumbers
  - [0] 입력받은 로또 번호가 1~45 사이의 숫자인지 확인한다 - Judgment#isInRange
- [0] 보너스 번호를 입력받는다 - Judgment#inputBonusNumbers
  - [0] 입력받은 보너스 번호가 1~45 사이의 숫자인지 확인한다 - Judgment#isInRange


- [] 입력받은 로또 번호들의 당첨 여부를 판단한다 - Judgment#checkLotto
    - [] 당첨 번호와 일치하는 개수를 확인하여 등수를 매긴다 - Judgment#rankLotto
      - [] 로또 번호가 당첨 번호에 포함되는지 확인한다 - Judgment#CompareWinningNumber
      - [] 보너스 번호가 일치하는지 확인한다 - Judgment#CompareBonusNumber
- [] 당첨된 로또 목록을 출력한다 - Judgment#printWonLotto
  - [] 로또 등수와 금액을 관리한다 - LottoMatchNumber *enum*
- [] 당첨된 로또로 벌어들인 수익률을 계산한다 - Judgment#calculateProfitRate
- [] 당첨된 로또 수익률을 출력한다 - Judgment#printProfitRate


## 기능 요구 사항

# 예외처리
1. [0] 1000원보다 낮은 구입 금액 입력
2. [0] 1000원으로 떨어지지 않는 금액 입력 Judgment#divisibleByThousand()
3. [0] 1~45 이외의 로또 숫자 입력 Judgment#isInRange
4. [0] 로또 개수가 6개가 아닌 경우 Lotto#validate
5. [0] 로또 번호가 중복될 경우 Judgment#splitNumbers
6. [0] 로또 번호와 보너스 번호가 중복될경우 Judgment#duplicate

# 추가된 요구 사항
    함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.
    함수(또는 메서드)가 한 가지 일만 잘 하도록 구현한다.
    else 예약어를 쓰지 않는다.
    힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
    else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.
    Java Enum을 적용한다.
    도메인 로직에 단위 테스트를 구현해야 한다. 단, UI(System.out, System.in, Scanner) 로직은 제외한다.
    핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 분리해 구현한다.
    단위 테스트 작성이 익숙하지 않다면 test/java/lotto/LottoTest를 참고하여 학습한 후 테스트를 구현한다.



    camp.nextstep.edu.missionutils.Randoms
    List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
    랜덤한 로또 값 생성

    camp.nextstep.edu.missionutils.Console
    Console.readLine();
    사용자 입력 값 받기
