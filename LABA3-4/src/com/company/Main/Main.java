package com.company.Main;

import com.company.Director.Director;
import com.company.Sotrudniki.Sotrudniki;
import com.company.lIST.EmployeesManager;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class Main {

    static {
        new DOMConfigurator().doConfigure("log/log4j.xml", LogManager.getLoggerRepository());
    }

    private static final Logger LOG = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        try {
            LOG.info("Starting program_____________________________");
            //logger.debug("Hello world.");
            Director director = Director.getDirector();
            EmployeesManager manager1 = new EmployeesManager();
            Factories.employeeConsumer(manager1, new IngeneerFactory());
            LOG.info("Manager1");
            manager1.printEmployees();
            LOG.info("Manager2");
            EmployeesManager manager2 = new EmployeesManager();
            manager2.printEmployees();
            LOG.info("End program_____________________________");
        } catch (Exception ex) {
            LOG.error(ex.getMessage());
        }
    }
}
