package org.sayem.mysql;

import org.sayem.mysql.annotations.Entity;
import org.sayem.mysql.db.utils.DataProviderUtils;

import org.sayem.mysql.model.ImportData;
import org.sayem.mysql.model.ProdUsers;
import org.sayem.mysql.model.Products;
import org.sayem.mysql.model.Users;

import org.testng.annotations.Test;
import static org.sayem.mysql.enums.Schema.*;
import static org.sayem.mysql.db.utils.DataProviderUtils.*;

/**
 * Author: Nayeem Islam
 */
public class DataProviderTests {

    @Entity(entity = Users.class, schema = AUTOMATION, ids = {1, 2})
    @Entity(entity = ProdUsers.class, schema = PRODUCTION, invocationCount = 5)
    @Test(dataProviderClass = DataProviderUtils.class, dataProvider = GENERIC_DP)
    public void getFirstSampleData(final Users user, final ProdUsers productionUser) {
        System.out.println(Thread.currentThread().getId() + " thread:\n" +
                "User = " + user + "\n" +
                "Production user = " + productionUser + "\n");
    }

    @Entity(entity = ProdUsers.class, schema = PRODUCTION, invocationCount = 1)
    @Entity(entity = Products.class, schema = PRODUCTION, invocationCount = 2, ids = {1})
    @Entity(entity = Products.class, schema = PRODUCTION, ids = {2})
    @Test(dataProviderClass = DataProviderUtils.class, dataProvider = GENERIC_DP)
    public void getSecondSampleData(final ProdUsers user, final Products firstProduct, final Products secondProduct) {
        System.out.println(Thread.currentThread().getId() + " thread:\n" +
                "User = " + user + "\n" +
                "First product = " + firstProduct + "\n" +
                "Second product = " + secondProduct + "\n");
    }

    @Entity(entity = ImportData.class, schema = AUTOMATION)
    @Test(dataProviderClass = DataProviderUtils.class, dataProvider = GENERIC_DP)
    public void getThirdSampleData(final ImportData importData) {
        System.out.println(Thread.currentThread().getId() + " thread:\n" + importData + "\n");
    }

    @Entity(entity = Users.class, schema = AUTOMATION, ids = {1})
    @Test(dataProviderClass = DataProviderUtils.class, dataProvider = GENERIC_DP)
    public void saveFirstSampleData(final Users user) {
        user.setEmail("test.user1@email.com");
        user.setPassword("password1");
        user.save();
    }

    @Entity(entity = Users.class, schema = AUTOMATION, ids = {1})
    @Test(dataProviderClass = DataProviderUtils.class, dataProvider = GENERIC_DP)
    public void saveSecondSampleData(final Users user) {
        user.setEmail("test.user3@email.com");
        user.save();
    }
}
