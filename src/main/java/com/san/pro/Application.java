package com.san.pro;

import com.san.pro.dao.MyDao;
import com.san.pro.resource.MyResource;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.skife.jdbi.v2.DBI;

/**
 * Created by sandeepkumar.s on 10/27/2015.
 */
public class Application extends io.dropwizard.Application<Configuration> {

    public static void main(String[] args) throws Exception{
        new Application().run(args);
    }

    @Override
    public void initialize(Bootstrap<Configuration> bootstrap) {
    }

    @Override
    public void run(Configuration configuration, Environment environment) {
        try {
            final DBIFactory factory = new DBIFactory();
            final DBI jdbi = factory.build(environment, configuration.getDataSourceFactory(), "mysql");
            final MyDao myDao = jdbi.onDemand(MyDao.class);
            environment.jersey().register(new MyResource(myDao));
        } catch (NoClassDefFoundError ex) {

        }

    }
}
