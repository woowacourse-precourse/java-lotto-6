# 로또 게임

## 기능정리 

#### 1.컨트롤러 에서 각 서비스 초기화
#### 2.LottoNumBerService, LottoTicKetService 호출 -> 로또 번호를 발행 
#### 3.LottoResultService 를 호출 -> 발행된 로또 번호를 당첨 번호와, 보너스 번호를 가지고 비교 하여 결과를 생성 
#### 4.ProfitService를 호출 -> 계산된 결과를 가지고 총 수익률을 계산

## 컨트롤러 -> LottoController

### 모델,뷰,유틸은 서로간의 의존성은 없다 전부 서비스를 통해서 이용되며 서로간의 존재를 모른다.

컨트롤러는 각 서비스 들을 초기화 하고 서비스를 순서대로 실행 시키는 역활을  한다. 


## 서비스 o 
1. LottoNumBerServoice -> 로또 발행 서비스 o
로또 한장을 발행 해주는 서비스

2. LottoTicKetService - > 로또 티켓 서비스 o
유저에게 금액을 입력 받아 금액 만큼 로또 를 발행 하여 PurchaseAmount 모델에 저장 

3. LottoResultService -> 로또 결과 서비스 o
유저에게 당첨 번호와 보너스 번호를 입력 받고 로또 한장씩 당첨 번호 와 비교 해서 몆개 가 당첨 됬는지 
구한다음 해당 로또와 당첨 번호 수 를 같이 LottoWinnging Result 모델 에 파라미터로 보냄 

4. ProfitService -> 최송 수익률 계산 서비스


## 모델

### 데이터 모델 
1. Lotto 모델 -> 로또 한장에 대한 정보를 같고 있는 모델 객체 
2. LottoSet -> 금액 만큼 생성 된 Lotto 객체 들이 저장되는곳
3. LottoWinningResult -> 결과 계산이 끝난 로또 갹체가 키값과 함계 저장 되는곳
4. ProfitRate -> 최종 수익률 을 저장하고 있는 객체

### 입력 모델 
1. 보너스 넘버 모델  -> 보너스 넘버를 담고 있는 객체 
2. PurchaseAmount -> 구입 금액을 담고 저장하고 있는 갹체 
3. WinningNumber -> 당첨 번호룰 담고 저장 하고 있는 객체 


## 뷰 
GeneralInputOutput -> System.input, output 을 감싸고 있는 객체 
Inputview -> 게임에서 입력 을 받는 모든 메소드 
OutputView -> 게임에서 출력 해야되는 모든 메소드 

## 유틸 
UserPromptConverter -> 유저 입력 받는 값에 대해 형번환을 진행 한다 


## 예외처리 







 







