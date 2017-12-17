package com.card;

import java.util.Comparator;

public class Compara implements Comparator<Cards> {
    @Override
    public int compare(Cards o1, Cards o2) {
       return o1.getName().compareTo(o2.getName());
    }


}
