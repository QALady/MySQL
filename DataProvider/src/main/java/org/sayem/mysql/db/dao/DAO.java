package org.sayem.mysql.db.dao;

import org.sayem.mysql.db.entities.BaseEntity;

import java.io.Serializable;
import java.util.List;

/**
 * Author: Nayeem Islam
 */
public interface DAO<T extends BaseEntity, ID extends Serializable> {
    T findById(ID id);

    List<T> findAll();

    void save(final T entity);
}
