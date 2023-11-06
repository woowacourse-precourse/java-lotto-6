## 진행 순서
1. 구입 금액 입력
2. 구매 금액만큼 로또 출력
3. 당첨번호 입력
4. 보너스 번호 입력
5. 당첨 통계 출력

<br>
<br>

## 예외 상황
1. 1. 공백 입력
   2. 문자 입력
   3. 1,000원 단위로 나누어 떨어지지 않을 때


3. 1. 공백 입력
   2. 문자 입력
   3. , 로 구분했는데 6개가 아닐때
   4. 1~45 사이의 숫자가 아닐 때
   5. 중복 숫자가 있을 때


4. 1. 공백 입력
   2. 문자 입력
   3. 1~45 사이의 숫자가 아닐 때
   4. 중복 숫자가 있을 때

<br>
<br>

## 기능 구현

0. 시작 - `Controller.startLotto()`
###
1. 1. 구입 금액 출력 - `OutputView`
   2. 구입 금액 입력 - `InputView.purchaseLottoAmount()`
   3. 예외 처리 - `Exception`
   4. 몇개를 살 수 있는지 - `Controller.getPrice()`
###
2. 1. 가능한 개수 출력 - `OutputView`
   2. 가능한 개수 만큼
      1. 랜덤 숫자 6개 생성 - `LottoService.createLotto()`
         1. 오름차순으로 정렬 후 로또 생성 - `LottoService.getLotto()`
      2. 정렬 된 6개 수 출력 - `OutputView`
###
3. 1. 당첨 번호 출력 - `OutputView`
   2. 당첨 번호 입력 - `InputView.chooseWinningNum()`
   3. 예외 처리 - `Exception`
   4. , 로 구분하기 - `InputService.getStringToList()`
###
4. 1. 보너스 번호 입력 - `OutputView`
   2. 보너스 번호 입력 - `InputView.chooseBonusNum()`
   3. 예외 처리 - `Exception`
   4. 보너스 번호 처리 - `InputService.getBonusNum()`
###
5. 1. 구매한 로또와 당첨 로또 번호 비교 - `Controller.winningStats()`
      1. 구매한 로또와 당첨 로또 일치하는 개수 구하기 - `StatisticsService.winningStats()`
         ####
         1. 각 로또가 당첨 번호랑 몇개 겹치는지 리스트에 저장함 - `StatisticsUtil.getMatchCount()`  
         
            ex) [0, 4, 1, 0, 4, 2, 0, 1, 1, 0] : 0개일치 4개, 1개일치 3개, 2개일치 1개, 4개일치 2개
         ####
         2. 위에서 저장한 등수 리스트에서 각 등수가 몇개인지 저장함 - `StatisticsUtil.matchCountFrequency()`  
         
            ex) [4, 3, 1, 0, 2, 0, 0, 0] : 0개일치 4개, 1개일치 3개, 2개일치 1개, 4개일치 2개, 나머지 0개일치
         ####
      2. 5개 일치할 시 나머지 한개가 보너스 번호와 일치하는지 구하기 - `StatisticsUtil.check2ndPlace()`
      3. 3~6개 일치시 출력하기 - `OutputView`
      #####
   2. 수익률 구하기 - `StatisticsService.returnRate()`
      1. 당첨 로또 총 금액 구하기 - `StatisticsUtil.getTotalReward()`
      2. 총 금액과 구입 금액을 통해 수익률 구하기 - `StatisticsUtil.getReturnRate()`
      3. 총 수익률 출력하기 - `OutputView`
   