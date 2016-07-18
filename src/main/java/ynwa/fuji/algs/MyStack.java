package ynwa.fuji.algs;

import java.util.ArrayList;
import java.util.EmptyStackException;

/**
 * Created by David Wang on 2016-07-12.
 */
public class MyStack<E> extends ArrayList<E> {
    public MyStack() {
    }

    public E push(E item) {
        add(item);

        return item;
    }

    public E peek() {
        int     len = size();

        if (len == 0)
            throw new EmptyStackException();
        return get(len - 1);
    }

    public E pop() {
        E       obj;
        int     len = size();

        obj = peek();
        remove(len - 1);

        return obj;
    }
}
