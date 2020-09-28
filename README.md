# dynamically-switching-datasource-junit-get-post
get http method will access replica database remaining http calls will use original database

This is a spring boot project.

Here we are using two different database.

Idea is something like this

for any read operation we will access readdb and for any other operation we will use modifydb.

where readdb is the replica of modifydb but can used only for reading prupose.

Rquirement is something like this 

for get http call our data source should point to readdb

for remaining http calls data source will point to modifydb

For such case we have to switch datasource dynamically. 

To switch datasource dynamically the key class is AbstractRoutingDataSource.java

Then I used ThreadLocal.java and some other classes.

If you are trying this example and package are not same to my example then please change package name 

DataSourceConfig.java class at basePackages = "org.two.data.source.repository"

I made mistake here by copying someone code so it was throwing error.

Thanks
