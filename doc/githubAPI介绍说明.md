

## github api使用说明
1. 返回的报文中的时间格式统一为：YYYY-MM-DDTHH:MM:SSZ.请求的header可以设置时区，如果未设置，默认是UTC时间。时区设置例如：curl -H "*Time-Zone: Europe/Amsterdam*"
2. api说明：https://developer.github.com/v3/
2. 需要鉴权认证的接口，有多种认证方式，我们统一使用OAuth2 token (sent in a header)模式。在header中设置。例如下：curl -H "*Authorization: token OAUTH-TOKEN*" https://api.github.com
3. 分析的调用方式:URL后传递参数：?page=2&per_page=100
4. 调用限制：具有认证模式的接口，每个用户的鉴权账号每小时允许调用5000次请求。未鉴权认证模式的接口每小时60次（每个客户端IP）。
5. 每个接口的返回header报文包含了允许调用多少次，剩余多少次，重置的时间。

|Header Name|Description|
|-------------|----|
|X-RateLimit-Limit|The maximum number of requests you're permitted to make per hour.|
|X-RateLimit-Remaining|The number of requests remaining in the current rate limit window.。
|X-RateLimit-Reset|The time at which the current rate limit window resets in UTC epoch seconds.

6. 调用的header需要设置：User-Agent。我们统一配置为：GitHubJava/2.1.5


#### repositories
Repository对象包含项目名称，id，github工程网址，forks数量，watchers数量，issures数量，项目描述，owner的个人主页，id等信息，例如下：
    `{
	"description": "jsopengl livecoding",
	"fork": false,
	"forks": 0,
	"hasDownloads": false,
	"hasIssues": false,
	"hasWiki": false,
	"htmlUrl": "https://github.com/jonbro/jsaxus",
	"id": 5012,
	"name": "jsaxus",
	"openIssues": 0,
	"owner": {
		"avatarUrl": "https://avatars0.githubusercontent.com/u/1597?v=4",
		"collaborators": 0,
		"diskUsage": 0,
		"followers": 0,
		"following": 0,
		"gravatarId": "",
		"hireable": false,
		"htmlUrl": "https://github.com/jonbro",
		"id": 1597,
		"login": "jonbro",
		"ownedPrivateRepos": 0,
		"privateGists": 0,
		"publicGists": 0,
		"publicRepos": 0,
		"totalPrivateRepos": 0,
		"type": "User",
		"url": "https://api.github.com/users/jonbro"
	},
	"private": false,
	"size": 0,
	"url": "https://api.github.com/repos/jonbro/jsaxus",
	"watchers": 0
}`

***
1. 查询所有项目信息：/repositories?since=XXX 这个since是表示查询repositories的id大于since的列表。使用java sdk 查询，其内置每次返回100页。故而需要根据limit=100 与since 进行分页查询。
2. 查询某个组织的项目信息：GET /orgs/***:org***/repos 
3. 查询某个用户的项目信息。GET /users/:username/repos
4. 查询某个项目的贡献值信息。/repos/:owner/:repo/contributors 按照降序排列。
5. 查询某个项目的开发语言信息。GET /repos/:owner/:repo/languages

#### Activety
包含了通知watch，star的活动。
***
1. 查询某个用户感兴趣的所有项目：GET /users/:username/starred
2. 查询对某个项目所有感兴趣的用户：GET /repos/:owner/:repo/stargazers
3. 查询某个项目的所有warchers：GET /repos/:owner/:repo/subscribers
4. 查询某个用户watch过的所有项目：GET /users/:username/subscriptions
4. 

#### User
包含了通知watch，star的活动。
***
1. 查询指定用户的粉丝：GET /users/:username/following
2. 查询指定用户的GPG key：GET /users/:username/gpg_keys
4. 