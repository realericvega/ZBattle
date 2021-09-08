package com.goldencodes.zbattle.common;

import java.util.ArrayList;

public class NautArrayList<Elem> implements Iterable<Elem> {

    private ArrayList<Elem> _wrappedArrayList = new ArrayList<Elem>();

    public NautArrayList() {

    }

    public NautArrayList(Elem[] elements) {

    }
}
