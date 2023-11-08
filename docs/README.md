# 미션 - 로또

## 🔍 기능 구현 목록

- 구입 금액을 입력 받는다.
  - 구입 금액을 검증한다.(1000원으로 나눠지는가, 숫자인가, 1000이상 100000이하인가)
- 당첨 번호를 받는다 
  - 당첨 번호를 검증한다.(,을 기준으로 나눴을 떄 6개인가, 중복된 숫자는 없는가, 숫자는 6개인가, 숫자는 1-45사이 인가)
- 보너스 번호를 받는다.
  - 보너스 번호를 검증한다. (숫자인가, 1-45 사이인가, 당첨 번호와 중복된 것은 없는가)
- 로또를 생성한다.
  - 생성할 로또 개수를 구한다.
  - 중복되지 않은 1-45 사이 숫자 6개를 만든다.
  - 생성된 로또들을 저장한다.
  - 생성된 로또의 번호들을 반환한다. 
- 당첨 번호와 보너스 번호를 기반으로 구매한 로또 모두를 매칭해본다.
  - 로또를 하나씩 접근해서 매칭하여 결과를 반환한다.
  - 반환한 결과 리스트를 반환한다. 
- 당첨 결과를 보여준다. 
  - 맞춘 개수와 금액, 당첨 로또의 개수를 보여준다.
  - 사용자의 이익율을 보여준다. 

## 📮 클래스 설계
**_InputValidator_**
  - 구입 금액 검증(validatePurchaseAmount) / 메소드
  - 당첨 번호 검증(validateWinningNumber) / 메소드 
  - 보너스 번호 검증(validateBonusNumber) / 메소드

**_InputException_**
- NOT_IN_RANGE_MONEY
- NOT_DIVIDED_BY_1000
- NO_NUMBER
- NOT_DISTINCTNESS
- NOT_IN_RANGE_LOTTO_NUMBER
- NOT_DISTINCT_BONUS_NUMBER

**_InputView_**
- 구입 금액 읽기(readPurchaseAmount) / 메소드
- 당첨 번호 읽기(readWinningNumbers) / 메소드
- 보너스 번호 읽기(readBonusNUmber) /메소드

**_OutputView_**
- 구매 결과 알림(notifyPurchaseResult) / 메소드
- 당첨 결과 알림(notifyLottoResult) / 메소드

**_Lotto_**
- 6개의 번호(numbers) / 속성
- 번호 조회(getNumbers) / 메소드
- 매칭 (matchWithWinningNumbersAndBonusNumber) / 메소드

**_Lottos_**
- List<Lotto> 복수의 로또 (lottoTickets) / 속성
- 로또 추가 (insertLotto) / 메소드
- 복수 로또 반환 (getLottoTickets) / 메소드
- 일괄 매칭 (matchAll) / 메소드

**_Player_**
- 구입 금액 (purChaseAmount)/ 속성
- 당첨 번호 (winningNumbers) / 속성
- 보너스 번호 (bonusNumber) / 속성
- 수익률 (rateOfReturn) / 속성
- 구입 금액 등록(insertPurchaseAmount) / 메소드
- 당첨 번호 등록(insertWinningNumbers) / 메소드
- 보너스 번호 등록(insertBonusNumber) / 메소드
- 보너스 번호 조회 (getBonusNumber) / 메소드
- 당첨 번호 조회(getWinningNumbers) / 메소드
- 구입 금액 조회(getPurChaseAmount) / 메소드
- 수익률 조회 (getRateOfReturn) / 메소드
- 수익률 계산 (calculateRateOfReturn) / 메소드

**_LottoResultDto_** 
- 매치 숫자 개수 (matchedAmount) / 속성
- 매치 보너스 번호 개수(bonusMatchedAmount) / 속성

**_PurchaseResultDto_**
- 구매된 로또 개수 (size) / 속성
- 구매된 복수의 로또 번호 (lottoNumbers) / 속성

**_Rank_**
- FIFTH_PLACE("3개 일치 (5,000원)"),
- FOURTH_PLACE("4개 일치 (50,000원)"),
- THIRD_PLACE("5개 일치 (1,500,000원)"),
- SECOND_PLACE("5개 일치, 보너스 볼 일치 (30,000,000원)"),
- FIRST_PLACE("6개 일치 (2,000,000,000원)");

**_LottoService_**
- 플레이어 (player) / 속성
- 복수의 로또 (lottos) / 속성
- 입력 검증 (inputValidator) / 속성
- 로또 구매 (purchaseLotto) / 메소드 
- 당첨 번호 등록 (putWinningNumbers) / 메소드 
- 보너스 번호 등록 (putBonusNumber) / 메소드
- 이익률 반환 (getRateOfReturn) / 메소드 
- 로또 매칭결과 반환 (getLottoResult) / 메소드

**_Controller_**
- 서비스코드 (lottoService) / 속성
- 입력 뷰 (inputView) / 속성
- 출력 뷰 (outputView) / 속성
- 로또 구매 (purchaseLotto) / 메소드
- 당첨 번호 입력 (putWinningNumbers) / 메소드
- 보너스 번호 입력 (putBonusNumber) / 메소드
- 결과 조회 (getLottoResult) / 메소드

## 🤔 요구 사항에 대한 분석 (공부 및 적용할 것)
- 로또 클래스를 통한 객체지향 프로그래밍 
- 클린코드
- 테스트 코드의 활용
- 등수에 대한  Enum 활용 

## 🏋️ 적용해보고자 하는 것
- TDD 기반으로 테스트 코드의 장점을 최대한 가져갈 것 
- 일급 컬렉션을 통한 추상화 
- 설계를 통한 적은 리펙토링 