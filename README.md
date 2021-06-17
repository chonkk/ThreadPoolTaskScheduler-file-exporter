# ThreadPoolTaskScheduler-file-exporter
실행 방법
```
java -Dfile.encoding=UTF-8 -jar DummyADDSLogger-0.0.1.RC1.jar 8 1000 60000 "D:\data\FileCollector\adDecisionInfo_vod" "D:\data\FileCollector\EventLog_vod"

thread=8,
listCount=1000,
delay=60000ms,
firstPath=D:\data\FileCollector\adDecisionInfo_vod,
secondPath=D:\data\FileCollector\EventLog_vod

목적: 광고 결정로그와 광고 시청로그를 생성하여 각각 파일로 제공한다.(tracking id가 양쪽에 남는다.)
```
