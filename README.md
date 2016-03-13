# Hive UDFs

<b>Hive UDF to remove duplicates from an array</b><br>
hive> ADD JAR hive-udfs-1.0-uber.jar; <br>
hive> CREATE TEMPORARY FUNCTION array_dedup AS 'com.hive.udfs.UdfArrayDeDup';<br>
hive> SELECT array_dedup(array("blah","test","blah")) from table1 limit 1;<br>
["blah","test"]<br>
