package org.sayem.mysql.db.entities;

import org.sayem.mysql.db.dao.DAO;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Author: Nayeem Islam
 */
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    private static final long serialVersionUID = 8219313243230767802L;

    @Id
    @GeneratedValue
    private Long id;

    @Transient
    private DAO dao;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public void setDAO(final DAO dao) {
        this.dao = dao;
    }

    @SuppressWarnings("unchecked")
    public void save() {
        dao.save(this);
    }
}
