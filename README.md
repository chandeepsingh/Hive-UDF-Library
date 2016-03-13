# Hive UDFs

**Hive UDF to remove duplicates from an array**
```
hive> ADD JAR hive-udfs-1.0-uber.jar;
hive> CREATE TEMPORARY FUNCTION array_dedup AS 'com.hive.udfs.UdfArrayDeDup';
hive> SELECT array_dedup(array("blah","test","blah")) from table1 limit 1;
["blah","test"]
```
