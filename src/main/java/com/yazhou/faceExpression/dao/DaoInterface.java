package com.yazhou.faceExpression.dao;

import java.util.List;

/**
 * Created by root on 12/29/15.
 */
public interface DaoInterface<T> {
    void add(T element);

    void delete(long id);

    void update(long id, T element);

    List<T> query(long id);
}
