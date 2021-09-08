package com.goldencodes.zbattle.common;

import org.apache.commons.lang.Validate;

import java.util.HashMap;

public class NautHashMap<KeyType, ValueType> {

    private HashMap<KeyType, ValueType> _wrappedHashMap = new HashMap<KeyType, ValueType>();

    public NautHashMap() {

    }

    public NautHashMap(KeyType[] keys, ValueType[] values) {
        Validate.isTrue(keys.length == values.length, "Keys array and values array must be the same size when making a Map");

        UtilCollections
    }
}
