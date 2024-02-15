1.安装nacos

a.到官网下载最新版本： https://github.com/alibaba/nacos/releases/download/2.2.2/nacos-server-2.2.2.tar.gz
b.解压后修改配置文件: vi application.properties
#启用鉴权
nacos.core.auth.enabled=true
nacos.core.auth.server.identity.key=gdex
nacos.core.auth.server.identity.value=gdex
nacos.core.auth.plugin.nacos.token.secret.key=SecretKey012345678901234567890123456789012345678901234567890123456789
#数据库信息配置
spring.datasource.platform=mysql
db.num=1
db.url.0=jdbc:mysql://127.0.0.1:3306/nacos_config?characterEncoding=utf8&connectTimeout=1000&socketTimeout=3000&autoReconnect=true&useUnicode=true&allowPublicKeyRetrieval=true&sslMode=DISABLED&serverTimezone=UTC
db.user.0=root
db.password.0=root

启动
cd /Users/wucaiqiang/soft/nacos/bin
sh startup.sh -m standalone
sh shutdown.sh

控制台
http://localhost:8848/nacos
帐号与密码：nacos,Qq5201314.?

2.docker 数据库启动
docker start mysql
docker stop mysql
帐号与密码：root,root

3.redis启动
/usr/local/redis/bin/redis-server /usr/local/redis/redis-cluster/7001/redis.conf
/usr/local/redis/bin/redis-server /usr/local/redis/redis-cluster/7002/redis.conf
/usr/local/redis/bin/redis-server /usr/local/redis/redis-cluster/7003/redis.conf
/usr/local/redis/bin/redis-server /usr/local/redis/redis-cluster/7004/redis.conf
/usr/local/redis/bin/redis-server /usr/local/redis/redis-cluster/7005/redis.conf
/usr/local/redis/bin/redis-server /usr/local/redis/redis-cluster/7006/redis.conf

kill -9 pid

创建集群
/usr/local/redis/bin/redis-cli -a Redis@2023 --cluster create --cluster-replicas 1 127.0.0.1:7001 127.0.0.1:7002 127.0.0.1:7003 127.0.0.1:7004 127.0.0.1:7005 127.0.0.1:7006
验证
redis-cli -h 127.0.0.1 -p 7001 -a Redis@2023 #客户端远程连接某个节点，要输入对应的ip、端口、密码






