package com.hive.udfs;

/**
 *
 * @author chandeepsingh 
 * Hive UDF to remove duplicates from an array
 */

import org.apache.hadoop.hive.ql.exec.UDFArgumentException;
import org.apache.hadoop.hive.ql.metadata.HiveException;
import org.apache.hadoop.hive.ql.udf.generic.GenericUDF;
import org.apache.hadoop.hive.serde2.objectinspector.ListObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspectorUtils;

import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

public class UdfArrayDeDup extends GenericUDF {

    ListObjectInspector myObj = null;

    @Override
    public ObjectInspector initialize(ObjectInspector[] arguments)
            throws UDFArgumentException {

        myObj = (ListObjectInspector) arguments[0];
        return ObjectInspectorUtils.getStandardObjectInspector(myObj);
    }

    @Override
    public Object evaluate(DeferredObject[] arguments) throws HiveException {

        List<?> myArr = (List<?>) ObjectInspectorUtils.copyToStandardObject(arguments[0].get(), myObj);
        HashSet<Object> myHashSet = new HashSet<>();

        myHashSet.addAll(myArr);

        if (myHashSet != null) {
            return new ArrayList<>(myHashSet);
        } else {
            return null;
        }
    }

    @Override
    public String getDisplayString(String[] input) {
        return new String();
    }
}
