# Structure

***
**lotto <br>** 
　┣  **controller <br>**
　┃　└ Controller.java <br>
　┣ **domain <br>**
　┃　└ LottoPrize.java <br>
　┣ **repository <br>**
　┃　└ LottoRepository.java <br>
　┣ **service <br>**
　┃　└ EarningRateService.java <br>
　┃　└ LottoService.java <br>
　┃　└ NumberMatchingService.java <br>
　┣ **validator <br>**
　┃　└ Lotto.java <br>
　┃　└ LottoTicketCount.java <br>
　┃　└ WinningNumbers.java <br>
　┃　└ BonusNumber.java <br>
　┣ **view <br>**
　┃　└ InputView.java <br>
　┃　└ OutputView.java <br>
　┣ **model <br>**
　┗ Application.java <br>
***

# 기능 구현 목록 

-[x] 구입 금액을 입력받음
  -[x] 예외처리, 1000원 단위로 입력 되었는지.
  -[x] 정수로 변환 가능한 형태로 입력되었는지
  -[x] 공백값 입력에 대한 검증
  -[x] 문자열 입력에 대한 검증을 포함
- [x] 구매 가능한 로또 개수를 반환
- [x] 로또 개수만큼 로또 번호 리스트를 생성
- [x] 로또번호 리스트에 들어갈 6개의 로또번호 리스트 생성
  - [x] 중복된 숫자가 입력되지 않았는지 검증
    -[x] 로또 번호 생성시 오름차순으로 정렬
- [x] 당첨 번호 입력 
  - [x] 중복된 숫자 입력 검증
  - [x] ","를 통해 입력값 구분 검증
  - [x] 1~45 사이의 숫자를 입력하는지에 대한 검증
- [x] 입력받은 당첨번호를 리스트에 추가
- [x] 입력 받은 번호를 정수로 반환
- [x] 보너스 번호를 입력받음
  - [x] 1~45 사이의 숫자를 입력하는지 검증
  - [x] 기존 당첨번호와 중복된 숫자가 아닌지 검증
-[x] enum을 통해 당첨 금액 관리 
-[x] 당첨 번호와 번호리스트를 비교하여 당첨여부 확인
- [x] 당첨 등수와 당첨 금액 연결 
- [x] 당첨 등수의 개수를 파악 
- [x] 당첨금과 당첨 횟수에 대한 정보 출력
  - [x] 정확한 format을 설정
- [x] 당첨금의 총액을 구해 구매금액으로 나눔
- [x] %형식에 맞게 포멧을 설정해 수익률 출력



## 클래스별 역할

### Application.java
- 실행 클래스, 
  - controller객체 생성 및 run()

### Controller.java
- lotto 전체 과정을 진행시킴
  - run() 
    - 객체지향적으로 분리해 놓은 메소드들을, 통합하여 실행하는 메소드
  - lottoTicketSetting()
    - while문을 통해 제대로된 입력값이 입력되도록 구성
    - 로또 티켓 생성 로직을 호출함
      - 해당 로직의 호출로 로또 티켓의 갯수를 구함.
  - showTicketCount()
    - 로또 티켓의 개수를 출력
  - lottoResultSetting()
    - 로또 번호와 당첨번호, 보너스 번호를 비교해 저장하는 로직실행
  - showWinningResult()
    - 당첨등수에 따른 결과값을 출력하는 함수 호출
  - showEarningRate()
    - 당첨금 / 구입금을 통해 수익률 계산해 출력
    - 특이사항, 추가 사용이 없기에, 객체내에서 호출해서 처리

### LottoPrize.java
  - 매치된 개수에 따른 당첨금을 enum으로 관리 
  - 해당 개수에 대한 출력 문구를 getDescription 추상클래스를 오버라이딩하여 출력
  - valouOf()
    - 매치 카운트에 해당하는 값을 enum에서 추출해주는 매소드

### LottoRepository.java
  - Controller 클래스에서 관리하던 모든 데이터를 repository로 옮김
  - DTO의 역할을 수행하며 클래스의 데이터저장 부담을 줄여주기 위해 만듬
  - getter와 setter로만 구성

### EarningRateService.java
  - 수익률을 계산하는 로직을 전담하는 클래스
    - calculateEarningRate()
      - 수익률 계산을 내부적으로 진행시킴(아래메소드)
    - calculateEarning()
      - 로또로 얻은 수익을 계산
    - calculateProfitRate()
      - 수익 / 구입금 의 로직을 처리

### LottoService.java
  - Lotto 게임의 진행준비를 담당
  - 구입 갯수 만큼의 로또번호를 준비하는 로직

### NumberMatchingService
  - 로또번호 , winningNumber, bonusNumber을 비교하여 enum에서 결과값을 호출 할 수 있도록 준비
  - 당첨과 관련된 로직들을 처리하는 클래스
  - calculateWinCounts()
    - 실질적으로 클래스내 메소드들을 실행시키는 클래스
    - 호출 해야할 변수가 많고, 클래스 내 메소드를 처리하기 위해 코드 길이가 긴편
  - MatchCount()
    - 로또 1줄의 번호들과 당첨번호를 비교하여 맞춘 개수를 카운트
  - isBonusMatch()
    - 보너스 넘버를 포함한 2등에 해당하는 로또인지를 판별
  - determinePrize()
    - 반환된 값을 바탕으로 몇등에 해당하는지 반환값을 저장
  - initializeWinCount()
    - winCount를 초기화
### validator 패키지의 4가지 클래스
  - 공통적으로, 값들의 유효성검사를 하고, 임시로 값을 저장
  - BonusNumber.java
  - Lotto.java
  - LottoTicketCount
  - WinningNumbers
### InputView.java
  - 입력값 처리
### OutputView.java
  - 출력값 처리

***

## 코드 변화 과정 기록 

#### MVC 패턴을 고려한 코드 구성 준비 (초키 코드 구상)

- lotto
  - controller
    - Controller.java
  - model
    - Lotto.java
    - LottoResult.java
    - LottoTicket.java
  - repository
    - LottoRepository.java
  - service
    - LottoService.java
  - view
    - InputView.java
    - OutputView.java
  - Application.java

***
******************리펙토링 과정에서, 주요 변경사항 *************************
- Controller 내부에서 값들을 모두 저장하는 것으로 방향을 수정, 
- 추후 Controller내의 데이터를 repository로 옮길 예정
- 일부 패키지와 클래스 구조가 변경됨

## 초기 코드 구조에서 수정 사항 발생 이유
- 단계별로 유효성 검사를 수행할 입력값의 존재 
  - validator 패키지를 따로 두고 4가지 클래스로 분류  
- model을 삭제
  - model 에서 유효성검사와, 로직을 폭넓게 다루기보다 service로 기능을 세분화
  - domain 패키지를 추가하여 enum에대한 관리를 하는 방향으로 수정
- repository
  - 구현과정에서 실수를 줄이기 위해 중간 과정에서 삭제후 다시 살리는 것으로 설계함
  - 리펙토링이 끝난 후 Controller가 가지고있는 데이터들을 옮기는 방향으로 수정
- service
  - 번호생성과 결과매칭 수익률계산 세부분의 큰 기능적 층면이 존재한다고 판단

# 추가 refactoring checklist
-[x] Naming 수정
  - 코드 구현 과정에서 lotto, lottoNumber, NumberString등 유사하게 작성된 코드가 많음.
  - 긴 메소드등을 세부적으로 분할하는 과정에서 네이밍수정이 필요함 
  - 클래스명 또한, 외국 로또에서 사용하는 네이밍을 기준으로 하였으나 직관적으로 알아보기 힘든 것 같음
-[x] Controller 내의 메소드 수정
  - 현재 여러기능을 동시에 하는 메소드들이 많음.
  - test과정에서 계속 시간초과가 나서 객체 생성등을 최소화 하려고 합쳐놓은 부분들을 분리해야함
  - 오류값 입력시 중간부터 계속시작해야했기에 while, try-catch구문을 사용했으나 2중 indent에대한 추가 고려 필요해보임
- [x] BonusNumber, WinningNumber
  - 두 클래스의 경우, 입력값 검증 로직에서 유사한 부분이 많음.
  - 클래스를 상속관계로 두어 오버라이딩 하는 수준 에서 처리가 가능해보임
  - 유사한 코드의 중복을 줄이는 방향으로 추가 refactoring 예정.
- [x] Lotto
  - 제공된 클래스를 어떻게 수정해야 할 지 모르겠으나, 오류 검증위주로 코드추가예정
  - randomNumber 추출의 경우 제공된 코드가 있기에 어떻게 수정해 나갈지 미정.
- [x] LottoTicket
  - 해당 검증에 빠진 부분이 있는지 추가 고려 필요
- [x] LottoService
  - switch/case로 구성된 메소드 수정 
  - enum에서 사용 하는 부분에 대해 고려 포함.
- [x] OutputView
  - 고정된 출력형식에 대한 상수화 추가 진행
- [x] 전체 수정사항
  - [x] 구현순서가 제대로 되어있는지 체크할 것.
- [x] 테스트 코드 추가 하기 
  - [x] LottoTicketCount
  - [x] WinningNumbersTest
  - [x] LottoTest
  - [x] BonusNumbersTest
- [x] repository 추가
  - [x] Controller가 게임의 호출기능에 충실하도록 구현