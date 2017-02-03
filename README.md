# 헬로 울트라 ( 슬랙 )

## Slack API

### Bot User?

```
The biggest difference between bot users and regular users is that instead of interacting with a team via one of Slack's mobile or desktop apps, bot users are controlled programmatically via a bot user token that accesses one or more of Slack's APIs.
```

[Slack API :BOt User](https://api.slack.com/bot-users)

### API

- Real Time Messaging API
- Event API

[언제 어떤 API를 사용해야하나?](https://api.slack.com/faq#events_api)

- 우리는 플랫폼 독립적인 Bot 시스템을 목표
- 그러나 Bot 특성상 실시간을 지원해야 함.

어떤 봇을 만들 것인가에 따라 다름.

- RTM은 채널기반 소켓통신. 각 채널에 한개씩 소켓 통신을 해야함.
    - 즉 특정 채널의 실시간 이벤트 봇에 적합.
- Event API는 특정 이벤트 발생시 나의 서비스로 이벤트를 hook.
    - 반응은 조금 느릴 수 있으나, 범용적인 서비스에 적합.

[API Home](https://api.slack.com)

[OAuth API](https://api.slack.com/docs/oauth)


[Event API](https://api.slack.com/events-api)

[Event](https://api.slack.com/events)

[Outgoing Webhooks](https://api.slack.com/outgoing-webhooks)