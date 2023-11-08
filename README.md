# 💲로또</br>

## 😸프로젝트 구조<br/><hr/>
<img src="java-lotto-diagram.png" alt="diagram">

## 😃프로젝트 내용<br/><hr/>
#### 1. 프로젝트 개요</br>
> 로또를 원하는 수량 만큼 구입하고 당첨 번호와 비교하여 최종 수익률을 구하는 프로그램
#### 2. 프로젝트 기능</br>
> * 원하는 수량 만큼 로또를 구입하는 기능 - PublishLottoUtil.buyLotto()
> * 구입한 로또 만큼 서로 다른 6개의 숫자를 자동 생성하여 발행하는 기능 - PublishLottoUtil.publishLotto()
> * 구입한 로또의 번호를 출력하는 기능 - PublishLottoUtil.showPublishedLotto()
> * 당첨 번호와 비교하여 몇개의 숫자가 동일한 지 확인하는 기능 - ScoreUtil.checkSameNumberCnt()
> * 당첨 결과를 집계하는 기능 -  ScoreUtil.updateScore()
> * 당첨 결과를 토대로 총 획득 상금을 계산하는 기능 - PrizeUtill.calculatePrizeMoney()
> * 로또를 산 금액 대비 총 획등 상금을 비교하여 수익률 계산하는 기능 - PrizeUtil.calculateEarningRate()
> * 잘못된 입력 값에 대해 예외를 발생시키는 기능 - ExceptionHandler
> * 도메인 로직과 예외 기능에 대해 제대로 작동하는 지 단위 테스트 작성 - test > java > domain, validation
> * 상수와 에러 메세지를 따로 관리 - constant > Constants, ErrorMessage
> * View와 Domain을 분리하여 단위 테스트 작성을 용의하게 함.