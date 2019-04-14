package com.mevo.statistics.mevo.db;

import com.github.mongobee.Mongobee;
import com.github.mongobee.exception.MongobeeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DbMigration {

    private final static Logger LOGGER = LoggerFactory.getLogger(DbMigration.class);

    public void execute() throws MongobeeException {
        Mongobee runner = new Mongobee("mongodb://localhost:27017/mevo");
        runner.setDbName("mevo");
        runner.setChangeLogsScanPackage("com.mevo.statistics.mevo.db.changelogs");
        runner.execute();
    }
}
