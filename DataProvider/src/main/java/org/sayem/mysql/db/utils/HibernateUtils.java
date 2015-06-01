package org.sayem.mysql.db.utils;

import org.sayem.mysql.enums.Schema;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import static org.sayem.mysql.enums.Schema.*;
import static org.sayem.mysql.enums.DataSource.*;

/**
 * Author: Nayeem Islam
 */

public final class HibernateUtils {

    private static final Map<Schema, SessionFactory> FACTORIES = Collections.unmodifiableMap((
            new HashMap<Schema, SessionFactory>() {
                {
                    put(AUTOMATION, configureSessionFactory(AUTOMATION_SOURCE.getSource()));
                    put(PRODUCTION, configureSessionFactory(PRODUCTION_SOURCE.getSource()));
                }
            }));

    private HibernateUtils() {
    }

    private static SessionFactory configureSessionFactory(final String dataSource) {
        final Configuration configuration = new Configuration().configure(dataSource);
        final ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();

        return configuration.buildSessionFactory(serviceRegistry);
    }

    public static SessionFactory getSessionFactory(final Schema schema) {
        return FACTORIES.get(schema);
    }
}
