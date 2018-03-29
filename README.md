
Create a keyspace in Cassandra
Create a table in Cassandra

Some Cassandra commands:
    describe keyspaces;
    use twitter;
    describe tables;

    create table twitter.streamtweet (id text PRIMARY KEY, user text, message text);

    insert into twitter.streamtweet(id,user,message) values('1','Chaminda W','I love Scala');