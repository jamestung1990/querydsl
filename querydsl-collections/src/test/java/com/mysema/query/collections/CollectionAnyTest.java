package com.mysema.query.collections;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class CollectionAnyTest extends AbstractQueryTest {

    @Test
    public void Any_In_Projection() {
        Cat a = new Cat("a");
        Cat aa = new Cat("aa");
        Cat ab = new Cat("ab");
        Cat ac = new Cat("ac");
        a.setKittens(Arrays.asList(aa,ab,ac));
        
        Cat b = new Cat("b");
        Cat ba = new Cat("ba");
        Cat bb = new Cat("bb");
        b.setKittens(Arrays.asList(ba, bb));
        
        List<Cat> kittens = MiniApi.from(QCat.cat, Arrays.asList(a,b)).list(QCat.cat.kittens.any());
        assertEquals(Arrays.asList(aa,ab,ac,ba,bb), kittens);
        
    }
    
}
